<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prikaz korisnika</title>
</head>
<body>

	<%@ include file="header.jsp" %>
	
	<div class="content">
		<form action="/Fakultet/akontroler/prikazKorisnika" method="get">
		<div class="text">Prikaz svih korisnika:</div><br><br>
			<table border="1">
				<tr>
					<th>Ime</th>
					<th>Prezime</th>
					<th>Korisnicko ime</th>
					<th>Jbmg</th>
				</tr>
				<c:forEach items="${sviKorisnici}" var="k">
					<tr>
						<td>${k.ime }</td>
						<td>${k.prezime }</td>
						<td>${k.korisnickoIme }</td>
						<td>${k.jmbg }</td>
					</tr>
				</c:forEach>
			</table><br><br>
			<a href="/Fakultet/dodavanjeNovogKorisnika.jsp">Za unos novog korisnika kliknite ovde.</a>
		</form>
	</div>

</body>
</html>