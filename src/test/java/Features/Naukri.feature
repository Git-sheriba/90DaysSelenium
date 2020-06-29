Feature: Uploading resume in Naukri

Scenario: Negative flow to post the resume

Given user opens the chrome browser
And user loads https://www.naukri.com/ 
And Cancel the notification
And Get the name of the windows and close
When Picture file uploaded
Then Error message displayed