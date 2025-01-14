FROM litongjava/jdk:8u391-stable-slim

# Set the working directory in the container
WORKDIR /app

# Copy the jar file into the container
COPY target/college-bot-data-manager-1.0.jar /app/

# Command to run the jar file
CMD ["java", "-jar", "tio-boot-api-table-demo-1.0.jar","--app.env=prod"]
