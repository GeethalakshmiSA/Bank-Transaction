package com.bank;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Controller Class - Servlet
public class UserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println(request.getRequestURI());
			if(request.getRequestURI().equals("/")){
				listTransaction(request, response);
			}
			else if((request.getRequestURI()).equals("/fund-Transfer")){
				System.out.println("if statement is true");
				fundTransfer(request, response);
			}
		} 
		catch (SQLException ex) {
			request.getRequestDispatcher("WEB-INF/views/Error.jsp").forward(request, response);
		}
	}
	
	/*           Method which gets the transaction history - DAO      */
	private void listTransaction(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// Transactions are retrieved and stored in a List
		List<User> listUser = UserData.selectAllUsers();
		
		// Attribute to set the List obtained
		request.setAttribute("listUser", listUser);
		
		float bal = User.getTotalBalance();
		System.out.println(bal);
		
		// Attribute to set the Current Total Balance
		request.setAttribute("bal", bal);
		
		// Response - List Jsp 
		request.getRequestDispatcher("WEB-INF/views/List.jsp").forward(request, response);
	}
	
	/*			Method Transfers Fund to Another account			*/
	private void fundTransfer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
		// Method call to debit Fund transfer
		boolean value = UserData.fundTransfer();
		System.out.println(value);
		
		// Debit = Success --> Home page
		if(value){
			listTransaction(request, response);
		}
		
		// Debit = Failure --> Error Page
		else{
			displayError(request, response);
		}
	}
	
	/*			Method displays error when fund transfer fails		*/
	private void displayError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> listUser = UserData.selectAllUsers();
		request.setAttribute("listUser", listUser);
		float bal = User.getTotalBalance();
		System.out.println(bal);
		request.setAttribute("bal", bal);
		request.getRequestDispatcher("WEB-INF/views/Error.jsp").forward(request, response);
	}

}
