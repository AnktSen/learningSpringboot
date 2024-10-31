<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">

<title>List Todos Page</title>
<style>
body {
	background-color: #efefef;
	color: white;
	width: max-width; /* Set the width to 500 pixels */
	height: 300px;
}

.element {
	width: 500px; /* Set the width to 500 pixels */
	height: 300px; /* Set the height to 300 pixels */
}

table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	/* text-align: center; */
	padding: 5px;
}

tr:nth-child(even) {
	background-color: Lightgreen;
}

#deleteButton:hover {
	background-color: blue;
	color: white;
}

#addButton:hover {
	background-color: blue;
	color: white;
}

h1 {
	text-align: center; /* Centers the text horizontally */
	background-color: #066d89;
}
</style>
</head>
<body>
	<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">

	<h1>Your Todos</h1>
	<table class="table">
		<thead>
			<tr>

				<th>Descripton</th>
				<th>Target Date</th>
				<th>Is Done?</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
			<tr>

				<td>${todo.description}</td>
				<td>${todo.targetDate}</td>
				<td>${todo.done}</td>
				<td><a href="delete-todo?id=${todo.id}"
					class="btn btn-danger" id="deleteButton">Delete</a>
				<td><a href="update-todo?id=${todo.id}"
					class="btn btn-success" id="deleteButton">Update</a>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<a href="add-todo" class="btn" id="addButton">Add Todo</a>
</div>
<%@ include file="common/footer.jspf"%>