#!/usr/bin/env bash
mvn clean compile assembly:single
cp ./target/base-2.0-SNAPSHOT-jar-with-dependencies.jar ./bratwurst.jar
