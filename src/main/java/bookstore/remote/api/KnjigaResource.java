package bookstore.remote.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bookstore.model.Knjiga;
import bookstore.services.BookStoreService;

@RestController
@RequestMapping(value = "/knjige")
public class KnjigaResource {

	Logger logger = LoggerFactory.getLogger(KnjigaResource.class);

	protected BookStoreService bookstoreService;

	// Knjiga API
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Knjiga> getAllKnjige() {
		return bookstoreService.vratiSveKnjige();
	}

	@RequestMapping(value = "/{knjigaId}", method = RequestMethod.GET)
	public @ResponseBody Knjiga getBlog(@PathVariable("knjigaId") Long knjigaID) {
		return bookstoreService.vratiKnjigu(knjigaID);
	}

	@RequestMapping(value = "/{knjigaId}", method = RequestMethod.PUT)
	public @ResponseBody Knjiga updateBlog(@PathVariable("knjigaId") Long knjigaID) {
		return bookstoreService.vratiKnjigu(knjigaID);
	}

	@RequestMapping(value = "/{knjigaId}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteBlog(@PathVariable("knjigaId") Long knjigaID) {
		bookstoreService.obrisiKnjigu(knjigaID);
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Knjiga createKnjiga(@RequestBody Knjiga knjiga) {
		// blog.setCreated(new Date());
		return bookstoreService.unesiNovuKnjigu(knjiga);
	}

	// brisanje knjige
	// @RequestMapping(value = "/{blogId}", method = RequestMethod.DELETE)
	// public @ResponseBody void deleteBlog(@PathVariable("blogId") Long blogId) {
	// bookstoreService.(blogId);
	// }
	// setteri i getteri
	public BookStoreService getBookStoreService() {
		return bookstoreService;
	}

	public void setBookStoreService(BookStoreService bookStoreService) {
		this.bookstoreService = bookStoreService;
	}

}
