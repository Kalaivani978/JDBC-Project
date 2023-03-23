package ProjectSwiggyManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcMain {
	/*
	 * In this class, we have created the connection to the mysql database through JDBC.
	 * 
	 */
	private static Scanner scan = new Scanner(System.in);  
  /*
   * The below method is work once user logged in, this is to make the connection. Here, I have entered the 
   * userName and password of Mysql,to connect. It may throw the exception. Therefore exception is handled 
   * through catch.
   */
	public static Connection toCreateConnection() {
		Connection connect = null;
		try{
			String user_name = "root";
			String pass_word = "Kalaivani@123";
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc",user_name,pass_word);

		}
		catch(Exception obj) {
			System.out.println(obj);
		}
		return connect;
	}
	/*
	 * After the connection is done, this method will work. In this method User will choose, which option they need to 
	 * perform. Based on the choice the respective method is called from the Database connection class.If the user
	 * choose other than the listed option. Then it will print the message as wrong choice and logged out.
	 */
	
	public  static void toManageData() throws Exception,SQLException  {
		Connection Connect = toCreateConnection();
		DatabaseConnection obj = new DatabaseConnection();
		int user_choice;
		do {
			System.out.println("Please choose the option 1.Add the Restaurant , 2. Display the Restaurant, 3. Search the restaurant, 4.Delete the Restaurant, 5. Update the Restaurant, 6.Log out ");
			user_choice = scan.nextInt();
			switch(user_choice) {
			case 1:obj.add(Connect,scan);
			       break;
			case 2:obj.display(Connect);
			       break;
			case 3:obj.search(Connect,scan);
			       break;
			case 4:obj.delete(Connect,scan);
			       break;
			case 5:System.out.println("Enter the restaurant Id");
			       int res_id = scan.nextInt();
			       obj.update(Connect,scan,res_id);
			       break;
			case 6:Blueprint.toCallLogout();
			       Connect.close();
			       break;
			default:System.out.println("You have entered wrong choice");
			        Connect.close();
			        break;

			}
		}while(user_choice<=5);

	}

	public static void main(String[] args) throws Exception,SQLException {

		System.out.println("Enter the username");
		String user_name = scan.nextLine();
		System.out.println("Enter the password");
		String pass_word = scan.nextLine();
		Blueprint.toCheckLogin(user_name,pass_word);  // CheckLogin method is called from the blueprint class to check the credential.
		

	}

}
