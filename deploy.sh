#!/bin/bash

# Exit immediately if a command exits with a non-zero status.
set -e

SQL_FILE_PATH="/app/sql/chillisdb.sql"
MYSQL_CONTAINER="app-db-mysql-chillis-1"
MYSQL_PASSWORD="rootroot"

# Step 1: Pull the latest code
echo "Pulling latest code from the repository..."
git pull origin main

cd app
# Step 2: Build the Maven project
echo "Building Maven project..."
mvn clean package -DskipTests

cd ..
# Step 3: Build the Docker image
echo "Building Docker image..."
sudo docker build -t chillisrestaurant-app:latest .

# Step 4: Deploy using Docker Compose
echo "Deploying using Docker Compose..."
sudo docker-compose up -d

# Copy the .sql file to the MySQL container
echo "Copying .sql file to the MySQL container..."
sudo docker cp "$SQL_FILE_PATH" "$MYSQL_CONTAINER":schema.sql

echo "Waiting for MySQL to start..."
sudo sleep 20   # waits for 20 seconds

# Load the schema into MySQL inside the container
echo "Loading schema into MySQL..."
sudo docker exec -it "$MYSQL_CONTAINER" bash -c "mysql -u root -p$MYSQL_PASSWORD < schema.sql"

# Cleanup: Remove the .sql file from the container
echo "Cleaning up: Removing .sql file from container..."
sudo docker exec -it "$MYSQL_CONTAINER" rm schema.sql

echo "Schema loaded successfully!"

echo "Pipeline completed successfully!"
