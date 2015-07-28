package bookstore.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "knjiga")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "ISBN")
public class Knjiga implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue
	private Long ISBN;

	@Column
	private String naziv;

	@Column
	private String zanr;

	@Column(length = 2000)
	private String opis;

	@Column(name = "godina_izdanja")
	private int godinaIzdanja;

	@Column(name = "broj_knjiga")
	private int brojKnjiga;

	@Column
	private double cena;

	@ManyToOne
	@JoinColumn(name = "autor_id")
	// @JsonManagedReference
	private Autor autor;

	@ManyToOne
	@JoinColumn(name = "izdavac_id")
	// @JsonManagedReference
	private Izdavac izdavac;

	@OneToMany(mappedBy = "knjiga", fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Artikal> listaArtikala = new ArrayList<>();

	public Knjiga() {
		super();

	}

	public Long getISBN() {
		return ISBN;
	}

	public void setISBN(Long iSBN) {
		ISBN = iSBN;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getZanr() {
		return zanr;
	}

	public void setZanr(String zanr) {
		this.zanr = zanr;
	}

	public int getGodinaIzdanja() {
		return godinaIzdanja;
	}

	public void setGodinaIzdanja(int godinaIzdanja) {
		this.godinaIzdanja = godinaIzdanja;
	}

	public int getBrojKnjiga() {
		return brojKnjiga;
	}

	public void setBrojKnjiga(int brojKnjiga) {
		this.brojKnjiga = brojKnjiga;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Izdavac getIzdavac() {
		return izdavac;
	}

	public void setIzdavac(Izdavac izdavac) {
		this.izdavac = izdavac;
	}

	public List<Artikal> getListaArtikala() {
		return listaArtikala;
	}

	public void setListaArtikala(List<Artikal> listaArtikala) {
		this.listaArtikala = listaArtikala;
	}

	@Override
	public String toString() {
		return "Knjiga [ISBN=" + ISBN + ", naziv=" + naziv + ", zanr=" + zanr + ", godinaIzdanja=" + godinaIzdanja
				+ ", brojKnjiga=" + brojKnjiga + ", cena=" + cena + ", autor=" + autor + "]";
	}

}
