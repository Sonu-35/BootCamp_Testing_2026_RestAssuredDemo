package RestAssuredConceptsPostRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class BDDStylePostRequest {
	
	public static void main(String[] arg) {
	String jsonString = "{\"username\": \"admin\", \"password\" : \"password123\"}";
	RestAssured
	.given()
		.baseUri("https://restful-booker.herokuapp.com/auth")
		.contentType(ContentType.JSON)
		.body(jsonString)
		.when()
			.post()
			.then()
				.assertThat()
				.statusCode(200)
				.log().all();
	}
}
