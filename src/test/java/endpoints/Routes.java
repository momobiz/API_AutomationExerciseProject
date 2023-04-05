package endpoints;

public class Routes {
	
	public static String base_url="https://automationexercise.com/api";
	public static String Get_All_Products_List_url=base_url+"/productsList";
	public static String POST_To_All_Products_List_url=base_url+"/productsList";
	public static String Get_All_Brands_List_url=base_url+"/brandsList";
	public static String PUT_To_All_Brands_List_url=base_url+"/brandsList";
	public static String POST_To_Search_Product_url=base_url+"/searchProduct";
	public static String POST_To_Search_Product_without_search_product_parameter_url=base_url+"/searchProduct";
	public static String POST_To_Verify_Login_with_valid_details_url=base_url+"/verifyLogin";
	public static String POST_To_Verify_Login_without_emailparameter_url=base_url+"/verifyLogin";
	public static String DELETE_To_Verify_Login_url=base_url+"/verifyLogin";
	public static String POST_To_Verify_Login_with_invalid_details_url=base_url+"/verifyLogin";
	public static String POST_To_CreateRegister_User_Account_url=base_url+"/createAccount";
	public static String DELETE_METHOD_To_Delete_User_Account_url=base_url+"/deleteAccount";
	public static String PUT_METHOD_To_Update_User_Account_url=base_url+"/updateAccount";
	public static String GET_user_account_detail_by_email_url=base_url+"/getUserDetailByEmail";

}
