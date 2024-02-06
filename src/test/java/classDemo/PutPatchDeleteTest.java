package classDemo;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDeleteTest {
	@Test
	public void PutTest() {
	JSONObject request = new JSONObject();
	
	request.put("name","vaibhav");
	request.put("Job", "SDET");
	
	System.out.println(request.toJSONString());
	
	baseURI ="https://reqres.in/api";
	
	given().
	  header("Content-Type","application/json").
	  contentType(ContentType.JSON).
	  accept(ContentType.JSON).
	  body(request.toString()).
	when().
	   put("/users/2").
	then().
	   statusCode(200)
	   .log().all();
}
	@Test
	public void PatchTest() {
		JSONObject request = new JSONObject();
		
		request.put("name","vaibhav");
		request.put("Job", "SDET");
		
		System.out.println(request.toJSONString());
		
		baseURI ="https://reqres.in";
		
		given().
		  header("Content-Type","application/json").
		  contentType(ContentType.JSON).
		  accept(ContentType.JSON).
		  body(request.toString()).
		when().
		   patch("/api/users/2").
		then().
		   statusCode(200)
		   .log().all();
	}
	@Test
	public void DeleteTest() {
		JSONObject request = new JSONObject();
		
		request.put("name","vaibhav");
		request.put("Job", "SDET");
		
		System.out.println(request.toJSONString());
		
		baseURI ="https://reqres.in";
		
		given().
		  header("Content-Type","application/json").
		  contentType(ContentType.JSON).
		  accept(ContentType.JSON).
		  body(request.toString()).
		when().
		   delete("/api/users/2").
		then().
		   statusCode(204)
		   .log().all();
	}}
	
