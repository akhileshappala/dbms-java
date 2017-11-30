package dbms;

import java.io.*;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;

import java.sql.SQLException;


public class insert_table {
	public static void main(String[] args) throws IOException, ParseException{

		//Load the PostgreSQL JDBC driver class
try{
Class.forName("org.postgresql.Driver");
                } catch (ClassNotFoundException cnfe){
System.out.println("Could not find the JDBC driver!");
System.exit(1);
                }
	
		//Enter the connection details
		String hostname = "localhost";	// If PostgreSQL is running on some other machine enter the IP address of the machine here
		String username = "postgres"; // Enter your PostgreSQL username
		String password = "u4cse15120"; // Enter your PostgreSQL password
		String dbName = "dbms project"; // Enter the name of the database that has the university tables.
		String connectionUrl = "jdbc:postgresql://" + hostname + "/" + dbName;
		Connection conn = null;

		//Connect to the database
try {
conn = DriverManager.getConnection(connectionUrl,username, password);
System.out.println("Connected successfullly");
                } catch (SQLException sqle) {
System.out.println("Connection failed");
		System.out.println(sqle);
		       // Uncomment the below line for a more detailed stack trace
		       // sqle.printStackTrace();
System.exit(1);
                }

		//Execute the query and print the results
		try {
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the details to be inserted in items:");
                    String a = br.readLine();
                    String b = br.readLine();
                    int c   = Integer.parseInt(br.readLine());
					String d = br.readLine();
					Date date=new SimpleDateFormat("yyyy-MM-dd").parse(d);
					java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
					
					
PreparedStatement pstmt=conn.prepareStatement("insert into require values(?,?,?,?)");
pstmt.setString(1, a);
pstmt.setString(2, b);
pstmt.setInt(3, c);
pstmt.setDate(4,sqlDate);




pstmt.executeUpdate();
System.out.println("Insertion successful");


                } catch (SQLException sqle) {
System.out.println(sqle);
System.exit(1);
                }
        }


}
