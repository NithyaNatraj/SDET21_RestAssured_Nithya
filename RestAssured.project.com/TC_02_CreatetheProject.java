package SDET_EndToEndRMG;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtils.EndPoints;
import RAUtils.BaseAPIClass;
import RAUtils.RestAssuredUtilities;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import sdet21.POJO.Class.ProjectLibrary;

public class TC_02_CreatetheProject extends BaseAPIClass
{
	
	@Test
	
	public void createProject(Response res) throws Throwable 
	{
		baseURI = "http://localhost";
		port = 8084;
		
		
		RestAssuredUtilities RLib = new RestAssuredUtilities();
		
		//read data through pojo class
		ProjectLibrary plib = new ProjectLibrary("rmg", "TC_0102", "created", 10 );
		
		
		given()
		.contentType(ContentType.JSON)
		.body(plib)
		
		.when()
		.post(EndPoints.addProject)
		
		.then()
		.log().all();
		
		//capture the expected data
		String expData = rLib.getJsonData(res, "ProjectId");
		System.out.println(expData);
		
		//Verify it in a database
		
		String query = "Select * from project";
		String actData = dLib.executeQueryAndGetData(query, 2, expData);
		
		
		//validate
		
		Assert.assertEquals(actData, expData);
		System.out.println("Sucessfull");
		
		
		
		
	}
}

	
	

