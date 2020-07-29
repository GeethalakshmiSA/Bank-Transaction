<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset ="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

	<title>Bank Transaction</title>

</head>

<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: navy;"> 	
			<div>
				<a href="<%=request.getContextPath()%>/" class="navbar-brand"> Home </a>
			</div>
		</nav>
	</header> 
	
	<center>
	<br/><br/>
        <h1 style="color:maroon;" >Bank Transaction - Assignment</h1>
    </center>
    
	<div align="center" class="container">
		<caption>
			<br/>
			<h2 style="color: red; font-family: sans-serif;">Your Recent Transaction</h2>
		</caption>
		<table class="table table-bordered"> <hr>
			<thead class="thead-dark">
					<tr>
						<th style="font-weight: bold;">Transaction ID</th>
						<th>Transaction Type</th>
						<th>Amount Transferred</th>
						<th>Total Balance</th>
					</tr>
			</thead>			
			<c:forEach items="${listUser}" var="user1">
						<tr style="font-size: medium;">
							<td><c:out value="${user1.t_id}" /></td>
							<td><c:out value="${user1.t_type}" /></td>
							<td><c:out value="${user1.amount}" /></td>
							<td><c:out value="${user1.balance}" /></td>
						</tr>
			</c:forEach>
		</table> <hr>
		
		<div>
				<h3 style="font-weight: bold; font-family:fantasy; color:purple; center; font-size: 230%">Current Balance - Rs ${bal}</h3>
		</div>
			
		<br/>
			
		<div class="container text-center">
			<a href="<%=request.getContextPath()%>/fund-Transfer" class="btn btn-success"> Fund Transfer </a>
		</div>
			
	</div>
</body>
</html>