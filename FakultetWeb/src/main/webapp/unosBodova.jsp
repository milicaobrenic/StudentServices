<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Unos bodova</title>
</head>
<body>

	<%@ include file="header.jsp" %>
	
	<div class="content">
		<form action="/Fakultet/askontroler/upisivanjeBodova" method="post">
			<div class="text">Izaberite ispit za koji zelite da uneste bodove:</div>
				<select name="idIspit">
					<c:forEach items="${ispitiB }" var="i">
						<option value="${i.idIspit }">${i.opis} --- ${i.predmet.naziv } --- ${i.rok.naziv }</option>
					</c:forEach>
				</select><br><br>
				<label>Unesite bodove sa kolokvijuma:</label> <input type="text" name="kolokvijumi"><br><br>
				<label>Unesite bodove sa usmenog ispita:</label> <input type="text" name="usmeni"><br><br>
				<label>Unesite ukupan broj bodova:</label> <input type="text" name="ukupno"><br><br>
				<input type="submit" value="Potvrdi">
		</form>
		<div class="poruka">
			${porukaB}
		</div>
	</div>

</body>
</html>