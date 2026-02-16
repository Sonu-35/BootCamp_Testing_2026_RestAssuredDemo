//Write rest assured program to verify status code 


package RestAssuredConcepts;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BDDStyle {
	@Test
	
	public void getbookingids_verifystatuscode() {
		
		RestAssured.given().baseUri("https://restful-booker.herokuapp.com").when().get("/booking")
		.then().statusCode(200).statusLine("HTTP/1.1 200 OK");
		
	}

}
