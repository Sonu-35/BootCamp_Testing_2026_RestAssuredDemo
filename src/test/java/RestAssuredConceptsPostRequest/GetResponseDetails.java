package RestAssuredConceptsPostRequest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetResponseDetails {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking";
	       // Send GET request and capture response
	       Response response = RestAssured
	               .given()
	               .when()
	               .get();
	       int statusCode = response.getStatusCode();
	       System.out.println("Status Code: " + statusCode); // Get Status Code
	       System.out.println("Complete Response:");
	       System.out.println(response.asString()); // Print complete response
	       System.out.println("Response Body:");
	       System.out.println(response.getBody().asString()); // Print Response Body
	       String statusLine = response.getStatusLine();
	       System.out.println("Status Line: " + statusLine); // Print Response Status Line
	       String contentType = response.getContentType();
	       System.out.println("Content Type: " + contentType); // Print Response Content-Type
	       long responseTime = response.getTime(); // Display Response Time (in milliseconds)
	       System.out.println("Response Time: " + responseTime + " ms");
	   }
}
