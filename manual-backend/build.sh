#!/usr/bin/env bash

function clean {
    rm -rf build
}
function build {
    mkdir -p build/{war/WEB-INF/classes,tests}
    javac -cp "./libs/compile/*:./libs/runtime/*" src/main/*.java -d build/war/WEB-INF/classes
    cp src/main/users.csv build/war/WEB-INF/classes
    rsync -r libs/runtime build/war/WEB-INF/
    mv build/war/WEB-INF/runtime build/war/WEB-INF/lib
}

function test {
    javac -cp "./libs/compile/*:./libs/runtime/*:./libs/test/*:./build/war/WEB-INF/classes" src/test/*.java -d build/tests
    cp src/test/response.json build/tests
    java -cp "./libs/compile/*:./libs/runtime/*:./libs/test/*:./build/war/WEB-INF/classes:./build/tests" \
        torg.junit.runner.JUnitCore com.build.tools.training.web.UsersServiceTest
}

function package {
    jar -cvf build/users.war -C build/war .
}

function run() {
    java -jar server/jetty-runner-9.4.15.v20190215.jar build/users.war
}