package ProjectSwiggyManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseConnection {
	/*
	 * In this class we have created the add, delete, update, search, displayall method for
	 *  Swiggy management system.
	 * 
	 */
	/*
	 * Add:
	 * Here we get the input through user so we used the prepared statement.The Question mark indicate the 
	 * value for the columns/attributes.
	 * Using setDatatype(QuestionMarkPosition,value), we have setted the value into the list.
	 * 
	 * 
	 */
	
public void add(Connection connect,Scanner scan) throws SQLException,Exception{
	PreparedStatement add=connect.prepareStatement("INSERT INTO SwiggyManagement values(?,?,?,?,?,?,?)");
	System.out.println("Enter the hotel no: ");
	add.setInt(1,scan.nextInt());
	System.out.println("Enter the hotel name: ");
	add.setString(2,scan.next());
	System.out.println("Enter the owner name: ");
	add.setString(3, scan.next());
	System.out.println("Enter the food type: ");
	add.setString(4, scan.next());
	System.out.println("Enter the price: ");
	add.setFloat(5, scan.nextInt());
	System.out.println("Enter the location: ");
	add.setString(6, scan.next());
	System.out.println("Enter the  ratings: ");
	add.setFloat(7, scan.nextInt());
	int insertValues=add.executeUpdate();
	System.out.println("InsertedValues is " +insertValues);
		
}
/* 
 * Here we don't need input from user. So statement is used and I execute the query and stored it in the 
 * resultset. Using that resultset I have displayed the output.
 * 
 */
public void display(Connection connect) throws SQLException,Exception {
	
	Statement stmt = connect.createStatement();
	ResultSet resultset = stmt.executeQuery("SELECT * from SwiggyManagement");
	while(resultset.next()) {
		System.out.println("Res Id: "+resultset.getInt(1)+", Res Name: "+resultset.getString(2)+", Own Name:"+resultset.getString(3)+", Food Type:"+resultset.getString(4)+", Price:"+resultset.getFloat(5)+", Location:"+resultset.getString(6)+", Ratings:"+resultset.getFloat(7));
	}
	
}
/* 
 * Have get the particular Id from user through prepared statement and getted the value. I have stored in resultset 
 * and displayed it in the output.
 * 
 */
public void search(Connection connect,Scanner scan) throws SQLException,Exception {
	
	PreparedStatement prep_stmt = connect.prepareStatement("SELECT * from SwiggyManagement where res_Id=?");
	System.out.println("Enter the restaurant id to search");
	prep_stmt.setInt(1, scan.nextInt());
	ResultSet resultset2 = prep_stmt.executeQuery();
	while(resultset2.next())
	System.out.println("Res Id: "+resultset2.getInt(1)+", Res Name: "+resultset2.getString(2)+", Own Name:"+resultset2.getString(3)+", Food Type:"+resultset2.getString(4)+", Price:"+resultset2.getFloat(5)+", Location:"+resultset2.getString(6)+", Ratings:"+resultset2.getFloat(7));
	
	}
/*
 * Have get the particular id from the user through prepared statement. Delete query has been runned to delete 
 * that particular record.
 * 
 */

public void delete(Connection connect,Scanner scan) throws SQLException, Exception {
	
	PreparedStatement del_stmt = connect.prepareStatement("DELETE from SwiggyManagement where res_Id=?");
	System.out.println("Enter the restaurant id to delete");
	del_stmt.setInt(1, scan.nextInt());
	int resultset = del_stmt.executeUpdate();
	System.out.println(resultset);
	
}
/*
 * Have got the id from user and update the new value. Here I have given the user with only updating option of
 * price.
 */
public void update(Connection connect,Scanner scan, int res_Id) throws SQLException,Exception {
	PreparedStatement upd_stmt = connect.prepareStatement("UPDATE  SwiggyManagement set  price=? where res_Id=?");//update query
	upd_stmt.setString(1,scan.next());
	upd_stmt.setInt(2,res_Id);
	int record=upd_stmt.executeUpdate();
	System.out.println(record);

	
}
}
