package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
public class GetAndPostExample {

//@Test
public void  testGet() 
{
	
	baseURI = "https://reqres.in/api";
	
	given().
	 get("users?page=2").
	then().
	 statusCode(200).
	 body("data[4].email", equalTo("george.edwards@reqres.in")).
	 body("data.first_name", hasItems("George", "Rachel"))
	 .log().all();
}

@Test
public void testPost()
{
	Map<String, Object> map = new HashMap<String, Object>();
	
//	map.put("name", "Ritesh");
//	map.put("job" , "QA");	
//	System.out.println(map);
	
	JSONObject request = new JSONObject();
	
	request.put("name", "Ritesh");
	request.put("job" , "QA");
	System.out.println(request.toJSONString());
	
	baseURI = "https://reqres.in/api";
	
	given().
	 header("Content-Type", "application/json")	
	.body(request.toJSONString()).
	when().
	post("/users").
	then().
	statusCode(201)
	.log().all();

}
}
