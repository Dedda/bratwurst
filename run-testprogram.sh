#!/usr/bin/env bash
if [ ! -f ./target/base-1.0-SNAPSHOT-jar-with-dependencies.jar ]; then
    ./jar.sh
fi
java -jar ./target/base-1.0-SNAPSHOT-jar-with-dependencies.jar ./src/test/testprogram.bw