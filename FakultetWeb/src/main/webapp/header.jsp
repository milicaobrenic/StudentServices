<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Informacioni sistem fakulteta</title>
	<base href="/">
	<link rel="stylesheet" 
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
	
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
	<link href="/Fakultet/css/style.css" type="text/css" rel="stylesheet">

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
	<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
	<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>
		
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-dark primary-color">
	<div class="container">
	<a class="navbar-brand" href="/Fakultet/index.jsp">Studentska sluzba</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<sec:authorize access="!isAuthenticated()">
				<li class="nav-item"><a class="nav-link"
					href="/Fakultet/login.jsp">Uloguj se</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/Fakultet/register.jsp">Napravi nalog</a></li>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<sec:authorize access="hasRole('PROFESOR')">
				 	<li class="nav-item"><a class="nav-link" href="/Fakultet/pkontroler/sviStudenti">Prikaz studenata</a></li>
				 	<li class="nav-item"><a class="nav-link" href="/Fakultet/pkontroler/sviIspiti">Prikaz ispita</a></li>
				 	<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/logout">Odjava</a></li>
				</sec:authorize>
				<sec:authorize access="hasRole('STUDENT')">
				 	<li class="nav-item"><a class="nav-link" href="/Fakultet/skontroler/semestriStudenta">Prikaz semestra</a></li>
				 	<li class="nav-item"><a class="nav-link" href="/Fakultet/skontroler/prijavaIspita">Prijava ispita</a></li>
				 	<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/logout">Odjava</a></li>
				</sec:authorize>
				<sec:authorize access="hasRole('ASISTENT')">
				 	<li class="nav-item"><a class="nav-link" href="/Fakultet/askontroler/predmetiAsistenta">Prikaz predmeta</a></li>
				 	<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/logout">Odjava</a></li>
				</sec:authorize>
				 <sec:authorize access="hasRole('ADMINISTRATOR')">
				 	<li class="nav-item"><a class="nav-link" href="/Fakultet/akontroler/prikazKorisnika">Prikaz korisnika</a></li>
				 	<li class="nav-item"><a class="nav-link" href="/Fakultet/akontroler/prikazPredmeta">Prikaz predmeta</a></li>
				 	<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/logout">Odjava</a></li>	
				</sec:authorize>
			</sec:authorize>
		</ul>
	</div>
	</div>
</nav>
</body>

</html>