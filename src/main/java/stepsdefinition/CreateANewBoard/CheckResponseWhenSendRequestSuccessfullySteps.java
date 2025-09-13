package stepsdefinition.CreateANewBoard;


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
		String requestBody = "{\"name\":\"Bài tập về nhà\",\r\n"
				+ "\"defaultList\":true}";
		System.out.println("abc"+ requestBody);
		try {
			HttpRequest request;
			request = HttpRequest.newBuilder().uri(new URI(url)).POST(BodyPublishers.ofString(requestBody,StandardCharsets.UTF_8)).build();
			System.out.println("abc"+request);
			response = HttpClient.newHttpClient().send(request,BodyHandlers.ofString());
		} catch(Exception e) {
			System.out.println("Send POST request incorrectly");
			e.printStackTrace();
		}
	}

	@Then("The response returns status code and body")
	public void the_response_returns_status_code_and_body() {
		int actualStatusCode = response.statusCode();
		System.out.println("abc"+ actualStatusCode);
		assertEquals(200, actualStatusCode);
	}
}
