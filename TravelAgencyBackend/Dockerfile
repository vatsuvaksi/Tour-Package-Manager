# Use the official Maven image as the build environment
FROM maven:3.8.4-openjdk-11 AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml file to the working directory
COPY ./pom.xml /app/pom.xml

# Download the dependencies
RUN mvn dependency:go-offline

# Copy the source code to the working directory
COPY ./src /app/src

# Build the JAR file
RUN mvn clean install

# Use the official Java 11 image as the base image
FROM openjdk:11

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the builder stage to the working directory
COPY --from=builder /app/target/Assignment-1.0-SNAPSHOT.jar /app/Assignment-1.0-SNAPSHOT.jar

# Set the entry point to execute the JAR file
ENTRYPOINT ["java", "-jar", "Assignment-1.0-SNAPSHOT.jar"]
