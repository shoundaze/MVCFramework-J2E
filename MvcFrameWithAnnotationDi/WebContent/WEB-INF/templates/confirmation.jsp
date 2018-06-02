<!DOCTYPE html>
<html>
<head>
<link rel
="stylesheet" type
="text/css" href="../static/bootstrap.css"
th:href
="@{bootstrap.css}"/>
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
	<ul class="nav navbar-nav">
  <li role="presentation" class="active"><a href="../MyController/test">ajouter Produit</a></li>
  <li role="presentation"><a href="../MyController/liste">Lister produit</a></li>
  
</ul> 
</div>
</div>
</nav>
<div class="col-md-6 col-sm-6 col-xs-12">
<div class="panel panel-info spacer">
<div class="panel-heading">Confirmation </div>
<div class="panel-body">
<div class="form-group">
<label class="control-label">ID:</label>
<label class="control-label" >${produit.id}</label>
</div>
<div class="form-group">
<label class="control-label">designation:</label>
<label class="control-label" >${produit.designation}</label>
</div>
<div class="form-group">
<label class="control-label">qte:</label>
<label class="control-label" >${produit.qnatite}</label>
</div>
<div class="form-group">
<label class="control-label">prix:</label>
<label class="control-label" >${produit.prix}</label>
</div>

</div>
</div>
</div>



</body>
</html>