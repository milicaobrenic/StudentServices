<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dodavanje novog ispita</title>
</head>
<body>

	<%@ include file="header.jsp" %>
	
	<div class="content">
		<form action="/Fakultet/pkontroler/dodavanjeIspita" method="post">
			<div class="text">Izaberite predmet za koji dodajete ispit:</div>
				<select name="idPredmet">
					<c:forEach items="${predmetiP}" var="p">
						<option value="${p.idPredmet }">${p.naziv }</option>
					</c:forEach>
				</select>
				<div class="text">Izaberite rok za koji dodajete ispit:</div>
				<select name="idRok">
					<c:forEach items="${rokoviP}" var="r">
						<option value="${r.idRok }">${r.naziv }</option>
					</c:forEach>
				</select><br>
				<label>Unesite opis ispita:</label><input type="text" name="opis"><br>
			<input type="submit" value="Potvrdi"><br><br>
		</form>
		<div class="poruka">
			${porukaIspit }
		</div>
	</div>
</body>
</html>