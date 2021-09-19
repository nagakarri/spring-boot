# cake-manager
spring boot microservice demo for Cake Manager API.



# Pre-requisites
1. Install jdk 11
2. Install maven
3. Install an IDE (if you want to run from the IDE)
4. Install docker (if you want to run the docker image)

# 1.Build and RUN from IntelliJ
1. Download the project into your workspace
2. Import the project into IntelliJ
3. Right click and run CakeManagerApplication from src/main/java/com/nkarri/waracle/cakemanager/
4. Open your browser and type "http://localhost:8080/" to see all available cakes
5. Stop the CakeManagerApplication

# 2. Build and RUN from maven
1. Download the project into your workspace
2. Go inside cake-manager module
3. run the command "mvn clean package"
4. Go inside target/
5. run the command "java -jar cake-manager-0.0.1-SNAPSHOT.jar"
6. Open your browser and type "http://localhost:8080/" to see all available cakes
7. Submit "Add New Cake" form to add a new cake
8. Stop and close the terminal (that is running the jar) to exit the application

# 3. Build and RUN from docker
1. Download the project into your workspace
2. Go inside cake-manager module
3. run the command "docker build -t cake-manager ."
4. Above docker build command should build the image and tag it. If you see any failure, run the "mvn clean install" first then run the above docker build again.
5. start the docker image on port 8080 by running this command "docker run -p 8080:8080 -d cake-manager"
6. Open your browser and type "http://localhost:8080/" to see all available cakes
7. Submit "Add New Cake" form to add a new cake
8. run the command "docker ps" to see the running docker image with Image ID/Container ID
9. To stop the image copy the Container ID from step 7 and run the command "docker stop <<Cotainer ID>>"

#Endpoint "/"
This application displays all available cakes in a web page for http GET on endpoint "/" i.e. htpp://localhost:8080/

This application creates a new cake from the "Add New Cake" on htpp://localhost:8080/

You can use browser to test the above endpoints
#REST API Endpoint "/cakes"
This application gets all available cakes in json format for http GET on endpoint "/cakes" i.e. htpp://localhost:8080/cakes

This application create a new cake for http POST on endpoint "/cakes" i.e. htpp://localhost:8080/cakes when invoked with json body.
Example body {"number": "12", "name":"Chocolate mud cake", "info": "We think we’ve found the ultimate mud cake – it’s rich, dense and oh so chocolatey."}

You can use curl command or a suitable tool like Postman to test the above REST endpoints