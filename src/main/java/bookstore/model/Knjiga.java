package bookstore.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "knjiga")
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

	@Temporal(TemporalType.DATE)
	@Column(name = "godina_izdanja")
	private Date godinaIzdanja;

	@Column(name = "broj_knjiga")
	private int brojKnjiga;

	@Column
	private double cena;

	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor autor;

	@ManyToOne
	@JoinColumn(name = "izdavac_id")
	private Izdavac izdavac;

	@OneToMany(mappedBy = "knjiga")
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

	public Date getGodinaIzdanja() {
		return godinaIzdanja;
	}

	public void setGodinaIzdanja(Date godinaIzdanja) {
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