package bookstore.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ArtikalPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@Column(name = "narudzbenica_id")
	private Long narudzbenicaID;

	@Basic(optional = false)
	@Column(name = "knjiga_id")
	private Long knjigaID;

	// @Basic(optional = false)
	@Column(name = "artikal_id")
	// ovo pogeldaj ako bude problema
	// @GeneratedValue
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artikalId == null) ? 0 : artikalId.hashCode());
		result = prime * result + ((knjigaID == null) ? 0 : knjigaID.hashCode());
		result = prime * result + ((narudzbenicaID == null) ? 0 : narudzbenicaID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArtikalPK other = (ArtikalPK) obj;
		if (artikalId == null) {
			if (other.artikalId != null)
				return false;
		}
		else if (!artikalId.equals(other.artikalId))
			return false;
		if (knjigaID == null) {
			if (other.knjigaID != null)
				return false;
		}
		else if (!knjigaID.equals(other.knjigaID))
			return false;
		if (narudzbenicaID == null) {
			if (other.narudzbenicaID != null)
				return false;
		}
		else if (!narudzbenicaID.equals(other.narudzbenicaID))
			return false;
		return true;
	}

}