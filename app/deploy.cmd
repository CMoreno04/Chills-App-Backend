@echo off
setlocal

REM Define variables
set SQL_FILE_PATH=.\sql\chillisdb.sql
set MYSQL_CONTAINER=app-db-mysql-chillis-1
set MYSQL_PASSWORD=rootroot

REM Step 1: Pull the latest code
echo Pulling latest code from the repository...
git pull origin main

REM Step 2: Build the Maven project
echo Building Maven project...
mvn clean package -DskipTests

REM Step 3: Build the Docker image
echo Building Docker image...
docker build -t chillisrestaurant-app:latest .

REM Step 4: Deploy using Docker Compose
echo Deploying using Docker Compose...
docker-compose up -d

REM Copy the .sql file to the MySQL container
echo Copying .sql file to the MySQL container...
docker cp "%SQL_FILE_PATH%" "%MYSQL_CONTAINER%":schema.sql

REM Load the schema into MySQL inside the container
echo Loading schema into MySQL...
docker exec -it "%MYSQL_CONTAINER%" cmd /c mysql -h 127.0.0.1 -P 3306 -u root -p%MYSQL_PASSWORD% chillisdb< schema.sql

REM Cleanup: Remove the .sql file from the container
echo Cleaning up: Removing .sql file from container...
docker exec -it "%MYSQL_CONTAINER%" cmd /c del schema.sql

echo Schema loaded successfully!

echo Pipeline completed successfully!

endlocal
