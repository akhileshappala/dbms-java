package dbms;
import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu_driven {
	public static void main(String [] args) throws IOException, ParseException{
		  
		  try{
			  Class.forName("org.postgresql.Driver");
			                  } 
			  catch (ClassNotFoundException cnfe){
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
			   System.out.println("***************************************************************\n"
			   		+ "********************Connected successfully********************\n"+"***************************************************************\n");
			                  } 
			  catch (SQLException sqle) {
				  System.out.println("***************************************************************\n"
					   		+ "********************Failed********************\n"+"***************************************************************\n");
					                  
			  		System.out.println(sqle);
			  		       // Uncomment the below line for a more detailed stack trace
			  		       // sqle.printStackTrace();
			  System.exit(1);
			                  }
	        do{
	        Scanner in = new Scanner(System.in);
	        // Display the menu
	        System.out.println("1\t Search");
	        System.out.println("2\t Update");
	        System.out.println("3\t Insert");
	        

	        System.out.println("Please enter your choice:");
	        
	        //Get user's choice
	        int choice=in.nextInt();
	         
	        //Display the title of the chosen module
	        switch (choice) {
	            case 1: 

		//Execute the query and print the results
	            	Scanner in1 = new Scanner(System.in);
	            	// Display the menu
	            	System.out.println("1\t emp_id");
	            	System.out.println("2\t emp_name");
	            	System.out.println("3\t phone_no");
	            	System.out.println("4\t dept_name");


	            	System.out.println("Please enter your choice:");

	            	//Get user's choice
	            	int choice1=in.nextInt();
	            	 
	            	//Display the title of the chosen module
	            	switch (choice1) {
	            	    case 1: try {
	            			
	            	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	            	System.out.println("Enter a emp_id:");
	            	                String emp_id = br.readLine();

	            	PreparedStatement pstmt=conn.prepareStatement("select * from faculty where emp_id=?");
	            	pstmt.setString(1, emp_id);
	            	ResultSet rs = pstmt.executeQuery();
	            	System.out.println("emp_name\t"+"dept_name\t\t"+"phone_no\t\t");

	            	while(rs.next()){
	            	                        String name1 = rs.getString("emp_name");
	            	                        String name2 = rs.getString("dept_name");
	            	                        int name3 = rs.getInt("phone_no");
	            	                       
	            	                        System.out.println(name1+"\t\t"+name2+"\t\t"+name3);
	            	                        

	            	                }

	            		    }

	            		
	            		
	            		
	            	catch (SQLException sqle) {
	            	System.out.println(sqle);
	            	System.exit(1);
	            	            } 
	            	break;
	            	    case 2: try {
	            			
	            	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	            	System.out.println("Enter a emp_name:");
	            	                String emp_name = br.readLine();

	            	PreparedStatement pstmt=conn.prepareStatement("select * from faculty where emp_name=?");
	            	pstmt.setString(1, emp_name);
	            	ResultSet rs = pstmt.executeQuery();
	            	System.out.println("emp_id\t\t"+"dept_name\t\t"+"phone_no\t\t");

	            	while(rs.next()){
	            	                        String name1 = rs.getString("emp_id");
	            	                        String name2 = rs.getString("dept_name");
	            	                        int name3 = rs.getInt("phone_no");
	            	                     
	            	                        System.out.println(name1+"\t\t"+name2+"\t\t"+name3);   
	            	                }

	            		    }

	            		
	            		
	            		
	            	catch (SQLException sqle) {
	            	System.out.println(sqle);
	            	System.exit(1);
	            	            } 
	            	            break;
	            	    case 3: try {
	            			
	            	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	            	System.out.println("Enter a phone_nume:");
	            	               // String item_id = br.readLine();
	            	                int c   = Integer.parseInt(br.readLine());

	            	PreparedStatement pstmt=conn.prepareStatement("select * from faculty where phone_no=?");
	            	pstmt.setInt(1, c);
	            	ResultSet rs = pstmt.executeQuery();
	            	System.out.println("emp_id\t\t"+"emp_name\t\t"+"dept_name");
	            	while(rs.next()){
	            							String name1 = rs.getString("emp_id");
	            	                        String name2 = rs.getString("emp_name");
	            	                        String name3 = rs.getString("dept_name");
	            	                        

	            	System.out.println(name1+"\t\t"+name2+"\t\t\t"+name3);                            

	            	                }

	            		    }

	            		
	            		
	            		
	            	catch (SQLException sqle) {
	            	System.out.println(sqle);
	            	System.exit(1);
	            	            } 
	            	            break;
	            	    case 4:  try {
	            			
	            	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	            	System.out.println("Enter a dept_name:");
	            	                String dept_name = br.readLine();

	            	PreparedStatement pstmt=conn.prepareStatement("select * from faculty where dept_name=?");
	            	pstmt.setString(1, dept_name);
	            	ResultSet rs = pstmt.executeQuery();
	            	System.out.println("emp_id\t\t"+"emp_name\t\t"+"phone_no");
	            	while(rs.next()){
	            							String name1 = rs.getString("emp_id");
	            	                        String name2 = rs.getString("emp_name");
	            	                       int name3 = rs.getInt("phone_no");
	            	                        

	            	System.out.println(name1+"\t\t"+name2+"\t\t\t"+name3);                            

	            	                }

	            		    }

	            		
	            		
	            		
	            	catch (SQLException sqle) {
	            	System.out.println(sqle);
	            	System.exit(1);
	            	            }  
	            	             break;
	            	    default: System.out.println("Invalid choice");
	            	}//end of switch		
		   break;
	            case 2: try {
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
	                    break;
	            case 3: try {
	            	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	        		System.out.println("Enter the details to be inserted in items:");
	        		System.out.println("enter asset_id");
	                            String a = br.readLine();
	                            System.out.println("enter emp_id");
	                            String b = br.readLine();
	                            System.out.println("enter quantity");
	                            int c   = Integer.parseInt(br.readLine());
	                            System.out.println("date");
	        					String d = br.readLine();
	        					System.out.println("status");
	        					String e = "notcompleted";
	        	
	        					Date date=new SimpleDateFormat("yyyy-MM-dd").parse(d);
	        					java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
	        					
	        					
	        PreparedStatement pstmt=conn.prepareStatement("insert into require values(?,?,?,?,?)");
	        pstmt.setString(1, a);
	        pstmt.setString(2, b);
	        pstmt.setInt(3, c);
	        pstmt.setDate(4,sqlDate);
	        pstmt.setString(5, e);




	        pstmt.executeUpdate();
	        System.out.println("Insertion successful");


	    	                } catch (SQLException sqle) {
	    	System.out.println(sqle);
	    	System.exit(1);
	    	                } 
	                    break;
	             
	                     
	            default: System.out.println("Invalid choice");
	        }//end of switch
	        }while(true);
	    }//end of the main method

}
