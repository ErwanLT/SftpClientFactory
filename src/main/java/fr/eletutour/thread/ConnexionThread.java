package fr.eletutour.thread;

import fr.eletutour.exception.SftpException;
import fr.eletutour.model.SftpProperties;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.io.IOException;

public class ConnexionThread extends Thread{
    private static final Logger LOGGER = LoggerFactory.getLogger(ConnexionThread.class);

    private final String remoteHost;
    private final String username;
    private final String password;
    private final int maxConnexionAttempt;
    private final long timeBetweenConnexionAttempt;

    private final SSHClient client;

    private int connexionAttempt = 0;

    public ConnexionThread(String name, SSHClient sshClient, SftpProperties sftpProperties) {
        super(name);
        this.client = sshClient;
        this.remoteHost = sftpProperties.getRemoteHost();
        this.username = sftpProperties.getUsername();
        this.password = sftpProperties.getPassword();
        this.maxConnexionAttempt = sftpProperties.getMaxConnexionAttempt();
        this.timeBetweenConnexionAttempt = sftpProperties.getTimeBetweenConnexionAttempt();
    }

    @Override
    public void run() {
        while (connexionAttempt < maxConnexionAttempt){
            boolean isConnected = client.isConnected();
            try {
                if (isConnected){
                    LOGGER.info("SFTP client connected");
                    connexionAttempt = 0;
                    sleep(timeBetweenConnexionAttempt);
                } else {
                    LOGGER.info("SFTP is disconnected");
                    LOGGER.info("Connection attempt number {} of {}", connexionAttempt+1, maxConnexionAttempt);
                    connexionAttempt++;

                    client.addHostKeyVerifier(new PromiscuousVerifier());
                    client.connect(remoteHost);
                    client.authPassword(username, password);
                    client.getConnection().getKeepAlive().setKeepAliveInterval(300);
                }
            } catch (InterruptedException e) {
                LOGGER.error("Error of sleeping thread", e);
            } catch (IOException e) {
                LOGGER.error("Error while trying to connect", e);
                try {
                    sleep(timeBetweenConnexionAttempt);
                } catch (InterruptedException ex) {
                    LOGGER.error("Error of sleeping thread", e);
                }
            }

        }
        throw new SftpException("Max connexion attempt reached", HttpStatus.I_AM_A_TEAPOT);
    }
}
