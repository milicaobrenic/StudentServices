<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prikaz ispita</title>
</head>
<body>
	
	<%@ include file="header.jsp" %>
	
	<div class="content">
		<form action="/Fakultet/pkontroler/sviIspiti" method="get">
			<div class="text">Prikaz svih ispita:</div><br><br>
			<table border="1">
				<tr>
					<th>Opis</th>
					<th>Predmet</th>
					<th>Rok</th>
				</tr>
				<c:forEach items="${ispitiP }" var="i">
					<tr>
						<td>${i.opis }</td>
						<td>${i.predmet.naziv }</td>
						<td>${i.rok.naziv }</td>
					</tr>
				</c:forEach>
			</table><br><br>
			<a href="/Fakultet/pkontroler/sviPredmeti">Za unos novog ispita kliknite ovde.</a>
		</form>
	</div>

</body>
</html>