commands to compile and run:
1. Create the project and create your protobuf file with interface details (request messgae, response message, service)
2. Configure your pom.xml to include grpc libraries, protobuf compiler and protobuf compile maven plugin. Refer the one in the project.
3. run `mvn package`
4. this will compile and generate the java files from the protobuf file.
5. create your server (App.java in the example)
6. create your client (AppClient.java in the example)
7. run `mvn clean package install`
8. Go to target folder. execute the jar with dependency.
9. To test the server, execute the client using `java -cp <jar-with-dependecy> <fully.qualified.classname.of.client>`
