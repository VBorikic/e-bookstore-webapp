package bookstore.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;

@Embeddable
public class ArtikalPK implements Serializable {

	@Basic(optional = false)
	@Column(name = "narudzbenica_id")
	private Long narudzbenicaID;

	@Basic(optional = false)
	@Column(name = "knjiga_id")
	private Long knjigaID;

	@Basic(optional = false)
	@Column(name = "artikal_id")
	// ovo pogeldaj ako bude problema
	@GeneratedValue
	private Long artikalId;

	public ArtikalPK(Long narudzbenicaID, Long knjigaID) {
		super();
		this.narudzbenicaID = narudzbenicaID;
		this.knjigaID = knjigaID;
		// this.artikalId = artikalId;
	}

	public ArtikalPK() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getNarudzbenicaID() {
		return narudzbenicaID;
	}

	public void setNarudzbenicaID(Long narudzbenicaID) {
		this.narudzbenicaID = narudzbenicaID;
	}

	public Long getKnjigaID() {
		return knjigaID;
	}

	public void setKnjigaID(Long knjigaID) {
		this.knjigaID = knjigaID;
	}

	public Long getArtikalId() {
		return artikalId;
	}

	public void setArtikalId(Long artikalId) {
		this.artikalId = artikalId;
	}

	@Override
	public String toString() {
		return "ArtikalPK [narudzbenicaID=" + narudzbenicaID + ", knjigaID=" + knjigaID + ", artikalId=" + artikalId
				+ "]";
	}

}
