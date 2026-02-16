package stepsdefinition.CreateANewBoard;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

public class CheckCreateANewBoardResponseWhenSendRequestSuccessfullySteps {
	String url, method,requestBody;
	HttpRequest request;
	HttpResponse<String> response;
	@Given("I have url and method")
	public void i_have_url_and_method() {
		url = "https://api.trello.com/1/boards?key=f6832e3c462c191601e53abfe5849652&token=ATTAaef390986ed8a0c2d34541293e8423005138d3e26802b165932796f6f240a5513CDC7D24";
		method = "POST";
	}

	@When("I submit request")
	public void i_submit_request() {
		requestBody = "{\"name\": \"Bài tập về nhà\",\r\n"
				+ "\"defaultLists\": true}";
		try {
			request = HttpRequest.newBuilder().uri(new URI(url)).header("Content-Type", "application/json").POST(BodyPublishers.ofString(requestBody,StandardCharsets.UTF_8)).build();
			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Send POST request incorrectly");
		}
	}

	@Then("The response returns status code and body")
	public void the_response_returns_status_code_and_body() {
		int actualStatusCode = response.statusCode();
		assertEquals(actualStatusCode, 200);
	}

	//Invalid method
	
	@Given("I set url and invalid method")
	public void i_set_url_and_invalid_method() {
		url = "https://api.trello.com/1/boards?key=f6832e3c462c191601e53abfe5849652&token=ATTAaef390986ed8a0c2d34541293e8423005138d3e26802b165932796f6f240a5513CDC7D24";
		method = "GET";
	}

	@When("I send request")
	public void i_send_request() {
		requestBody = "{\"name\": \"Bài tập về nhà\",\r\n"
				+ "\"defaultLists\": true}";
		try {
			request = HttpRequest.newBuilder()
					.uri(new URI(url))
					.header("Content-Type", "application/json")
					.method("GET", BodyPublishers.ofString(requestBody))
					.build();
			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("The response include status and body")
	public void the_response_include_status_and_body() {
		int actualStatus = response.statusCode();
		assertEquals(actualStatus, 403);
		System.out.println("result" + actualStatus);
	}

	//Missing field name 
	
	@Given("I remove field {string}")
	public void i_remove_field(String string) {
		requestBody = "\"defaultLists\": true}";
	}

	@When("I call the API request")
	public void i_call_the_api_request() {
		try {
			request = HttpRequest.newBuilder().uri(new URI(url)).header("Content-Type", "application/json").POST(BodyPublishers.ofString(requestBody,StandardCharsets.UTF_8)).build();
			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Send POST request incorrectly");
		}
	}

	@Then("The response return status {int}")
	public void the_response_return_status(Integer int1) {
		int actualStatus = response.statusCode();
		assertEquals(actualStatus, int1.intValue());
	}

	//Missing token
	
	@Given("I set url and method")
	public void i_set_url_and_method() {
		url = "https://api.trello.com/1/boards?key=f6832e3c462c191601e53abfe5849652&token=ATTAaef390986ed8a0c2d34541293e8423005138d3e26802b165932796f6f240a5513CDC7D24";
		method = "POST";
	}

	@Given("I remove value for {string}")
	public void i_remove_value_for(String string) {
		url = "https://api.trello.com/1/boards?key=f6832e3c462c191601e53abfe5849652";
	}

	@When("I make the POST request")
	public void i_make_the_post_request() {
		requestBody = "{\"name\": \"Bài tập về nhà\",\r\n"
				+ "\"defaultLists\": true}";
		try {
			request = HttpRequest.newBuilder().uri(new URI(url)).header("Content-Type", "application/json").POST(BodyPublishers.ofString(requestBody,StandardCharsets.UTF_8)).build();
			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Send POST request incorrectly");
		}
	}

	@Then("The response status {int}")
	public void the_response_status(Integer int1) {
		int actualStatus = response.statusCode();
		assertEquals(actualStatus,int1.intValue());
	}

	@Then("The body contain {string}")
	public void the_body_contain(String text) {
		String actualBody = response.body();
		assertTrue(actualBody.contains(text));
	}
}
