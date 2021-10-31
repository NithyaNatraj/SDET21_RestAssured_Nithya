package com.CredOperationwithBDD;

import java.io.FileInputStream;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingJsonFile {
	
 
	
	
	@Test
	public void createProjectUsingJsonFile()
	{

	//read the file
	FileInputStream fis = new FileInputStream("./data.json");
	
	//request Specification
	given().
	contentType(ContentType.JSON)
	.body(fis)
	
	//actual request
	.when()
	.post("http://localhost:8084/addProject")
    .then()
    .assertThat()
    .statusCode(201)
    .contentType(ContentType.JSON)
    .log().all();
	
	
}
