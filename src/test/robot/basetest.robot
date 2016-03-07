*** Settings ***

Library    Selenium2Library

*** Keywords ***

Open Browser To Index Page
    Open Browser    http://localhost:9999/index?testparameter=2  Firefox

Go To Index Page
    Go To   http://localhost:9999/index?testparameter=2

*** Test Cases ***

Index
    Open Browser To Index Page
    wait until page contains element    xpath=//div[text()='Your Number: 2' and @id='param-out']

Close
    Close Browser