#!/bin/sh
cd ressources_si
mvn clean install
cd ../ressources_ihm
mvn clean package
cd ..
cp ressources_si/target/ressources_si-0.0.1.jar ressources_si.jar
cp ressources_ihm/target/ressources_ihm-0.0.1.jar ressources_ihm.jar