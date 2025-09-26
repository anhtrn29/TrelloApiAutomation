Feature: Check successful response of create card
Scenario: Check successful response of create card 
Given I permit the url and method
When I send POST request
Then The response returns status 200

Scenario: Send request with invalid method 
Given I set endpoint and incorrect method 
When I perform the request 
Then The response should returns the error status and body 

Scenario: Attemp to create card with null name 
Given I provide the endpoint and method 
When I submit request with name set to null
Then The respsone return result status and body 

Scenario: Send request without token
Given I set up the url and method 
When I send request without including token
Then The response return unauthorized error

