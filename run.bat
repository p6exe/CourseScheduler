@echo off
echo Initializing database...
mysql -u root -p -e "CREATE DATABASE IF NOT EXISTS courseScheduler;"
 
echo Compiling...
javac -cp .;mysql-connector-j-9.6.0.jar src/*.java -d test
 
echo Running...
java -cp .;test;mysql-connector-j-9.6.0.jar MainFrame
pause