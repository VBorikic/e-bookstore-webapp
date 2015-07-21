package bookstore.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "izdavac")
public class Izdavac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "izdavac_id")
	@GeneratedValue
	private int izdavacId;

	@Column
	private String naziv;

	@OneToMany(mappedBy = "izdavac", fetch = FetchType.EAGER)
	private List<Knjiga> listaKnjiga = new ArrayList<>();

	public Izdavac() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIzdavacId() {
		return izdavacId;
	}

	public void setIzdavacId(int izdavacId) {
		this.izdavacId = izdavacId;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Knjiga> getListaKnjiga() {
		return listaKnjiga;
	}

	public void setListaKnjiga(List<Knjiga> listaKnjiga) {
		this.listaKnjiga = listaKnjiga;
	}

	@Override
	public String toString() {
		return naziv;
	}

}
