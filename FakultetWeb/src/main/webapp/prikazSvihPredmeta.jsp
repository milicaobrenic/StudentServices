<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prikaz predmeta</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<div class="content">
		<form action="/Fakultet/akontroler/prikazPredmeta" method="get">
			<div class="text">Prikaz svih predmeta:</div><br><br>
			<table border="1">
				<tr>
					<th>Naziv</th>
					<th>Opis</th>
					<th>ESPB</th>			
				</tr>
				<c:forEach items="${sviPredmeti }" var="p">
					<tr>
						<td>${p.naziv }</td>
						<td>${p.opis }</td>
						<td>${p.brojEspb }</td>
					</tr>
				</c:forEach>
			</table><br><br>
			<a href="/Fakultet/akontroler/prikazSemestara">Za unos novog predmeta kliknite ovde.</a>
		</form>
	</div>
</body>
</html>