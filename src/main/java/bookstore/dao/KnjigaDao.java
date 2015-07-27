package bookstore.dao;

import java.util.List;

import bookstore.model.Knjiga;

public interface KnjigaDao {

	public Long unesiNovuKnjigu(Knjiga knjiga);

	public List<Knjiga> vratiSveKnjige();

	public Knjiga vratiKnigu(Long isbn);

	public void obrisiKnjigu(Long isbn);
}
