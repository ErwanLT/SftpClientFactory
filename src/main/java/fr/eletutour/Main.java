package fr.eletutour;

import fr.eletutour.factory.SftpClientFactory;
import fr.eletutour.model.SftpProperties;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        System.out.printf("Hello and welcome!");
        SftpProperties properties = new SftpProperties();
        properties.setRemoteHost("127.0.0.1");
        properties.setUsername("test");
        properties.setPassword("password");
        properties.setMaxConnexionAttempt(5);
        properties.setTimeBetweenConnexionAttempt(1000);

        SftpClientFactory factory = new SftpClientFactory(properties);


    }
}