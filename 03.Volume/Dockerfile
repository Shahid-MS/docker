# Use the official OpenJDK image from the Docker Hub
FROM openjdk:20

# Set the working directory in the container
WORKDIR /myapp

# Copy the current directory contents into the container at /sumapp
COPY . .

# Compile the Java program
RUN javac NameToFile.java

# Run the Java program
CMD ["java", "NameToFile"]

