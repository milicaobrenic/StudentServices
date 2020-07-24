<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dodavanje novog predmeta</title>
</head>
<body>
	
	<%@ include file="header.jsp" %>
	
	<div class="content">
		<form action="/Fakultet/akontroler/dodavanjePredmeta" method="post">
			<div class="text">Izaberite semestar za predmet:</div><br>
				<select name="idSemestar">
					<c:forEach items="${sviSemestri }" var="s">
						<option value="${s.idSemestar }">${s.naziv} semestar --- ${s.godina } godina</option>
					</c:forEach>
				</select><br>
				<label>Unesite naziv predmeta:</label><input type="text" name="naziv"><br>
				<label>Unesite opis predmeta:</label> <input type="text" name="opis"><br>
				<label>Unesite broj ESPB predmeta:</label> <input type="text" name="brojEspb"><br>
			<input type="submit" value="Potvrdi">
		</form>
		<div class="poruka">
			${porukaPredmet}
		</div>
	</div>
	
</body>
</html>