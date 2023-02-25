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
