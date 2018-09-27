package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;


public class OAuth_StepDefinition {
	
	String ConsumerKey="yLbgd2GVXW3DrO8gSREsg6d5a";
	String ConsumerSecret="FigmrRBlcx45qjjHrQddoBcpXbdegiH1aNjKiHPHsWzss1jyaG";
	String Token="1029146120902074368-wUIpeKQZR40zcw9k29PVqmSfzpMaNU";
	String TokenSecret="dhmXk7hOrbR0wGoNJhjVujSCU9JhpiEOnfUisnitQlMpE";
	
	public Response response;
	public ValidatableResponse json;
	
	public String baseURL="https://api.twitter.com/1.1/statuses";
	public RequestSpecification requestSpec;
	
	@Given("^authentication params for request$")
	public void authentication_params_for_request() {
		requestSpec=RestAssured.given().baseUri(baseURL);
	    requestSpec.auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret).queryParam("status", "I am tweetiing using rest api");
	}

	@When("^users sends request$")
	public void users_sends_request() {
	   response=requestSpec.post("/update.json");
	   System.out.println(response.prettyPrint());
	}

	@Then("^validate the status code of the response is (\\d+)$")
	public void validate_the_status_code_of_the_response_is(int statusCode)  {
	    json=response.then().statusCode(statusCode);
	}

}
