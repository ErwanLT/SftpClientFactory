package fr.eletutour.factory;

import fr.eletutour.model.SftpProperties;
import fr.eletutour.thread.ConnexionThread;
import net.schmizz.keepalive.KeepAliveProvider;
import net.schmizz.sshj.DefaultConfig;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.SFTPClient;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class SftpClientFactory extends BasePooledObjectFactory<SFTPClient> {

    private SSHClient sshClient;

    private SftpProperties sftpProperties;

    public SftpClientFactory(SftpProperties sftpProperties) {
        this.sftpProperties = sftpProperties;

        DefaultConfig defaultConfig = new DefaultConfig();
        defaultConfig.setKeepAliveProvider(KeepAliveProvider.KEEP_ALIVE);
        sshClient = new SSHClient(defaultConfig);
        
        initConnexion();
    }

    private void initConnexion() {
        ConnexionThread connexionThread = new ConnexionThread("SFTP connexion", sshClient, sftpProperties);
        connexionThread.start();
    }

    @Override
    public SFTPClient create() throws Exception {
        return sshClient.newSFTPClient();
    }

    @Override
    public PooledObject<SFTPClient> wrap(SFTPClient sftpClient) {
        return new DefaultPooledObject<>(sftpClient);
    }
}
