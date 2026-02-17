package RestAssuredConceptsPostRequest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthorizationDemo {

	@SuppressWarnings("unchecked")
	@Test
	public void BearerToken() {
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.baseUri("https://gorest.co.in");
		requestSpec.basePath("/public/v2/users");
		JSONObject payload = new JSONObject();
		payload.put("name", "Sonu");
		payload.put("gender", "Male");
		payload.put("email", "SonuSharma@gmail.com");
		payload.put("status", "Active");
		String AuthToken = "Bearer 84b94ad1f0e63a4dbcc0af119ab7c5d8086b2c6f13298718eb32b098310fac2f";
		requestSpec.headers("Authorization", AuthToken).contentType(ContentType.JSON).body(payload.toJSONString());
		Response response = requestSpec.post();// perform post request
		Assert.assertEquals(response.statusCode()/* actual */, 201/* expected */, "check for status code");
		System.out.println("Responsne status line:" + response.statusLine());
		System.out.println("Response body:" + response.body().asString());
	}

	public void GetWeatherDataByCity() {
		// create request specification
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.baseUri("https://api.openweathermap.org");
		requestSpec.basePath("/geo/1.0/direct?q={city name},&appid={API key}");
		requestSpec.queryParam("city name", "Delhi").queryParam("appid", "a02267ca317a8e08a9e91d93f209ca92");
		Response response = requestSpec.get();
		System.out.println("Responsne status line:" + response.statusLine());
		System.out.println("Response body:" + response.body().asString());
	}
}
