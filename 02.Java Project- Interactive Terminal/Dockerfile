# Use the official OpenJDK image from the Docker Hub
FROM openjdk:20

# Set the working directory in the container
WORKDIR /sumapp

# Copy the current directory contents into the container at /sumapp
COPY . .

# Compile the Java program
RUN javac Sum.java

# Run the Java program
CMD ["java", "Sum"]

