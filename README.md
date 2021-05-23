# Projet-JEE : Gestion d'absence

## Introduction :

En perspective d'améliorer la participation des élèves aux cours à distance d'un établissement scolaire, ce projet amène une solution parmi d'autre pour la gestion des présences. Il s’agit d'une application web JEE qui permet aux professeurs d’une école de suivre les absences de leurs groupes d’élèves qui peuvent affirmer leur présence à l’aide d’un code QR ( <a href="https://github.com/slaoui452/Projet-JEE/wiki">WIKI</a> ). L'application est présentée en plusieurs parties :

- Créer un projet Spring Boot
- Créer les entités JPA
- Configurer le Data source (MySQL)
- Créer les interfaces JPA Repository basées sur Spring Data
- Créer la couche DAO
- Créer la couche métier (Interface et Implémentation)
- Créer la couche Web basée sur Spring MVC en utilisant Tymeleaf comme moteur de templates.
- Créer les interfaces graphiques. 

## Utilisation de l’application :

### Conditions préalables :

* <a href="https://www.apachefriends.org/fr/index.html">Xampp</a> afin de mettre en place un `serveur Web local`.
* <a href="https://www.eclipse.org/downloads/packages/release/kepler/sr2/eclipse-ide-java-ee-developers">Eclipse</a> IDE for `Java EE Developers`.
* Installation de `Spring Tool Suite` sur Eclipse.

### Téléchargement du repository :

Placez-vous dans le dossier dans lequel vous voulez tester et faites :
```
git clone https://github.com/slaoui452/Projet-JEE.git
```

### Sur Eclipse :

Importez le projet sur Eclipse Workspace pour le tester, modifier ou le visualiser :
```
File -> Import -> Maven -> Existing Maven project
```
### Sur PhpMyAdmin :

Démarrer `Apache` et `MySQL` sur Xampp puis rendez-vous sur `localhost/phpmyadmin` ou vous allez créer une nouvelle base de données au Nom de 'matable1' et exécutez `DB_Test.sql` sur la partie SQL. Cette base de données est destinée pour tester les différentes fonctionnalités de notre application.

### Lancement :

Il ne vous reste que d'exécuter le code java et Accéder à `localhost:8890/index` pour lancer et tester l'application.
