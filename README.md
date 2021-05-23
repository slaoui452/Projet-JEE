# Projet-JEE : Gestion d'absence



# Table of contents
1. [Introduction :](#introduction)
2. [Principe :](#Principe)
    1. [Authentification :](#Authentification)
    2. [Interface étudiant :](#étudiant)
    3. [Interface Professeur :](#Professeur)
3. [Conclusion :](#Conclusion)
4. [Utilisation de l’application :](#Utilisation)

## Introduction : <a name="introduction"></a>

En perspective d'améliorer la participation des élèves aux cours à distance d'un établissement scolaire, ce projet amène une solution parmi d'autre pour la gestion des présences. Il s’agit d'une application web JEE qui permet aux professeurs d’une école de suivre les absences de leurs groupes d’élèves qui peuvent affirmer leur présence à l’aide d’un code QR ( <a href="https://github.com/slaoui452/Projet-JEE/wiki">WIKI</a> ). L'application est présentée en plusieurs parties :

- Créer un projet Spring Boot
- Créer les entités JPA
- Configurer le Data source (MySQL)
- Créer les interfaces JPA Repository basées sur Spring Data
- Créer la couche DAO
- Créer la couche métier (Interface et Implémentation)
- Créer la couche Web basée sur Spring MVC en utilisant Tymeleaf comme moteur de templates.
- Créer les interfaces graphiques. 



## Principe: <a name="Principe"></a>
### Authentification : <a name="Authentification"></a>
Pour l’authentification, on a opté pour une page contenant deux actions d’identification, une pour les élèves et l’autre pour les professeurs.

![](/images/1.PNG "Optional title")

#### Authentification des étudiants :
![](/images/2.PNG "Optional title")

#### Authentification des professeurs et choix du groupe : 
![](/images/3.PNG "Optional title") 


### Interface étudiant : <a name="étudiant"></a>

Après l’insertion du code d’identification, l’étudiant est dirigé vers une page qui indiquera si une conférence est active. Si c'est le cas cette page contiendra le code QR qui permettra son accès, et enregistrera sa présence.

![](/images/5.PNG "Optional title")

L’étudiant pourra donc scanner le code QR avec son smartphone pour générer le mot de passe crypté. Il est à noter que cette opération ne restera plus valable si le professeur met fin à la séance. 

Si le code est valide :

![](/images/6.PNG "Optional title")


Apres son authentification, même s’il n’y a pas de cours, l'étudiant aura l’accès à son propre tableau d’absence.

![](/images/7.PNG "Optional title")


### Interface Professeur :  <a name="Professeur"></a>

Après insertion du code d’identification et le groupe concerner par le cours, le professeur serait redirigé vers une page ou deux actions sont possibles :

![](/images/8.PNG "Optional title")

* Clôturassions de la séance.
* Affichage de la liste de présence du groupe enseigné.

Il est à noter que durant la séance le professeur peut se renseigner sur ceux qui ne sont pas encore présenté.

![](/images/9.PNG "Optional title")


## Conclusion : <a name="Conclusion"></a>
Cette application de gestion d’absence a une importance très considérable au niveau éducatif. En effet, elle facilitera aux professeurs d’examiner les absences d’une part, et aux étudiants de pointer leur présence et consulter leurs absences.


## Utilisation de l’application : <a name="Utilisation"></a>

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

Il ne vous reste que d'exécuter le code java et Accéder à `localhost:8890/index` pour lancer et tester l’application.
