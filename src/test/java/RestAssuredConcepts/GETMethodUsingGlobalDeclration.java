package RestAssuredConcepts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETMethodUsingGlobalDeclration {
	
	final String BASE_URI = "https://restful-booker.herokuapp.com";
	final String BASE_PATH = "/booking";
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = BASE_URI;
		RestAssured.basePath = BASE_PATH;
	}
	
	@Test
	public void request1() {
		RequestSpecification request = RestAssured.given();
		Response response = request.get();
		System.out.println(response.asString());
	}
	
	@Test
	public void Request2() {
		RequestSpecification request = RestAssured.given();
		Response response = request.get();
		System.out.println(response.asString());
	}
}
