Feature: Verify response when request
Scenario: Verify response when request
Given I set the url and method
When I call the API
Then The response returns status and body

Scenario: Check invalid url
Given I set up wrong url with a method
When I make the request
Then The response astatus and body are displayed

Scenario: Check null value field "idBoard"
Given I provide the url and method
When I send request with null value for "idBoard"
Then The response return status code 400

Scenario: Check key missing value 
Given I have the url and method 
And I remove value for "key"
When I send list request
Then The response returns error status 401 and message 