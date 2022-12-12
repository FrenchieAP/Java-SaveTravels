<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Dashboard</h1>
		<table class="table" style=" width: 700px; color: white; background: linear-gradient(90deg, rgba(131,58,180,1) 0%, rgba(253,29,29,1) 50%, rgba(252,176,69,1) 100%); display: flex; flex-direction: column; justify-content: space-evenly; border:2px solid grey; border-radius: 25px;">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th>Description</th>
					<th>Created At</th>
					<th>Updated At</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="oneExpense" items="${allExpenses }">
					<tr>
						<td><c:out value="${oneExpense.id}" /></td>
						<td>
							<a href="/expenses/${oneExpense.id}">						
								<c:out value="${oneExpense.name}" />
							</a>
						</td>
						
						<td><c:out value="${oneExpense.vendor}" /></td>
						<td><c:out value="${oneExpense.amount}" /></td>
						<td><c:out value="${oneExpense.description}" /></td>
						<td><c:out value="${oneExpense.createdAt}" /></td>
						<td><c:out value="${oneExpense.updatedAt}" /></td>
						<td>
							<form action="/expenses/${oneExpense.id}/delete" method="POST">
								<input type="hidden" name="_method" value="delete">
								<button class="btn btn-danger">Delete</button>
							</form>
							<a class="btn btn-primary" href="/expenses/${oneExpense.id}/edit">Edit</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form:form modelAttribute="expenseObj" method="POST" action="/expenses/new" >
		<p>
				Name:
				<form:input type="text" path="name"/>
				<form:errors path="name" />
			</p>
			<p>
				Vendor:
				<form:input type="text" path="vendor"/>
				<form:errors path="vendor" />
			</p>
			<p>
				Amount:
				<form:input type="double" path="amount" />
				<form:errors path="amount" />
			</p>
			<p>
				Description:
				<form:input type="text" path="description" />
				<form:errors path="description" />
			</p>
			<button class="btn btn-success">Submit</button>
		</form:form>
	</div>
</body>
</html>
