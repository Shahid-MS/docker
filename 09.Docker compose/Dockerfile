# Use the official OpenJDK image from the Docker Hub
FROM openjdk:20

# Set the working directory
WORKDIR /myapp

# Copy the application source and wait-for-it script to the container
COPY . .

# Make the wait-for-it script executable
RUN chmod +x wait-for-it.sh

# Compile the Java program
RUN javac -cp "lib/mysql-connector-j-8.4.0.jar" -d bin src/EmployeeManager.java

# Define the entrypoint
ENTRYPOINT ["./wait-for-it.sh", "mysqldb:3306", "-t", "30", "--", "java", "-cp", "lib/mysql-connector-j-8.4.0.jar:bin", "EmployeeManager"]