package com.bank;

	// Required Packages and Libraries
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

	// UserData class --> used as Data Access Object
	public class UserData {
		
		// Attributes for database connection
		private static String dburl  = "jdbc:mysql://127.0.0.1:3306/bank_transaction";
		private static String user = "root";
		private static String password = "sonniya2499GL";
		
		static Connection connection = null;
		static Statement myStmt = null;
		static ResultSet RS = null;

		// Method to List the last 5 Transactions
		public static List<User> selectAllUsers() {
			
			List<User> users = new ArrayList<User>();

			try {
				// 1. Establishing a Connection
				connection = (Connection)DriverManager.getConnection(dburl, user , password);
				System.out.println("Connected");
				
				// 2. Creating a statement
				myStmt = connection.createStatement();
				System.out.println("Created Statement");
				
				// 3. Getting the query records in a result set
				RS = myStmt.executeQuery("select * from  (select * from transaction order by transaction_id desc limit 5) display order by transaction_id");
			
				// 4. Processing the resultset
				// 5. User class constructor calling to set values and adding to ArrayList
				while(RS.next())
				{
					int t_id = RS.getInt("transaction_id");
					String t_type = RS.getString("transaction_type");
					float amount = RS.getFloat("amount");
					float balance = RS.getFloat("balance");
					users.add(new User(t_id, t_type, amount, balance));
					
				}
					
				// 6. Getting the Total Balance of the Last Transaction occured - Storing in ResultSet 'balance'
				ResultSet balance = myStmt.executeQuery("select balance from transaction order by transaction_id desc limit 1");
					
				// 7. Processing the ResultSet 'balance' and assigning to the setter attribute of User class
				while(balance.next()){
					float bal = balance.getFloat("balance");
					System.out.println(bal);
					User u = new User();
					u.setTotalBalance(bal);
				}
				
				// 8. closing ResultSet, Statement, Connection
				RS.close();
				myStmt.close();
				connection.close();
			} 
			
			// Handling Exception 
			catch (SQLException e) {
				System.out.println("=== SQL Exception ===");
			}
			
			// Returning the resultant ArrayList which has the last 5 transaction records of the account
			return users;
		}
		
		// Method to send 1000 Rupees to another account  
		public static boolean fundTransfer(){
			
			try{
				boolean value = false;
				
				// 1. Establishing mysql connection 
				connection = (Connection)DriverManager.getConnection(dburl, user , password);
				System.out.println("Connected");
				
				// 2. Creating a statement
				myStmt = connection.createStatement();
				System.out.println("Created Statement");
				
				// 3. ResultSet getting the value of total balance present after any transaction
				ResultSet rs1 = myStmt.executeQuery("select balance from transaction order by transaction_id desc limit 1");
				System.out.println("result set done");
				
				// 4. Processing the ResultSet 
				// 5. Debits the value of 1000 from account - done using PreparedStatement
				while(rs1.next()){
					float currentAmount = rs1.getFloat("balance");
				
					// 6. Debit - Success
					if(currentAmount >= 1000.00){
						String str = "insert into transaction (transaction_type , amount , balance) values ('Fund Transfer' , 1000.00 , ? )" ;
						PreparedStatement preparedStatement = connection.prepareStatement(str);
						System.out.println("PS is done");
						
						
							System.out.println("Inside while loop");
							float d = (float) (currentAmount - 1000.00);
							preparedStatement.setFloat(1, d);
							int rs2 = preparedStatement.executeUpdate();
							System.out.println(rs2);
						
						value = true;
					}
					
					// 7. Debit - Failure
					else if(currentAmount == 0){
						value =  false;
					}
					
				}
				
				// 8. Closing ResultSet, Statement, Connection
				RS.close();
				myStmt.close();
				connection.close();
				return value;
			}
			
			// Handles exception
			catch (Exception e){
				System.out.println(" === FUND TRANSFER ERROR === ");
				return false;
			}
		}
	}