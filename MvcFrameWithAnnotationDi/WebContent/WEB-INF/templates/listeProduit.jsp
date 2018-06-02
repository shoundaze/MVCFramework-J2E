
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../static/bootstrap.css"
	th:href="@{bootstrap.css}" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<ul class="nav navbar-nav">
				<li role="presentation" class="active"><a
					href="../MyController/test">ajouter Produit</a></li>
				<li role="presentation"><a href="../MyController/liste">Lister
						produit</a></li>

			</ul>
		</div>
	</div>
	</nav>
	<div class="container">
	<div class="panel panel-primary">
				<div class="panel-heading">Opertaion</div>
				<div class="panel-body">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>DES</th>
					<th>PRIX</th>
					<th>qte</th>
					<th>operations</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="produit" items="${produits}">
					<tr>

						<td>${produit.id}</td>
						<td>${produit.designation}</td>
						<td>${produit.prix}</td>
						<td>${produit.qnatite}</td>
						<td><a class="btn btn-danger" href="../MyController/supprimer?id=${produit.id}">supprimer</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>


	</div>
	</div>

</body>
</html>