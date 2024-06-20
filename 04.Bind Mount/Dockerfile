# Use the official OpenJDK image from the Docker Hub
FROM openjdk:20

# Set the working directory in the container
WORKDIR /myapp


COPY ./Servers.java .
COPY ./servers.txt ./

# Compile the Java program
RUN javac Servers.java

# Run the Java program
CMD ["java", "Servers"]

