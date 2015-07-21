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
@Table(name = "narudzbenica")
public class Narudzbenica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "narudzbenica_id")
	private Long narudzbenicaID;

	@Column(name = "suma_cene")
	private double sumaCene;

	@OneToMany(mappedBy = "narudzbenica", fetch = FetchType.EAGER)
	List<Artikal> listaArtikala = new ArrayList<>();

	// ubaci Korisnika

	//
	public Narudzbenica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getNarudzbenicaID() {
		return narudzbenicaID;
	}

	public void setNarudzbenicaID(Long narudzbenicaID) {
		this.narudzbenicaID = narudzbenicaID;
	}

	public double getSumaCene() {
		return sumaCene;
	}

	public void setSumaCene(double sumaCene) {
		this.sumaCene = sumaCene;
	}

	public List<Artikal> getListaArtikala() {
		return listaArtikala;
	}

	public void setListaArtikala(List<Artikal> listaArtikala) {
		this.listaArtikala = listaArtikala;
	}

	@Override
	public String toString() {
		return "Narudzbenica [narudzbenicaID=" + narudzbenicaID + ", sumaCene=" + sumaCene + ", listaArtikala="
				+ listaArtikala + "]";
	}

}
