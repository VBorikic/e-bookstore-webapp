package bookstore.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "artikal")
public class Artikal implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	protected ArtikalPK artikalPK;

	@Column(name = "broj_kupljenih_knjiga")
	private int brojKupljenihKnjiga;

	@ManyToOne
	@JoinColumn(name = "knjiga_id", insertable = false, updatable = false)
	private Knjiga knjiga;

	@ManyToOne
	@JoinColumn(name = "narudzbenica_id", insertable = false, updatable = false)
	private Narudzbenica narudzbenica;

	public Artikal(ArtikalPK artikalPK) {
		super();
		this.artikalPK = artikalPK;
	}

	public Artikal(Long knj, Long nar) {
		artikalPK = new ArtikalPK(knj, nar);

	}

	public Artikal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArtikalPK getArtikalPK() {
		return artikalPK;
	}

	public void setArtikalPK(ArtikalPK artikalPK) {
		this.artikalPK = artikalPK;
	}

	public int getBrojKupljenihKnjiga() {
		return brojKupljenihKnjiga;
	}

	public void setBrojKupljenihKnjiga(int brojKupljenihKnjiga) {
		this.brojKupljenihKnjiga = brojKupljenihKnjiga;
	}

	public Knjiga getKnjiga() {
		return knjiga;
	}

	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}

	public Narudzbenica getNarudzbenica() {
		return narudzbenica;
	}

	public void setNarudzbenica(Narudzbenica narudzbenica) {
		this.narudzbenica = narudzbenica;
	}

}
