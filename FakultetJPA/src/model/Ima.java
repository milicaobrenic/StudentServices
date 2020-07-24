package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ima database table.
 * 
 */
@Entity
@NamedQuery(name="Ima.findAll", query="SELECT i FROM Ima i")
public class Ima implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIma;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	private Korisnik korisnik;

	//bi-directional many-to-one association to Predmet
	@ManyToOne
	private Predmet predmet;

	public Ima() {
	}

	public int getIdIma() {
		return this.idIma;
	}

	public void setIdIma(int idIma) {
		this.idIma = idIma;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Predmet getPredmet() {
		return this.predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

}