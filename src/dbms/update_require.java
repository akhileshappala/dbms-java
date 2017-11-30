package dbms;

import java.io.*;
import java.util.Scanner;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Date;
public class update_require {
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
		System.out.println("Enter the item details");
                    System.out.println("enter asset_id");
                    String a = br.readLine();
                    System.out.println("enter emp_id");
                    String b = br.readLine();
                    
                    
PreparedStatement pstmt=conn.prepareStatement("select * from require where asset_id=? and emp_id=?");
pstmt.setString(1, a);
pstmt.setString(2, b);

ResultSet rs = pstmt.executeQuery();

System.out.println("enter what you want to update\n 1)quantity\n2)date\n3)state");
Scanner scan = new Scanner(System.in);
int sw = scan.nextInt();

switch(sw) {
case 1 :System.out.println("enter");
	int c = Integer.parseInt(br.readLine());
	pstmt = conn.prepareStatement("update require set quantity=?  where asset_id=? and emp_id=?");
	pstmt.setInt(1, c);
	pstmt.setString(2, a);
	pstmt.setString(3, b);
	
	pstmt.executeUpdate();

	System.out.println("Updation successful");
	break;

case 2:System.out.println("enter");
String d = br.readLine();
Date date=new SimpleDateFormat("yyyy-MM-dd").parse(d);
java.sql.Date sqlDate = new java.sql.Date(date.getTime());
pstmt = conn.prepareStatement("update require set date_requested=?  where asset_id=? and emp_id=?");
pstmt.setDate(1, sqlDate);
pstmt.setString(2, a);
pstmt.setString(3, b);
pstmt.executeUpdate();
System.out.println("Updation successful");
break;

case 3:System.out.println("enter newvalue");
     String e = br.readLine();
pstmt = conn.prepareStatement("update require set request_state"+ "=?  where asset_id=? and emp_id=?");

pstmt.setString(1, e);

pstmt.setString(2, a);

pstmt.setString(3, b);
pstmt.executeUpdate();

System.out.println("Updation successful");
break;

}
		}


                 catch (SQLException sqle) {
System.out.println(sqle);
System.exit(1);
                }
        }
}
