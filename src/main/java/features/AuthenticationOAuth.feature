@smokeTest
Feature: Get request with OAuth 1.0 authentication

Scenario: Verify get request using authentication
	Given authentication params for request
	When users sends request
	Then validate the status code of the response is 200
