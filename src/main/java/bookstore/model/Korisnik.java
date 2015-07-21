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
@Table(name = "korisnik")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "korisnik_id")
	private Long korisnikID;

	@Column
	private String ime;
	@Column
	private String prezime;

	@Column(name = "user_name")
	private String userName;

	@Column
	private String password;

	@OneToMany(mappedBy = "narudzbenica_id", fetch = FetchType.EAGER)
	private List<Narudzbenica> listaNarudzbenica = new ArrayList<>();

	public Korisnik() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getKorisnikID() {
		return korisnikID;
	}

	public void setKorisnikID(Long korisnikID) {
		this.korisnikID = korisnikID;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Narudzbenica> getListaNarudzbenica() {
		return listaNarudzbenica;
	}

	public void setListaNarudzbenica(List<Narudzbenica> listaNarudzbenica) {
		this.listaNarudzbenica = listaNarudzbenica;
	}

	@Override
	public String toString() {
		return "Korisnik [korisnikID=" + korisnikID + ", ime=" + ime + ", prezime=" + prezime + ", userName=" + userName
				+ ", password=" + password + ", listaNarudzbenica=" + listaNarudzbenica + "]";
	}

}
