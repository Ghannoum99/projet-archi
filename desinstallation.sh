#!/bin/sh
rm -f ressources*.jar creneaux.dat personnes.dat reservations.dat salles.dat
cd ressources_si
mvn clean
cd ../ressources_ihm
mvn clean
cd ..