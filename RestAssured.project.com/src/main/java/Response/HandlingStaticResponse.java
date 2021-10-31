package Response;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class HandlingStaticResponse {
	@Test
	
	public void staticResponse()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		String expdata = "TY_PROJ_403";
		
		//store all the response
		
		Response res = when().get("/projects");
		
		//capture the data usng json path
		String actdata = res.jsonPath().getString("[13].projectId");
		System.out.println(actdata);
		
		//validate
		Assert.assertEquals(expdata, actdata);
		System.out.println(actdata + "data verified");
		
		res.then().log().all();
	}
	

}
