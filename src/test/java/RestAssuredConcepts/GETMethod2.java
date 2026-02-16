package RestAssuredConcepts;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETMethod2 {
	
	@Test
	public void Request1() {
		RequestSpecification request = RestAssured.given();
		request.baseUri("https://restful-booker.herokuapp.com");
		request.basePath("/booking");
		Response response = request.get();
		System.out.println(response.asString());
	}
	
	@Test
	public void Request2() {
		RequestSpecification request = RestAssured.given();
		request.baseUri("https://restful-booker.herokuapp.com");
		request.basePath("/booking");
		Response response = request.get();
		System.out.println(response.asString());
	}
}
