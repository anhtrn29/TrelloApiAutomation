Feature: Check response when send request successfully
Scenario: Check response when send request successfully
Given I have url and method
When I send request
Then The response returns status code and body


