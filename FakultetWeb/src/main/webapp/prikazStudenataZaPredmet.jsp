<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prikaz studenata za predmet</title>
</head>
<body>

	<%@ include file="header.jsp" %>
	
	<div class="content">
		<form action="/Fakultet/askontroler/prikazStudenata" method="get">
			<div class="text">Prikaz studenata za predmet:</div><br><br>
			<table border="1">
				<tr>
					<th>Ime</th>
					<th>Prezime</th>
					<th>Jmbg</th>
					<th>Upis bodova</th>
				</tr>
				<c:forEach items="${studentiP }" var="s">
					<tr>
						<td>${s.ime }</td>
						<td>${s.prezime }</td>
						<td>${s.jmbg }</td>
						<td><a id="link" href="/Fakultet/askontroler/ispitiStudenta?idKorisnik=${s.idKorisnik}">Upis bodova</a></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>

</body>
</html>