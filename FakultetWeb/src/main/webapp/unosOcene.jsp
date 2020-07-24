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
		<form action="/Fakultet/pkontroler/upisOcene" method="post">
			<div class="text">Prikaz ispita izabranog studenta:</div>
			<select name="idIspit">
				<c:forEach items="${ispiti }" var="i">
					<option value="${i.idIspit }">Ispit: ${i.opis } --- Predmet: ${i.predmet.naziv } --- Rok: ${i.rok.naziv }</option>
				</c:forEach>
			</select><br><br>
			<label>Unesite ocenu:</label><input type="text" name="ocena"><br><br>
			<input type="submit" value="Potvrdi">
		</form>
		<div class="poruka">
			${porukaOcena }
		</div>
	</div>
</body>
</html>