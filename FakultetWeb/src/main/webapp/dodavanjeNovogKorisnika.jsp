<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dodavanje novog korisnika</title>
</head>
<body>

	<%@ include file="header.jsp" %>
	
	<div class="content">
		<form action="/Fakultet/akontroler/dodavanjeKorisnika" method="post">
			<div class="text">Unesite potrebne podatke za novog korisnika:</div><br>
			<label>Ime:</label><input type="text" name="ime"><br>
			<label>Prezime:</label><input type="text" name="prezime"><br>
			<label>Korisnicko ime:</label><input type="text" name="korisnickoIme"><br>
			<label>Lozinka:</label><input type="text" name="lozinka"><br>
			<label>JMBG:</label><input type="text" name="jmbg"><br>
			<div class="text">Napomena: *uloge* koje korisnici mogu imati su: profesor, student, asistent ili administrator.</div><br>
			<label>Uloga:</label><input type="text" name="uloga"><br>
			<input type="submit" value="Potvrdi"><br><br>
		</form>
		<div class="poruka">
			${porukaKorisnik}
			${porukaGreskaK}
		</div>
	</div>

</body>
</html>