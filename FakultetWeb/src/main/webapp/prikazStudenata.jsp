<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prikaz studenata</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<div class="content">
		<form action="/Fakultet/pkontroler/sviStudenti" method="get">
			<div class="text">Prikaz svih studenata:</div><br><br>
			<table border="1">
				<tr>
					<th>Ime</th>
					<th>Prezime</th>
					<th>Jmbg</th>
					<th>Prikaz ispita</th>
				</tr>
				<c:forEach items="${studenti }" var="s">
					<tr>
						<td>${s.ime }</td>
						<td>${s.prezime }</td>
						<td>${s.jmbg }</td>
						<td><a id="link" href="/Fakultet/pkontroler/ispitiStudenta?idKorisnik=${s.idKorisnik}">Prikazi ispite</a></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
</body>
</html>