Feature: Login functionality

Background: User successfully clicked on Initial Login window
When user open "Chrome" broswer with exe 
When user open url as
When user cancel the Initial Login Window

@SmokeTest
Scenario: Login functionality by using valid credentials
When user navigate on Login button
When user click on MyProfile
When user enter "7020712080" as username
When user enter "@Avit1492$" as password
When user click on Login button 
Then Aplication shows user profile to user
Then browser close