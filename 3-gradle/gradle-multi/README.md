# Multi module gradle project
The project contains 3 modules:
- `projects-service` - a jar project
- `users-service` - a jar project
- `web` - a WAR project

The project intentionally has a library conflict.
To resolve the conflict there are several commented snippets in the `build.gradle` files.
Each snippet resolves the conflicting library versions of `guava` in different ways. 
 
### Build
`./gradlew clean build`

### Run
`./gradlew :web:appRun`

### Test the running project 
- Clink on [http://localhost:8080/users] - you will receive an error. Fix it by uncommenting one of the sections in the `web/build.gradle` and restarting the application
- Clink on [http://localhost:8080/projects]
- Clink on [http://localhost:8080/resources] 
