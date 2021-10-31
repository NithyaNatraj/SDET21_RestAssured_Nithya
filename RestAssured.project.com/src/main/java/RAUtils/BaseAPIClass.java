package RAUtils;
import static io.restassured.RestAssured.*;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import GenericUtils.DatabaseUtility;
import GenericUtils.JavaUtility;

public class BaseAPIClass {

	public DatabaseUtility dLib = new DatabaseUtility();
	public RestAssuredUtilities rLib = new RestAssuredUtilities();
	public JavaUtility jLib = new JavaUtility();
	
	@BeforeSuite
	public void bsConfig() throws Throwable
	{
		
		dLib.connectToDB();
		baseURI = "http://localhost";
		port = 8084;
		
	}
	
	@AfterSuite
	public void asConfig() throws Throwable
	{
		dLib.closeDB();
	}
	
	
}
