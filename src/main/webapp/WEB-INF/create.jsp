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
		<h1>Data Binding Create</h1>
		<form:form modelAttribute="userObj" method="POST" action="/users/new/dataBinding" >
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
				<form:input type="amount" path="amount" />
				<form:errors path="amount" />
			</p>
			<p>
				Description:
				<form:input type="description" path="description" />
				<form:errors path="description" />
			</p>
			<button>Submit</button>
		</form:form>
	</div>
</body>
</html>
