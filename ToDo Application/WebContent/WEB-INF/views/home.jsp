<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
	<title><c:out value="Page : ${page}"></c:out></title>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<style>
		h1{
			color: red;
		}
		p{
			color: green;
		}
		
	</style>
</head>
<body>
	<div class="container mt-3">
		<h1 class="text-center">${heading}</h1>
		<hr>

		<c:if test="${not empty message}">
			<div class="alert alert-success">
				<b><c:out value="${message}"></c:out></b>
			</div>
		</c:if>

		<div class="row mt-5 text-center">
			<div class="col-md-2">
				<div class="list-group">
					<button type="button" class="list-group-item list-group-item-action active">Menu</button>
					<a href='<c:url value = '/todo/add'> </c:url>' class="list-group-item list-group-item-action">Add TODO </a>
					<a href='<c:url value = '/todo/home'> </c:url>'class="list-group-item list-group-item-action">View TODO </a>
				</div>
			</div>
			<div class="col-md-10 text-center">
				<c:if test="${page=='home'}">
					<h1 class="text-center">All TODOs</h1>
					<hr>
					<c:forEach items="${todos}" var="todo">
						<div class="card">
							<div class="card-body">
								<h3>
									<c:out value="${todo.todoTitle}"></c:out>
								</h3>
								<p>
									<c:out value="${todo.todoContent}"></c:out>
								</p>
							</div>
						</div>
					</c:forEach>
				</c:if>

				<c:if test="${page=='add'}">
					<h1 class="text-center">Add TODO</h1>
					<hr>
					<form:form action="saveTodo" method="post" modelAttribute="todo">
						<div class="form-group">
							<form:input path="todoTitle" cssClass="form-control"
								placeholder="enter your todo title" />
						</div>
						<div class="form-group">
							<form:textarea path="todoContent" cssClass="form-control"
								placeholder="enter your todo content" cssStyle="height:200px" />
						</div>

						<div class="container text-center">
							<button class="btn btn-outline-success">ADD TODO</button>
						</div>
					</form:form>
				</c:if>

			</div>
		</div>

	</div>

</body>
</html>