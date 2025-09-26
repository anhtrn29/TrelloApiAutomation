Feature: Check response when send request successfully
Scenario: Check response when send request successfully
Given I have url and method
When I submit request
Then The response returns status code and body

Scenario: Check invalid method
Given I set url and invalid method 
When  I send request
Then The response include status and body 

Scenario: Check missing required field name 
Given I have url and method
And I remove field "name"
When I call the API request
Then The response return status 400

Scenario: Check token missing value
Given I set url and method 
And I remove value for "token" 
When  I make the POST request
Then The response status 401
And The body contain "missing scopes"