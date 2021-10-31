package GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;


public class DatabaseUtility {
	

	Driver driverref;
	Connection con;
	ResultSet result;
	
	public void connectToDB() throws Throwable 

	{
		
		DriverManager.registerDriver(driverref);
		
		DriverManager.getConnection(IPathConstants.dbURL, IPathConstants.dbUserName, IPathConstants.dbPassword);
	
		
	}
	public void closeDB() throws Throwable 

	{
		con.close();
	}
	
	public String executeQueryAndGetData(String query, int ColumnIndex, String expData) throws Throwable  {
		Boolean flag = false;
		result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			String actData = result.getString(ColumnIndex);
			
			if(actData.equalsIgnoreCase(expData))
			{
				flag = true;
				break;
			}
		}
		
		if(flag)
		{
			System.out.println(expData + "data verified successfully");
			return expData;
		}
		else {
			System.out.println(expData + "data not verified in DB");
			return "";
		}
	}
	

}
