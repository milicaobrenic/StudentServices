package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the predmet database table.
 * 
 */
@Entity
@NamedQuery(name="Predmet.findAll", query="SELECT p FROM Predmet p")
public class Predmet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPredmet;

	private String brojEspb;

	private String naziv;

	private String opis;

	private String potpisProfesora;

	//bi-directional many-to-one association to Ima
	@OneToMany(mappedBy="predmet")
	private List<Ima> imas;

	//bi-directional many-to-one association to Ispit
	@OneToMany(mappedBy="predmet")
	private List<Ispit> ispits;

	//bi-directional many-to-one association to Semestar
	@ManyToOne
	private Semestar semestar;

	public Predmet() {
	}

	public int getIdPredmet() {
		return this.idPredmet;
	}

	public void setIdPredmet(int idPredmet) {
		this.idPredmet = idPredmet;
	}

	public String getBrojEspb() {
		return this.brojEspb;
	}

	public void setBrojEspb(String brojEspb) {
		this.brojEspb = brojEspb;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getPotpisProfesora() {
		return this.potpisProfesora;
	}

	public void setPotpisProfesora(String potpisProfesora) {
		this.potpisProfesora = potpisProfesora;
	}

	public List<Ima> getImas() {
		return this.imas;
	}

	public void setImas(List<Ima> imas) {
		this.imas = imas;
	}

	public Ima addIma(Ima ima) {
		getImas().add(ima);
		ima.setPredmet(this);

		return ima;
	}

	public Ima removeIma(Ima ima) {
		getImas().remove(ima);
		ima.setPredmet(null);

		return ima;
	}

	public List<Ispit> getIspits() {
		return this.ispits;
	}

	public void setIspits(List<Ispit> ispits) {
		this.ispits = ispits;
	}

	public Ispit addIspit(Ispit ispit) {
		getIspits().add(ispit);
		ispit.setPredmet(this);

		return ispit;
	}

	public Ispit removeIspit(Ispit ispit) {
		getIspits().remove(ispit);
		ispit.setPredmet(null);

		return ispit;
	}

	public Semestar getSemestar() {
		return this.semestar;
	}

	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}

}