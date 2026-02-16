package RestAssuredConceptsPostRequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class createUserTest {
	
	@Test
	   public void createUserDemo() {
	       RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/create";
	       // Create JSON Object (Request Body)
	       JSONObject requestBody = new JSONObject();
	       requestBody.put("name", "Sonu");
	       requestBody.put("salary", "1872361");
	       requestBody.put("age", "22");
	       // Generate POST Request & Get Response
	       Response response = RestAssured
	               .given()
	               .header("Content-Type", "application/json")
	               .body(requestBody.toString())
	               .when()
	               .post();
	       int statusCode = response.getStatusCode();   // Get Status Code
	       System.out.println("Status Code: " + statusCode);
	       System.out.println("Complete Response:");    // Print Complete Response
	       System.out.println(response.asString());
	       System.out.println("Response Body:");        // Print Response Body
	       System.out.println(response.getBody().asString());
	       String statusLine = response.getStatusLine(); // Print Response Status Line
	       System.out.println("Status Line: " + statusLine);
	   }

}
