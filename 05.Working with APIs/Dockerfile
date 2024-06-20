# Use the official OpenJDK image from the Docker Hub
FROM openjdk:20

# Set the working directory in the container
WORKDIR /myapp


COPY . .

# Compile the Java program
RUN javac -cp "lib/json-20210307.jar" -d bin src/CatFacts.java

# Run the Java program
CMD ["java", "-cp", "lib/json-20210307.jar:bin", "CatFacts"]


