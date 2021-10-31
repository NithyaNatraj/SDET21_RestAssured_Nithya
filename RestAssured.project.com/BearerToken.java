package Authentication;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class BearerToken {
	@Test
	
	public void bearerToken()

	{
		//create the data
		HashMap map = new HashMap();
		map.put("name", "REST-SDET21-BEARER-TOKEN");
		
		given()
		.auth()
		.oauth2("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")
		.body(map)
		.when()
		.post("https://api.github.com/orgs/{org}/repos")
		.then().log().all();
	}
}
