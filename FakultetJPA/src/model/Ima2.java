package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ima2 database table.
 * 
 */
@Entity
@NamedQuery(name="Ima2.findAll", query="SELECT i FROM Ima2 i")
public class Ima2 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIma2;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	private Korisnik korisnik;

	//bi-directional many-to-one association to Semestar
	@ManyToOne
	private Semestar semestar;

	public Ima2() {
	}

	public int getIdIma2() {
		return this.idIma2;
	}

	public void setIdIma2(int idIma2) {
		this.idIma2 = idIma2;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Semestar getSemestar() {
		return this.semestar;
	}

	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}

}