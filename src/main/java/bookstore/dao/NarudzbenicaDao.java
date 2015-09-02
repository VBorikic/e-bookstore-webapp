package bookstore.dao;

import bookstore.model.Narudzbenica;

public interface NarudzbenicaDao {

	public Long napraviNarudzbenicu(Narudzbenica n);

	public void izmeniNarudzbenicu(Narudzbenica n);

	public Narudzbenica vratiNarudzbenicu(Long nar_id);
}
