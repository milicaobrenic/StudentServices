<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prikaz predmeta asistenta</title>
</head>
<body>

	<%@ include file="header.jsp" %>
	
	<div class="content">
		<form action="/Fakultet/askontroler/predmetiAsistenta">
			<div class="text">Prikaz predmeta asistenta:</div><br><br>
			<table border="1">
				<tr>
					<th>Naziv</th>
					<th>Opis</th>
					<th>ESPB</th>	
					<th>Prikaz studenata</th>		
				</tr>
				<c:forEach items="${predmetiA }" var="p">
					<tr>
						<td>${p.naziv }</td>
						<td>${p.opis }</td>
						<td>${p.brojEspb }</td>
						<td><a id="link" href="/Fakultet/askontroler/prikazStudenata?idPredmet=${p.idPredmet}">Prikazi studente</a></td>
					</tr>
				</c:forEach>
			</table><br><br>
		</form>
	</div>

</body>
</html>