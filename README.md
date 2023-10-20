# Dépendances
* Maven
* JDK 11 (ORACLE)

# Installation de JDK 11
* Télécharger le JDK https://jdk.java.net/11/
Pour vérifier la version de java on execute la commande `java -version`
![image](https://github.com/youtus/Back/assets/83721477/a063a0ff-8360-4252-bb89-e18de607613e)

# Installation de Maven
* Télécharger Apache-Maven: https://maven.apache.org/install.html
* Ajouter le répertoire `bin` du répertoire créé apache-maven-3.9.5 à la variable d'environnement `PATH`.
![image](https://github.com/youtus/Back/assets/83721477/0ada9e06-1ac2-4547-b8a3-25c431876775)
* Confirmez avec `mvn -v` dans un nouveau shell.
  ![image](https://github.com/youtus/Back/assets/83721477/c8e42c5d-2fb3-475b-a7c4-91d63414a5f1)

# Compiler le Projet
Par la suite dans la racine du projet executer la commande `mvn clean install`. Cela installera les librairies nécessaires au fonctionnement du projet

Le projet est désormais prêt à être compiler
