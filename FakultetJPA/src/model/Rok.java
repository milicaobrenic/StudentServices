package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rok database table.
 * 
 */
@Entity
@NamedQuery(name="Rok.findAll", query="SELECT r FROM Rok r")
public class Rok implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRok;

	private String naziv;

	//bi-directional many-to-one association to Ispit
	@OneToMany(mappedBy="rok")
	private List<Ispit> ispits;

	public Rok() {
	}

	public int getIdRok() {
		return this.idRok;
	}

	public void setIdRok(int idRok) {
		this.idRok = idRok;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Ispit> getIspits() {
		return this.ispits;
	}

	public void setIspits(List<Ispit> ispits) {
		this.ispits = ispits;
	}

	public Ispit addIspit(Ispit ispit) {
		getIspits().add(ispit);
		ispit.setRok(this);

		return ispit;
	}

	public Ispit removeIspit(Ispit ispit) {
		getIspits().remove(ispit);
		ispit.setRok(null);

		return ispit;
	}

}