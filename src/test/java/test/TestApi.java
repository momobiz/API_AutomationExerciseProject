package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import endpoints.EndPoints;
import io.restassured.response.Response;

public class TestApi {
	Properties prop;
	SoftAssert softAssert;
	Logger logger;
	
	@BeforeClass
	public void readconfig() throws IOException {
	     prop=new Properties();
	     FileInputStream fis=new FileInputStream("./src/test/resources/config.properties");
	     prop.load(fis);
	     softAssert=new SoftAssert();
	     logger=LogManager.getLogger(this.getClass());
	   
		
		
	}

	@Test(priority=1)
	public void testGetAllProductsList() {
		
		Response res=EndPoints.getAllProductsList();
		JSONObject jo=new JSONObject(res.asString());
		int actualProductNumber=jo.getJSONArray("products").length();
		
		softAssert.assertEquals(String.valueOf(actualProductNumber), prop.getProperty("productsNumber"));
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("***** Success Testing get all products list api ******************");
	}
	
	@Test(priority=2)
	public void testPOSTToAllProductsList() {
		Response res=EndPoints.postToAllProductsList();
		JSONObject jo=new JSONObject(res.asString());
		int actualResponseCode=jo.getInt("responseCode");
		String actualMessage=jo.getString("message");
		
		softAssert.assertEquals(String.valueOf(actualResponseCode), prop.getProperty("responseCode"));
		softAssert.assertEquals(actualMessage,prop.getProperty("respnseMessage"));
		logger.info("***** Success Testing post all products list api ******************");
	  
	}
	
	@Test(priority=3)
	public void testGetAllBrandsList() {
		Response res=EndPoints.getAllBrandsList();
		JSONObject jo=new JSONObject(res.asString());
		String actualResponseCode=String.valueOf(jo.getInt("responseCode"));	
		
		int jsonBrandsNumber=jo.getJSONArray("brands").length();
		String[] brands=prop.getProperty("brands").split(",");
		int expectedBrandsNumber=brands.length;

			int actualBrandsNumber=0;
			for(int i=0;i<brands.length;i++) {
				for(int j=0;j<jsonBrandsNumber;j++) {
					if(jo.getJSONArray("brands").getJSONObject(j).getString("brand").contentEquals(brands[i])) {
						actualBrandsNumber++;
						break;
					}
				}
			}
			
		softAssert.assertEquals(actualResponseCode, prop.getProperty("responseCode2"));
		softAssert.assertEquals(actualBrandsNumber,expectedBrandsNumber);
		logger.info("****************  Testing Get All Brands List is verified **************************");
		
	}
	@Test(priority=4)
	public void testPUTToAllBrandsList() {
		Response res=EndPoints.putToAllBrandsList();
		JSONObject jo=new JSONObject(res.asString());
		String actualResponseCode=String.valueOf(jo.getInt("responseCode"));
		String actualResponseMessage=jo.getString("message");
		
		softAssert.assertEquals(actualResponseCode, prop.getProperty("responseCode"));
		softAssert.assertEquals(actualResponseMessage, prop.getProperty("responseMessage"));
	logger.info("********* Testing PUT To All Brands List API is verified ************************");
		
		
	}
		
		
	
}
