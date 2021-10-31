package RAUtils;

import io.restassured.response.Response;

public class RestAssuredUtilities {
	/** This class contains generic methods for RestAssured
	 */
	
	public String getJsonData(Response res, String jsonPath)
	{
		
		String value = res.jsonPath().get(jsonPath);
		return value;
		
	}

}
