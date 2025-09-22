	Feature: Check response when send request successfully
	Scenario: Check response when send request successfully
	Given I have url and method
	When I send request
	Then The response returns status code and body
	
	Scenario: Check invalid method
	Given I set url and method 
	When  I change invalid method 
	And I send request
	Then The response include status code and body 
	
	Scenario: Check missing required field name 
	Given I have url and method
	And I remove field "name"
	When I send request
	Then The response return status 400
	And The response body contain "invalid value for name"
	
	Scenario: Check token missing value
	Given I set url and method 
	And I remove value for "token" 
	When  I send request
	Then The response return status 401
	And The response body contain "missing scopes"
	
	
	
	
