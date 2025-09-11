package stepsdefinition.CreateANewBoard;

import java.net.http.HttpResponse;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckResponseWhenSendRequestSuccessfullySteps {
	String url, method;
	HttpResponse<String> response;

	@Given("I have url and method")
	public void i_have_url_and_method() {
		url = "https://api.trello.com/1/boards?token=ATTAb420992e7d1af6eca93258596c690c760cc1b6bbd75b8d1a8f1af82f3b7eccf207E67C6A&key=f5669804350a0d79b456664598fa3b90";
		method = "POST";
	}

	@When("I send request")
	public void i_send_request() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("The response returns status code and body")
	public void the_response_returns_status_code_and_body() {
		// Write code here that turns the phrase above into concrete actions
	}
}
