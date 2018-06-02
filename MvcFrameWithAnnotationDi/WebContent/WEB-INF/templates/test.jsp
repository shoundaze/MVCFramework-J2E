<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../static/bootstrap.css"
	th:href="@{bootstrap.css}" />

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

	<div class="col-md-6" style="position :relative; position-left:50px">
		<div class="panel panel-primary">
			<div class="panel-heading">Opertaion</div>
			<div class="panel-body">
				<form action="../MyController/save" method="post">
					<div class="form-group">
						<label class="control-label">designation :</label> <input
							class="form-control" type="text" name="designation" />
					</div>
					<div class="form-group">
						<label class="control-label">prix :</label> <input
							class="form-control" type="text" name="prix" />
					</div>
					<div class="form-group">
						<label class="control-label">quantite :</label> <input
							class="form-control" type="text" name="qnatite" />
					</div>
					<input type="submit" />



				</form>
			</div>
		</div>
	</div>
</body>
</html>