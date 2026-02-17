package POJOClassDemo;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class JSONArrayPOJOClassDemo {
	@Test
	public void createEmployeeJSONArray() throws JsonProcessingException{
		
		Employee emp1 = new Employee();
		emp1.setFirstname("Sonu");
		emp1.setLastname("Sharma");
		emp1.setGender("Male");
		emp1.setAge(22);
		emp1.setSalary(100000.34);
		
		Employee emp2 = new Employee();
		emp2.setFirstname("Himanshu");
		emp2.setLastname("Sharma");
		emp2.setGender("Male");
		emp2.setAge(24);
		emp2.setSalary(90000.12);
		
		Employee emp3 = new Employee();
		emp3.setFirstname("Pooja");
		emp3.setLastname("Rana");
		emp3.setGender("Female");
		emp3.setAge(22);
		emp3.setSalary(50000.01);
		
		
		List<Employee> listOfEmp = new ArrayList<Employee>();
		listOfEmp.add(emp1);
		listOfEmp.add(emp2);
		listOfEmp.add(emp3);
		
		//Convert employee class objects to json array payload as String	
		ObjectMapper objMapper = new ObjectMapper();	
		String jsonArrayPayload = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(listOfEmp);		
		System.out.println("employee class objects to json array payload");
		System.out.println(jsonArrayPayload);
			
		//create Request Specification
		RequestSpecification reqSpec = RestAssured.given();		
		//specify URL
		reqSpec.baseUri("http://httpbin.org/post");		
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jsonArrayPayload);
		
		//perform POST request
		Response response = reqSpec.post();
		System.out.println("----------ResponseBody----------------");		
		response.prettyPrint();
				
		//verify the status code		
		Assert.assertEquals(response.statusCode(), 200,"check for status code.");						
		//convert JsonArray to Employee class objects (Deserialization)		
		ResponseBody responseBody = response.getBody();		
		JsonPath jsonPathView = responseBody.jsonPath();		
		List<Employee> allEmployees = jsonPathView.getList("json", Employee.class);	
		System.out.println("----------Emoployee objects in ResponseBody----------------");
		for(Employee emp:allEmployees)
		{
			System.out.println(emp.getFirstname()+ " " + emp.getLastname());
		}
	}

}
