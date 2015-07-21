package bookstore.services;

import java.util.List;

import bookstore.model.Autor;
import bookstore.model.Izdavac;
import bookstore.model.Knjiga;

public interface BookStoreService {

	public List<Autor> vratiSveAutore();

	public List<Izdavac> vratiSveIzdavace();

	public Knjiga unesiNovuKnjigu(Knjiga knjiga);
}
