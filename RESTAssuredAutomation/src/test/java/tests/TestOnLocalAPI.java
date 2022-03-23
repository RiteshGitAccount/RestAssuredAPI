package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;


public class TestOnLocalAPI {
 
	//@Test
 public void getLocalAPI()
 {
	 baseURI = "http://localhost:3000";
	 given().get("/users").then().statusCode(200).log().all();
 }
	

	//@Test
 public void postLocalAPI()
 {
	
	 JSONObject request = new JSONObject();
	 
	 request.put("firstname", "Tim");
	 request.put("lastname", "Tom");
	 request.put("subjectID", "Magic");
	 
	 baseURI = "http://localhost:3000";
	 
	 given()
	 .contentType(ContentType.JSON)
	 .accept(ContentType.JSON)
	 .body(request.toJSONString())
	 .when()
	  .post("/users")
	 .then()
	  .statusCode(201);
 }
 
 //@Test
 public void putLocalAPI()
 {
	
	 JSONObject request = new JSONObject();
	 
	 request.put("firstname", "Tim2");
	 request.put("lastname", "Tom");
	 request.put("subjectID", "Magic");
	 
	 baseURI = "http://localhost:3000";
	 
	 given()
	 .contentType(ContentType.JSON)
	 .accept(ContentType.JSON)
	 .body(request.toJSONString())
	 .when()
	  .put("/users/3")
	 .then()
	  .statusCode(200);
 }
 
 //@Test
 public void patchLocalAPI()
 {
	
	 JSONObject request = new JSONObject();
	 
	 
	 request.put("lastname", "Tom2");
	
	 
	 baseURI = "http://localhost:3000";
	 
	 given()
	 .contentType(ContentType.JSON)
	 .accept(ContentType.JSON)
	 .body(request.toJSONString())
	 .when()
	  .patch("/users/3")
	 .then()
	  .statusCode(200);
 }
 
 @Test
 public void deleteLocalAPI()
 {
	
	 JSONObject request = new JSONObject();
	 
	 
	
	
	 
	 baseURI = "http://localhost:3000";
	 
	
	 when()
	  .delete("/users/3")
	 .then()
	  .statusCode(204);
 }
}
