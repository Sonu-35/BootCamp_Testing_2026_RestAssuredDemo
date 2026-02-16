package RestAssuredConcepts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETMethod {
	
	@BeforeTest
	public void setup() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RestAssured.basePath = "/booking";
	}
	
	@Test
	public void Request1() {
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
