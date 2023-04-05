package endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class EndPoints {
	
	public static Response getAllProductsList() {
		
	Response response=
				when()
					.get(Routes.Get_All_Products_List_url);
				
		return response;
		
	}
	
	public static Response  postToAllProductsList() {
		Response response=
		given()
			.contentType(ContentType.JSON)
		.when()
			.post(Routes.POST_To_All_Products_List_url);
		return response;
		
	}
	
	public static Response  getAllBrandsList() {
		Response res=
				given()
				.when()
					.get(Routes.Get_All_Brands_List_url);
		return res;
	}
	public static Response putToAllBrandsList() {
		Response res=given()
				.when()
					.put(Routes.PUT_To_All_Brands_List_url)
				
				;
		return res;
	}

}
