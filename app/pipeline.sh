#!/bin/bash

# Exit immediately if a command exits with a non-zero status.
set -e

SQL_FILE_PATH="/Users/cmoreno/Documents/Projects/chills-restaurant-midterm/backend/app/sql/chillisdb.sql"
MYSQL_CONTAINER="app-db-mysql-chillis-1"
MYSQL_PASSWORD="rootroot"

# Step 1: Pull the latest code
echo "Pulling latest code from the repository..."
git pull origin main

# Step 2: Build the Maven project
echo "Building Maven project..."
mvn clean package -DskipTests

# Step 3: Build the Docker image
echo "Building Docker image..."
docker build -t chillisrestaurant-app:latest .

# Step 4: Deploy using Docker Compose
echo "Deploying using Docker Compose..."
docker-compose up -d

# Copy the .sql file to the MySQL container
echo "Copying .sql file to the MySQL container..."
docker cp "$SQL_FILE_PATH" "$MYSQL_CONTAINER":schema.sql

# Load the schema into MySQL inside the container
echo "Loading schema into MySQL..."
docker exec -it "$MYSQL_CONTAINER" bash -c "mysql -u root -p$MYSQL_PASSWORD < schema.sql"

# Cleanup: Remove the .sql file from the container
echo "Cleaning up: Removing .sql file from container..."
docker exec -it "$MYSQL_CONTAINER" rm /tmp/schema.sql

echo "Schema loaded successfully!"

echo "Pipeline completed successfully!"
