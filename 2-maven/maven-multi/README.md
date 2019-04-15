# Multi module maven project
The project contains 3 modules:
- `projects-service` - a jar project
- `users-service` - a jar project
- `web` - a WAR project

The project intentionally has a library conflict.
To resolve the conflict there are several commented snippets in the POM files.
Each snippet resolves the conflicting library versions of `guava` in different ways. 
 
### Build
`mvn clean install`

### Run
1. `cd web`
2. `mvn jetty:run`

### Test the running project 
- Clink on [http://localhost:8080/users] - you will receive an error. Fix it by uncommenting one of the sections in the `web/pom.xml` and restarting the application
- Clink on [http://localhost:8080/projects]
- Clink on [http://localhost:8080/resources] 


## Deploy to company repository

### 1. Start Nexus server
It takes a while for the server to start
`docker rm nexus`
`docker run -d -p 8081:8081 --name nexus -e NEXUS_CONTEXT=nexus sonatype/nexus3:3.16.0`

Go to http://localhost:8081/nexus/ and wait for the server to start.

User and password are: admin/admin123

### 2. Deploy the application 
`mvn clean deploy -s settings.xml`

Check the deployed artifacts at http://localhost:8081/nexus/#browse/browse:maven-snapshots:com%2Fbuild%2Ftools%2Ftraining


## Release the project