# Use the official OpenJDK image from the Docker Hub
FROM openjdk:20

# Set the working directory in the container
WORKDIR /myapp


COPY . .

# Compile the Java program
RUN javac -cp "lib/mysql-connector-j-8.4.0.jar" -d bin src/EmployeeManager.java

# Run the Java program
CMD ["java", "-cp", "lib/mysql-connector-j-8.4.0.jar:bin", "EmployeeManager"]


