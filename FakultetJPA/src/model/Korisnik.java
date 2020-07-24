package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the korisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKorisnik;

	private String ime;

	private String jmbg;

	private String korisnickoIme;

	private String lozinka;

	private String prezime;

	//bi-directional many-to-one association to Ima
	@OneToMany(mappedBy="korisnik")
	private List<Ima> imas;

	//bi-directional many-to-one association to Ima2
	@OneToMany(mappedBy="korisnik")
	private List<Ima2> ima2s;

	//bi-directional many-to-one association to Uloga
	@ManyToOne
	private Uloga uloga;

	//bi-directional many-to-one association to Polaze
	@OneToMany(mappedBy="korisnik")
	private List<Polaze> polazes;

	public Korisnik() {
	}

	public int getIdKorisnik() {
		return this.idKorisnik;
	}

	public void setIdKorisnik(int idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getJmbg() {
		return this.jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getKorisnickoIme() {
		return this.korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return this.lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<Ima> getImas() {
		return this.imas;
	}

	public void setImas(List<Ima> imas) {
		this.imas = imas;
	}

	public Ima addIma(Ima ima) {
		getImas().add(ima);
		ima.setKorisnik(this);

		return ima;
	}

	public Ima removeIma(Ima ima) {
		getImas().remove(ima);
		ima.setKorisnik(null);

		return ima;
	}

	public List<Ima2> getIma2s() {
		return this.ima2s;
	}

	public void setIma2s(List<Ima2> ima2s) {
		this.ima2s = ima2s;
	}

	public Ima2 addIma2(Ima2 ima2) {
		getIma2s().add(ima2);
		ima2.setKorisnik(this);

		return ima2;
	}

	public Ima2 removeIma2(Ima2 ima2) {
		getIma2s().remove(ima2);
		ima2.setKorisnik(null);

		return ima2;
	}

	public Uloga getUloga() {
		return this.uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}

	public List<Polaze> getPolazes() {
		return this.polazes;
	}

	public void setPolazes(List<Polaze> polazes) {
		this.polazes = polazes;
	}

	public Polaze addPolaze(Polaze polaze) {
		getPolazes().add(polaze);
		polaze.setKorisnik(this);

		return polaze;
	}

	public Polaze removePolaze(Polaze polaze) {
		getPolazes().remove(polaze);
		polaze.setKorisnik(null);

		return polaze;
	}

}