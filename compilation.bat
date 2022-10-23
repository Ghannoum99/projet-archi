cd ressources_si
call mvn clean install
cd ..\ressources_ihm
call mvn clean package
cd ..
copy /y ressources_si\target\ressources_si-0.0.1.jar ressources_si.jar
copy /y ressources_ihm\target\ressources_ihm-0.0.1.jar ressources_ihm.jar