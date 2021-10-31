package com.CredOperationwithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import GenericUtils.JavaUtility;
import io.restassured.http.ContentType;
import sdet21.POJO.Class.ProjectLibrary;

public class CreateProjectUsingPojo {
	@Test
	
	public void createProjectUsingPojo(){
		
		JavaUtility jlib = new JavaUtility();
		
		
		baseURI = "http://localhost";
		port = 8084;
		
		//read data through pojo class
		ProjectLibrary plib = new ProjectLibrary("Nithya", "Anand"+jlib.getRandomNumber(), "Completd", 10, null, null);
		
		//request Specification
		given()
		.contentType(ContentType.JSON)
		.body(plib)
		
		
		//request
		.when()  
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
		
	}
	
	

}
