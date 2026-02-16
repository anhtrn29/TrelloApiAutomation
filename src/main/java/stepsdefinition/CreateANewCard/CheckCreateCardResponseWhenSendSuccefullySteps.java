package stepsdefinition.CreateANewCard;

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

public class CheckCreateCardResponseWhenSendSuccefullySteps {
	String url, method, requestBody;
	HttpRequest request;
	HttpResponse<String> response;

	@Given("I permit the url and method")
	public void i_permit_the_url_and_method() {
		url = "https://api.trello.com/1/cards?token=ATTAb420992e7d1af6eca93258596c690c760cc1b6bbd75b8d1a8f1af82f3b7eccf207E67C6A&key=f5669804350a0d79b456664598fa3b90";
		method = "POST";
	}

	@When("I send POST request")
	public void i_send_post_request() {
		requestBody = "{\"name\":\"API tạo user\",\r\n" + "\"idList\":\"68b7f8684cc2fb89b26056ab\",\r\n"
				+ "\"desc\":\"Kiểm tra việc tạo mới thông tin một user\"}";
		try {
			request = HttpRequest.newBuilder().uri(new URI(url)).header("Content-Type", "application/json")
					.POST(BodyPublishers.ofString(requestBody, StandardCharsets.UTF_8)).build();
			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("The response returns status {int}")
	public void the_response_returns_status(Integer int1) {
		int actualStatus = response.statusCode();
		assertEquals(actualStatus, int1.intValue());
	}

	// Invalid method

	@Given("I set endpoint and incorrect method")
	public void i_set_endpoint_and_incorrect_method() {
		url = "https://api.trello.com/1/cards?token=ATTAb420992e7d1af6eca93258596c690c760cc1b6bbd75b8d1a8f1af82f3b7eccf207E67C6A&key=f5669804350a0d79b456664598fa3b90";
		method = "GET";
	}

	@When("I perform the request")
	public void i_perform_the_request() {
		requestBody = "{\"name\":\"API tạo user\",\r\n" + "\"idList\":\"68b7f8684cc2fb89b26056ab\",\r\n"
				+ "\"desc\":\"Kiểm tra việc tạo mới thông tin một user\"}";
		try {
			request = HttpRequest.newBuilder().uri(new URI(url)).header("Content-Type", "application/json")
					.method("GET", BodyPublishers.ofString(requestBody)).build();
			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("The response should returns the error status and body")
	public void the_response_should_returns_the_error_status_and_body() {
		int actualStatusBody = response.statusCode();
		assertEquals(actualStatusBody, 403);
		System.out.println("403" + actualStatusBody);
	}

	// Check null field name

	@Given("I provide the endpoint and method")
	public void i_provide_the_endpoint_and_method() {
		url = "https://api.trello.com/1/cards?token=ATTAb420992e7d1af6eca93258596c690c760cc1b6bbd75b8d1a8f1af82f3b7eccf207E67C6A&key=f5669804350a0d79b456664598fa3b90";
		method = "POST";
	}

	@When("I submit request with name set to null")
	public void i_submit_request_with_name_set_to_null() {
		requestBody = "{\"name\":null,\r\n" + "\"idList\":\"68b7f8684cc2fb89b26056ab\",\r\n"
				+ "\"desc\":\"Kiểm tra việc tạo mới thông tin một user\"}";
		try {
			request = HttpRequest.newBuilder().uri(new URI(url)).header("Content-Type", "application/json")
					.POST(BodyPublishers.ofString(requestBody, StandardCharsets.UTF_8)).build();
			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("The respsone return result status and body")
	public void the_respsone_return_result_status_and_body() {
		int actualStatusBody = response.statusCode();
		assertEquals(actualStatusBody, 200);
	}

	// Check missing token

	@Given("I set up the url and method")
	public void i_set_up_the_url_and_method() {
		url = "https://api.trello.com/1/cards?key=f5669804350a0d79b456664598fa3b90";
		method = "POST";
	}

	@When("I send request without including token")
	public void i_send_request_without_including_token() {
		requestBody = "{\"name\":\"API tạo user\",\r\n" + "\"idList\":\"68b7f8684cc2fb89b26056ab\",\r\n"
				+ "\"desc\":\"Kiểm tra việc tạo mới thông tin một user\"}";
		try {
			request = HttpRequest.newBuilder().uri(new URI(url)).header("Content-Type", "application/json")
					.POST(BodyPublishers.ofString(requestBody, StandardCharsets.UTF_8)).build();
			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("The response return unauthorized error")
	public void the_response_return_unauthorized_error() {
		int actualStatus = response.statusCode();
		assertEquals(actualStatus, 401);
	}

}
