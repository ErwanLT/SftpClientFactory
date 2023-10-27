# SftpClientFactory

![java CI](https://github.com/ErwanLT/SftpClientFactory/actions/workflows/maven.yml/badge.svg?event=push)

Une usine pour créer et gérer les clients SFTP en utilisant Apache Commons Pool 2.

## Description

La classe `SftpClientFactory` est conçue pour créer et gérer les clients SFTP en utilisant Apache Commons Pool 2. Elle crée des clients SFTP en utilisant la bibliothèque SSHJ et les met en pool pour une utilisation efficace.

## Table des matières

- [Installation](#installation)
- [Utilisation](#utilisation)
- [Exemples](#exemple)
- [Configuration](#configuration)
- [Tests](#tests)
- [Contribuer](#contribuer)
- [Licence](#licence)

## Installation

Pour utiliser cette usine, assurez-vous de suivre ces étapes :

1. Incluez cette classe dans votre projet.

2. Assurez-vous d'avoir les dépendances nécessaires, y compris Apache Commons Pool 2, SSHJ, et d'autres dépendances liées à votre projet.

## Utilisation

Pour utiliser la classe `SftpClientFactory` dans votre projet, suivez ces étapes :

1. Créez une instance de `SftpProperties` avec les informations de configuration SFTP.

2. Instanciez la classe `SftpClientFactory` en lui passant les `SftpProperties`.

3. Utilisez l'usine pour créer et gérer des clients SFTP.

## Exemple
```java
public static void main(String[] args) {
    SftpProperties sftpProperties = new SftpProperties();
    SftpClientFactory factory = new SftpClientFactory(sftpProperties);

    SFTPClient sftpClient = factory.create();
    // Utilisez le client SFTP pour télécharger ou téléverser des fichiers, etc.

    factory.destroy();
}
```

## Configuration
Assurez-vous que votre projet est correctement configuré pour inclure Apache Commons Pool 2 et SSHJ. Vous devez également définir correctement les propriétés SFTP dans l'objet SftpProperties.

## Tests
Ce projet est livré avec des tests unitaires pour la classe ConnexionThread. Les tests sont écrits en utilisant JUnit, une bibliothèque de test Java populaire.

Pour exécuter les tests, assurez-vous d'avoir JUnit configuré dans votre projet. Ensuite, exécutez les tests à l'aide de votre environnement de développement ou de la ligne de commande.

## Contribuer
Si vous souhaitez contribuer à ce projet, suivez ces étapes :

1. Fork ce projet.
2. Créez une nouvelle branche avec votre nom de fonctionnalité ou correctif.
3. Effectuez les modifications ou ajoutez de nouvelles fonctionnalités.
4. Soumettez une demande d'extraction (Pull Request) vers la branche principale de ce projet.

## Licence
Ce projet est sous licence MIT. Consultez le fichier [LICENSE](LICENSE) pour plus de détails.

