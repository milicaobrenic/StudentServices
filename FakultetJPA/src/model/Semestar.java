package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the semestar database table.
 * 
 */
@Entity
@NamedQuery(name="Semestar.findAll", query="SELECT s FROM Semestar s")
public class Semestar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSemestar;

	private String godina;

	private String naziv;

	//bi-directional many-to-one association to Ima2
	@OneToMany(mappedBy="semestar")
	private List<Ima2> ima2s;

	//bi-directional many-to-one association to Predmet
	@OneToMany(mappedBy="semestar")
	private List<Predmet> predmets;

	public Semestar() {
	}

	public int getIdSemestar() {
		return this.idSemestar;
	}

	public void setIdSemestar(int idSemestar) {
		this.idSemestar = idSemestar;
	}

	public String getGodina() {
		return this.godina;
	}

	public void setGodina(String godina) {
		this.godina = godina;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Ima2> getIma2s() {
		return this.ima2s;
	}

	public void setIma2s(List<Ima2> ima2s) {
		this.ima2s = ima2s;
	}

	public Ima2 addIma2(Ima2 ima2) {
		getIma2s().add(ima2);
		ima2.setSemestar(this);

		return ima2;
	}

	public Ima2 removeIma2(Ima2 ima2) {
		getIma2s().remove(ima2);
		ima2.setSemestar(null);

		return ima2;
	}

	public List<Predmet> getPredmets() {
		return this.predmets;
	}

	public void setPredmets(List<Predmet> predmets) {
		this.predmets = predmets;
	}

	public Predmet addPredmet(Predmet predmet) {
		getPredmets().add(predmet);
		predmet.setSemestar(this);

		return predmet;
	}

	public Predmet removePredmet(Predmet predmet) {
		getPredmets().remove(predmet);
		predmet.setSemestar(null);

		return predmet;
	}

}