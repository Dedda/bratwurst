#!/usr/bin/env bash
if [ ! -f ./target/bratSe-2.0-SNAPSHOT-jar-with-dependencies.jar ]; then
    ./jar.sh
fi
java -jar ./target/bratSe-2.0-SNAPSHOT-jar-with-dependencies.jar ./src/test/testprogram.bw