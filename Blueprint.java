package ProjectSwiggyManagement;

import java.sql.SQLException;
/* This project belongs to Swiggy Management. In this class we have assigned the attributes, in simple word
 * it is refer to blueprint. Here I make the attributes as private & it can be accessed through getter and 
 * values assigned through setter method. Login method and logout method is also used. Login method is used 
 * for secured access and log out method is used to logged out the system, after the work completion.
 * 
 */
public class Blueprint {
	private String res_Name;
	private String own_Name;
	private int res_Id;
	private String food_Type;
	private byte price;
	private String location;
	private byte ratings;
	private static String  user_Name = "Kalaivani";
	private static String pass_Word = "Kalai@123";
	/*
	 * All getters  and setter Method for the above attributes
	 */
	public String getRes_Name() {
		return res_Name;
	}
	public void setRes_Name(String res_Name) {
		this.res_Name= res_Name;
		
	}
	public String getOwn_Name() {
		return own_Name;
	}
	public void setOwn_Name(String own_Name) {
		this.own_Name= own_Name;
		
	}
	public int getRes_Id() {
		return res_Id;
	}
	public void setRes_Id(int res_Id) {
		this.res_Id= res_Id;
		
	}
	public String getFood_Type() {
		return food_Type;
	}
	public void setFood_Type(String food_Type) {
		this.food_Type= food_Type;
		
	}
	public byte getPrice() {
		return price;
	}
	public void setPrice(byte price) {
		this.price= price;
		
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location=location;
		
	}
	public byte getRating() {
		return ratings;
	}
	public void setRating(byte ratings) {
		this.ratings= ratings;
		
	}
	/*
	 * Login Method(Here we have assigned the userName and password value in attributes, if the user enter
	 * correctly the project will work.Otherwise it show as userName/password is incorrect.)
	 */
	public static void toCheckLogin(String username, String password) throws Exception,SQLException {
		if(user_Name.equals(username) && pass_Word.equals(password)){
			JdbcMain.toManageData();
		}
		else {
			System.out.println("UserName/Password is incorrect");
		}
	}
	/*
	 * Logout method(to display the comment as logged out successfully)
	 */
	public static void toCallLogout() {
		System.out.println("Logged Out Successfully");
	}

}
