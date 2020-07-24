<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prikaz semestara studenta</title>
</head>
<body>
	
	<%@ include file="header.jsp" %>
	
	<div class="content">
		<form action="/Fakultet/skontroler/predmetiStudenta" method="get">
			<div class="text">Izaberite semestar za koji zelite da prikazete predmete koje slusate:</div>
			<select name="idSemestar">
				<c:forEach items="${semestri}" var="s">
					<option value="${s.idSemestar }">${s.naziv} semestar ---- ${s.godina } godina</option>
				</c:forEach>
			</select><br><br>
			<input type="submit" value="Potvrdi">
		</form>
	</div>
</body>
</html>