# Web_Automation_With_Selenium_TestNG

## Technology used in this project
- Selenium
- TestNG Library

## Project Scenarios
- Login to orange hrm demo site
https://opensource-demo.orangehrmlive.com/
- Create 2 new employees and save it to a JSON list
- Now go to PIM dashboard and search by 1st user name. Assert that the user is found.
- Now click on the user from the search table and update id by random userid
- Now again search the user by new user id from the PIM dashboard menu and assert that the user is found
- Now logout from admin and login with the 2nd user from your JSON list
- Now click on My Info menu
- Select Gender and Blood Type and save it
- Click on contact details and input address and email
- Logout the user

## How to run this project
- Clone this project
- Open it any IDE (IntelliJ)
- Hit the command `gradle clean test`

## How to Generate Allure Report
- Give the following commands by opening terminal in the project folder to create Allure Report
- `allure generate allure-results --clean -o allure-report`
- `allure serve allure-results`

## Selenium TestNG Automation Report Image

<img width="1470" alt="1" src="https://user-images.githubusercontent.com/67514655/221340663-5f3a4500-cab6-45d6-b744-04e4435a70a1.png">

<img width="1470" alt="2" src="https://user-images.githubusercontent.com/67514655/221340672-74ddf8ad-cd2a-44cc-a266-1cd43cfabadd.png">

<img width="1470" alt="3" src="https://user-images.githubusercontent.com/67514655/221340682-88f31225-94c0-423b-82c0-4d7f30810d3c.png">

<img width="1470" alt="4" src="https://user-images.githubusercontent.com/67514655/221340684-af5e4981-b0a5-4c16-851a-f4bb7c94eba7.png">

<img width="1470" alt="5" src="https://user-images.githubusercontent.com/67514655/221340690-cc2adaa2-67a0-40c2-8903-ddbbc35ad146.png">


