package classDemo;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class GetAndPostRequests {
	@Test
public void getTest() {
		baseURI ="https://reqres.in/api";
		given().get("/users?page=2")
		.then().statusCode(200)
		.body("data[4].first_name",equalTo("George"))
		.body("data.first_name",hasItems("George","Rachel"));
	
		
}
	public void postTest() {
		Map<String,Object> map = new HashMap<String,Object>();
		//map.put("name","vaibhav");
		//map.put("Job", "SDET");
		//System.out.println(map);
		
		JSONObject request = new JSONObject();
		request.put("name","vaibhav");
		request.put("Job", "SDET");
		System.out.println(request.toJSONString());
		baseURI ="https://reqres.in/api";
		given()
		  .header("Content-Type","application/json").
		  contentType(ContentType.JSON).accept(ContentType.JSON)
		  .body(request.toString()).
		when().
		   post("/users").
		then().
		   statusCode(201).log().all();
	}
}
