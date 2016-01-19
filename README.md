#proxibanqueV4

##Installer ojdbc6 dans un module maven

Créer répertoire lib à la racine du module.

Coller ojdbc6.jar à l'intérieur.

Se placer dans le répertoire lib en invite de commande :

    cd C:\...\dao-springdata\lib
  
Installer le jar avec la commande maven suivante :

    mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0.3 -Dpackaging=jar -Dfile=ojdbc6.jar -DgeneratePom=true

##Ajouter la dépendance dans le pom.xml du module (si nécessaire):

  <dependency>
        <groupId>com.oracle</groupId>
        <artifactId>ojdbc6</artifactId>
        <version>11.2.0.3</version>
  </dependency>
  
##Identifiants base de donnée

username : user7
password : user7
