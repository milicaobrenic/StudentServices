package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ispit database table.
 * 
 */
@Entity
@NamedQuery(name="Ispit.findAll", query="SELECT i FROM Ispit i")
public class Ispit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIspit;

	private String ocena;

	private String opis;

	//bi-directional many-to-one association to Predmet
	@ManyToOne
	private Predmet predmet;

	//bi-directional many-to-one association to Rok
	@ManyToOne
	private Rok rok;

	//bi-directional many-to-one association to Polaze
	@OneToMany(mappedBy="ispit")
	private List<Polaze> polazes;

	//bi-directional many-to-one association to Bodovi
	@OneToMany(mappedBy="ispit")
	private List<Bodovi> bodovis;

	public Ispit() {
	}

	public int getIdIspit() {
		return this.idIspit;
	}

	public void setIdIspit(int idIspit) {
		this.idIspit = idIspit;
	}

	public String getOcena() {
		return this.ocena;
	}

	public void setOcena(String ocena) {
		this.ocena = ocena;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Predmet getPredmet() {
		return this.predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Rok getRok() {
		return this.rok;
	}

	public void setRok(Rok rok) {
		this.rok = rok;
	}

	public List<Polaze> getPolazes() {
		return this.polazes;
	}

	public void setPolazes(List<Polaze> polazes) {
		this.polazes = polazes;
	}

	public Polaze addPolaze(Polaze polaze) {
		getPolazes().add(polaze);
		polaze.setIspit(this);

		return polaze;
	}

	public Polaze removePolaze(Polaze polaze) {
		getPolazes().remove(polaze);
		polaze.setIspit(null);

		return polaze;
	}

	public List<Bodovi> getBodovis() {
		return this.bodovis;
	}

	public void setBodovis(List<Bodovi> bodovis) {
		this.bodovis = bodovis;
	}

	public Bodovi addBodovi(Bodovi bodovi) {
		getBodovis().add(bodovi);
		bodovi.setIspit(this);

		return bodovi;
	}

	public Bodovi removeBodovi(Bodovi bodovi) {
		getBodovis().remove(bodovi);
		bodovi.setIspit(null);

		return bodovi;
	}

}