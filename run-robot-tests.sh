#!/bin/bash

ls src/test/robot/*.robot | xargs robot
rm log.html
rm output.xml
rm report.html
rm selenium-screenshot*