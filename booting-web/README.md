# booting-web
spring boot web example to build and run a simple static html page.

This application contains an html that greets with "Hello Spring Boot" when invoked on htpp://localhost:8080/

# Pre-requisites
1. Install jdk 11
2. Install maven
3. Install an IDE (if you want to run from the IDE)
4. Install docker (if you want to run the docker image)

# 1.Build and RUN from IntelliJ
1. Download the project into your workspace
2. Import the project into IntelliJ
3. Right click and run BootingWebApplication from src/main/java/com/nkarri/sb/bootingweb/
4. Open your browser and type "http://localhost:8080/" to see the welcome message "Hello Spring Boot"
5. Stop the BootingWebApplication

# 2. Build and RUN from maven
1. Download the project into your workspace
2. Go inside booting-web module
3. run the command "mvn clean package"
4. Go inside target/
5. run the command "java -jar booting-web-0.0.1-SNAPSHOT.jar"
6. Open your browser and type "http://localhost:8080/" to see the welcome message "Hello Spring Boot"
7. Stop and close the terminal that is running the jar

# 3. Build and RUN from docker
1. Download the project into your workspace
2. Go inside booting-web module
3. run the command "docker build -t booting-web ."
4. Above docker build command should build the image and tag it. If you see any failure, run the "mvn clean install" first then run the above docker build again.
5. start the docker image on port 8080 by running this command "docker run -p 8080:8080 -d booting-web"
6. Open your browser and type "http://localhost:8080/" to see the welcome message "Hello Spring Boot"
7. run the command "docker ps" to see the running docker image with Image ID/Container ID
8. To stop the image copy the Container ID from step 7 and run the command "docker stop <<Cotainer ID>>"