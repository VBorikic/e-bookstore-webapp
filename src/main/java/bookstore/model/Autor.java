package bookstore.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "autor")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "autorId")
public class Autor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "autor_id")
	@GeneratedValue
	private int autorId;

	@Column
	private String ime;

	@Column
	private String prezime;

	@Temporal(TemporalType.DATE)
	@Column(name = "datum_rodjenja")
	private Date datumRodjenja;

	@OneToMany(mappedBy = "autor", fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	// @JsonBackReference
	private List<Knjiga> listaKnjiga = new ArrayList<>();

	public Autor() {
		super();

	}

	public int getAutorId() {
		return autorId;
	}

	public void setAutorId(int autorId) {
		this.autorId = autorId;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public List<Knjiga> getListaKnjiga() {
		return listaKnjiga;
	}

	public void setListaKnjiga(List<Knjiga> listaKnjiga) {
		this.listaKnjiga = listaKnjiga;
	}

	@Override
	public String toString() {
		return "Autor [autorId=" + autorId + ", ime=" + ime + ", prezime=" + prezime + ", datumRodjenja="
				+ datumRodjenja + ", listaKnjiga=" + listaKnjiga + "]";
	}

}
