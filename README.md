# SftpClientFactory
Un projet Java pour gérer la connexion SSH d'un client SFTP à l'aide de la classe `ConnexionThread`.

## Description

Ce projet est conçu pour illustrer la manière de gérer la connexion SSH d'un client SFTP en utilisant la classe `ConnexionThread`. La classe `ConnexionThread` étend la classe `Thread` et permet de gérer les tentatives de connexion, la réconnexion en cas d'échec et la gestion des exceptions.

## Table des matières

- [Installation](#installation)
- [Utilisation](#utilisation)
- [Exemples](#exemples)
- [Tests](#tests)
- [Contribuer](#contribuer)
- [Licence](#licence)

## Installation

Pour utiliser ce projet, suivez les étapes ci-dessous :

1. Clônez ce référentiel sur votre système local.
```bash
git clone https://github.com/votre-utilisateur/votre-projet.git
```
2. Assurez-vous d'avoir les dépendances requises installées, y compris Java, JUnit, et toute autre dépendance spécifique au projet.

## Utilisation
Pour utiliser la classe ConnexionThread dans votre propre projet, suivez ces étapes :

Importez la classe ConnexionThread dans votre code.
```java
import fr.eletutour.thread.ConnexionThread;
```

## Exemples
Voici un exemple simple d'utilisation de la classe ConnexionThread :

```java
public static void main(String[] args) {
    SSHClient sshClient = new SSHClient();
    SftpProperties sftpProperties = new SftpProperties();

    ConnexionThread connexionThread = new ConnexionThread("MyThread", sshClient, sftpProperties);
    connexionThread.start();

    // Attendez que le thread de connexion se termine, si nécessaire
    try {
        connexionThread.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
```

# Tests
Ce projet est livré avec des tests unitaires pour la classe ConnexionThread. Les tests sont écrits en utilisant JUnit, une bibliothèque de test Java populaire.

Pour exécuter les tests, assurez-vous d'avoir JUnit configuré dans votre projet. Ensuite, exécutez les tests à l'aide de votre environnement de développement ou de la ligne de commande.

# Contribuer
Si vous souhaitez contribuer à ce projet, suivez ces étapes :

1. Fork ce projet.
2. Créez une nouvelle branche avec votre nom de fonctionnalité ou correctif.
3. Effectuez les modifications ou ajoutez de nouvelles fonctionnalités.
4. Soumettez une demande d'extraction (Pull Request) vers la branche principale de ce projet.

## Licence
Ce projet est sous licence MIT. Consultez le fichier [LICENSE](LICENSE) pour plus de détails.
