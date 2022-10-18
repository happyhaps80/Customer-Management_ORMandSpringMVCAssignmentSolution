<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<title>CRM</title>
</head>
<body>
	<div class="container">
		<br>
		<h3 style="background-color:#04AA6D;">Customer Relationship Management</h3>
		<hr>
		<!-- Add a button -->
		<a href="/customers/show-add-form" class="btn btn-primary btn-sm mb-3">
			Add Customer </a> <a href="/" class="btn btn-primary btn-sm mb-3">Back</a>
		<!-- Add a search form -->
		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th style="background-color:#04AA6D;">First Name</th>
					<th style="background-color:#04AA6D;">Last Name</th>
					<th style="background-color:#04AA6D;">Email Id</th>
					<th style="background-color:#04AA6D;">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Customers}" var="tempCustomer">
					<tr>
						<td><c:out value="${tempCustomer.firstName}" /></td>
						<td><c:out value="${tempCustomer.lastName}" /></td>
						<td><c:out value="${tempCustomer.emailId}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/customers/show-update-form?customerId=${tempCustomer.id}"
							class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a href="/customers/delete?customerId=${tempCustomer.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">
								Delete </a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>



