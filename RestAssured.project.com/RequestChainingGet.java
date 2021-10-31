package Parameters;

import org.testng.annotations.Test;

import GenericUtils.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import sdet21.POJO.Class.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class RequestChainingGet {
	@Test
	public void requestChainingForGet()
	{
		JavaUtility jlib = new JavaUtility();
		baseURI = "http://localhost";
		port = 8084;
		
		//create a project
		
		ProjectLibrary pLib = new ProjectLibrary("Nithya", "Ameex"+jlib.getRandomNumber(), "completed", 10);
		
		Response res = given().contentType(ContentType.JSON)
				.body(pLib)
				.when().post("/addProject");
		
		//Get projId using json path
		
		String projId = res.jsonPath().getString("projectId");
		System.out.println(projId);
		
		//Second req to read the same project
		
		given()
		.pathParam("projID", projId)
		.when()
		.get("/projects/{projID}")
		.then().assertThat().statusCode(200).log().all();
		
		//delete 
		
		when().delete("http://localhost:8084/projects/projId");
	
		
		
	}

}
