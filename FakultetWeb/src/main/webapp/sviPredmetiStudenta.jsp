<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Predmeti koje student slusa</title>
</head>
<body>
	<%@ include file="header.jsp" %>

	<div class="content">
		<form action="/Fakultet/skontroler/predmetiStudenta" method="get">
			<div class="text">Predmeti koje slusate u izabranom semestru:</div><br><br>
			<table border="1">
				<tr>
					<th>Naziv</th>
					<th>Opis</th>
					<th>Espb</th>
				</tr>
				<c:forEach items="${predmeti}" var="p">
					<tr>
						<td>${p.naziv}</td>
						<td>${p.opis}</td>
						<td>${p.brojEspb}</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>

</body>
</html>