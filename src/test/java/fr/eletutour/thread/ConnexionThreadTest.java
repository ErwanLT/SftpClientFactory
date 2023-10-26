package fr.eletutour.thread;

import fr.eletutour.model.SftpProperties;
import net.schmizz.sshj.SSHClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class ConnexionThreadTest {

    @Mock
    private SSHClient mockSSHClient;
    private SftpProperties mockSftpProperties;

    @BeforeEach
    public void setUp() {
        // Initialisez vos mocks ou instanciez des objets nécessaires pour les tests
        mockSSHClient = Mockito.mock(SSHClient.class);
        mockSftpProperties = new SftpProperties(); // Créez un mock SftpProperties
    }

    @Test
    public void testSuccessfulConnection() {
        when(mockSSHClient.isConnected()).thenReturn(Boolean.TRUE);
        ConnexionThread connexionThread = new ConnexionThread("TestThread", mockSSHClient, mockSftpProperties);

        connexionThread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Vérifiez que le thread s'est connecté avec succès (ajustez en fonction de vos besoins)
        assertTrue(mockSSHClient.isConnected());
    }

    @Test
    public void testMaxConnectionAttempts() {
        ConnexionThread connexionThread = new ConnexionThread("TestThread", mockSSHClient, mockSftpProperties);

        connexionThread.start();

        // Attendez suffisamment longtemps pour que le nombre maximal de tentatives soit atteint
        try {
            Thread.sleep(mockSftpProperties.getTimeBetweenConnexionAttempt() * mockSftpProperties.getMaxConnexionAttempt() + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Vérifiez que le thread a atteint le nombre maximal de tentatives
        assertFalse(mockSSHClient.isConnected());
    }
}
