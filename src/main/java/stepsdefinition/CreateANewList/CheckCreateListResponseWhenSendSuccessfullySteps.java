package stepsdefinition.CreateANewList;

import static org.testng.Assert.assertEquals;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckCreateListResponseWhenSendSuccessfullySteps {
	String url, method;
	HttpRequest request;
	HttpResponse<String> response;

	@Given("I set the url and method")
	public void i_set_the_url_and_method() {
		url = "https://api.trello.com/1/lists?token=ATTAaef390986ed8a0c2d34541293e8423005138d3e26802b165932796f6f240a5513CDC7D24&key=f6832e3c462c191601e53abfe5849652";
		method = "POST";
	}

	@When("I call the API")
	public void i_call_the_api() {
		String requestBody = "{\"name\":\"Bài chưa làm\",\r\n" + "\"idBoard\":\"68d28645d7f2937c60cad200\"}";
		try {
			request = HttpRequest.newBuilder().uri(new URI(url)).header("Content-Type", "application/json")
					.POST(BodyPublishers.ofString(requestBody, StandardCharsets.UTF_8)).build();
			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Send POST incorrectly");
		}
	}

	@Then("The response returns status and body")
	public void the_response_returns_status_and_body() {
		int actualStatusCode = response.statusCode();
		assertEquals(actualStatusCode, 200);
	}

	// Invalid url

	@Given("I set up wrong url with a method")
	public void i_set_up_wrong_url_with_a_method() {
		url = "https://api.trello.com/1/list";
		method = "POST";
	}

	@When("I make the request")
	public void i_make_the_request() {
		String requestBody = "{\"name\":\"Bài chưa làm\",\r\n" + "\"idBoard\":\"68d28645d7f2937c60cad200\"}";
		try {
			request = HttpRequest.newBuilder().uri(new URI(url)).header("Content-Type", "application/json")
					.POST(BodyPublishers.ofString(requestBody, StandardCharsets.UTF_8)).build();
			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("The response astatus and body are displayed")
	public void the_response_astatus_and_body_are_displayed() {
		int actualStatus = response.statusCode();
		assertEquals(actualStatus, 401);
	}

	// Null idBoard

	@Given("I provide the url and method")
	public void i_provide_the_url_and_method() {
		url = "https://api.trello.com/1/lists?token=ATTAaef390986ed8a0c2d34541293e8423005138d3e26802b165932796f6f240a5513CDC7D24&key=f6832e3c462c191601e53abfe5849652";
		method = "POST";
	}

	@When("I send request with null value for {string}")
	public void i_send_request_with_null_value_for(String string) {
		String requestBody = "{\\\"name\\\":\\\"Bài chưa làm\\\",\\\"idBoard\\\":null}";
		try {
			request = HttpRequest.newBuilder().uri(new URI(url)).headers("Content-Type", "application/json")
					.POST(BodyPublishers.ofString(requestBody, StandardCharsets.UTF_8)).build();
			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("The response return status code {int}")
	public void the_response_return_status_code(Integer int1) {
		int actualStatus = response.statusCode();
		assertEquals(actualStatus, int1.intValue());
	}

	// Missing key

	@Given("I have the url and method")
	public void i_have_the_url_and_method() {
		url = "https://api.trello.com/1/lists?token=ATTAaef390986ed8a0c2d34541293e8423005138d3e26802b165932796f6f240a5513CDC7D24";
		method = "POST";
	}

	@When("I send list request")
	public void i_send_list_request() {
		String requestBody = "{\"name\":\"Bài chưa làm\",\r\n" + "\"idBoard\":\"68d28645d7f2937c60cad200\"}";
		try {
			request = HttpRequest.newBuilder().uri(new URI(url)).headers("Content-Type", "applicaiton/json")
					.POST(BodyPublishers.ofString(requestBody, StandardCharsets.UTF_8)).build();
			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("The response returns error status {int} and message")
	public void the_response_returns_error_status_and_message(Integer int1) {
		int actualStatusCode = response.statusCode();
		assertEquals(actualStatusCode, int1.intValue());
	}
}
