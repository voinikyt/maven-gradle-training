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

### 1. Start Nexus server as described in the deployment instructions
Wait for:
- Nexus to appear at http://localhost:8081/nexus
- Gitea to appear at http://localhost:3000/


### 2. Attach the maven-multi project to the Gitea remote
`git init` 
`git remote add origin http://localhost:3000/test/maven-multi.git`
'git fetch origin master'
`git checkout master` 
 
### 3. Release the project 
1. Delete all remote tags - `git tag -l | xargs -n 1 git push --delete origin`
2. Delete all local tags - `git tag | xargs git tag -d`
3. Build the release and tag it in SCM - `mvn --batch-mode release:prepare -DreleaseVersion=0.4.0`
4. Deploy the release to the Nexus repository -`mvn release:perform -s settings.xml`
