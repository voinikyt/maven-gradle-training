#!/usr/bin/env bash

function clean {
    rm names.war
    rm -rf build
}
function build {
    mkdir -p build/WEB-INF/classes
    javac -cp "./lib/*" src/*.java -d build/WEB-INF/classes
    rsync -r --exclude=javax.servlet-api-4.0.1.jar lib build/WEB-INF/
}

function package {
    jar -cvf names.war -C build .
}
function run() {
    java -jar server/jetty-runner-9.4.15.v20190215.jar names.war
}