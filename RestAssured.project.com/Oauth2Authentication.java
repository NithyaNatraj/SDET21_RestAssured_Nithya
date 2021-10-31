package Authentication;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Oauth2Authentication {
@Test
	
	public void oauth2()

	{
	  Response res =given().formParam("client_id", "SDET21-RMGY-REST2")
	  .formParam("client_secret", "1daf0be7c2c19983162134d9c13ca5c6")
	  .formParam("grant_type", "client_credentials")
	  .formParam("redirect_uri", "http://example.com")
	  .formParam("code", "authorization_code")
	
	 .when().post("http://coop.apps.symfonycasts.com/token");
	 
	 
	//create the token
	 String Token = res.jsonPath().getString("access_token");
	 System.out.println(Token);
	 
	 //Create a new request
	 given().auth().oauth2(Token)
	 .pathParam("USER_ID", "2400")
	 
	 .when()
	 .post("http://coop.apps.symfonycasts.com/token/{USER_ID}/api/USER_ID/chickens-feed")
	 
	 .then().log().all();
	
	}
}


