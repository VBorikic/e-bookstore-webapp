package bookstore.dao;

import bookstore.model.Artikal;
import bookstore.model.ArtikalPK;

public interface ArtikalDao {

	public ArtikalPK ubaciArtikal(Artikal a);

	public Artikal vratiArtikal(ArtikalPK a);
}
