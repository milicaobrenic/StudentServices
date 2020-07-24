package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the polaze database table.
 * 
 */
@Entity
@NamedQuery(name="Polaze.findAll", query="SELECT p FROM Polaze p")
public class Polaze implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPolaze;

	//bi-directional many-to-one association to Ispit
	@ManyToOne
	private Ispit ispit;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	private Korisnik korisnik;

	public Polaze() {
	}

	public int getIdPolaze() {
		return this.idPolaze;
	}

	public void setIdPolaze(int idPolaze) {
		this.idPolaze = idPolaze;
	}

	public Ispit getIspit() {
		return this.ispit;
	}

	public void setIspit(Ispit ispit) {
		this.ispit = ispit;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

}