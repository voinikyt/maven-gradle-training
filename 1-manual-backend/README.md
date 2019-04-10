# Manual War Project
Aims to show the difficulties of building a project without a build tool

# Instructions
All the manual tasks are in `build.sh` file.
It's a bash script and contains commands that are usually performed by a build tool:
- compiling main java classes with compilation classpath
- copying of main resources
- compiling test classes with test classpath
- copying of test resources
- running tests with test with all classpaths
- packaging application with runtime libraries 

### Source bash commands - provide build commands to current terminal session
`source build.sh`

### Remove the previous build artifacts
`clean`

### Build the project
`build`

### Run the tests
`test`

### Package the project
`package`

### Run the project
`run` 

### Test the running project 
Clink on [http://localhost:8080/users]