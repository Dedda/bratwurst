#!/usr/bin/env bash
if [ ! -f bratwurst.jar ]; then
    ./jar.sh
fi
java -jar bratwurst.jar -t --test-suite src/test/testSuite.bw