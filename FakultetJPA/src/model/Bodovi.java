package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bodovi database table.
 * 
 */
@Entity
@NamedQuery(name="Bodovi.findAll", query="SELECT b FROM Bodovi b")
public class Bodovi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBodovi;

	private String kolokvijumi;

	private String ukupno;

	private String usmeniIspit;

	//bi-directional many-to-one association to Ispit
	@ManyToOne
	private Ispit ispit;

	public Bodovi() {
	}

	public int getIdBodovi() {
		return this.idBodovi;
	}

	public void setIdBodovi(int idBodovi) {
		this.idBodovi = idBodovi;
	}

	public String getKolokvijumi() {
		return this.kolokvijumi;
	}

	public void setKolokvijumi(String kolokvijumi) {
		this.kolokvijumi = kolokvijumi;
	}

	public String getUkupno() {
		return this.ukupno;
	}

	public void setUkupno(String ukupno) {
		this.ukupno = ukupno;
	}

	public String getUsmeniIspit() {
		return this.usmeniIspit;
	}

	public void setUsmeniIspit(String usmeniIspit) {
		this.usmeniIspit = usmeniIspit;
	}

	public Ispit getIspit() {
		return this.ispit;
	}

	public void setIspit(Ispit ispit) {
		this.ispit = ispit;
	}

}