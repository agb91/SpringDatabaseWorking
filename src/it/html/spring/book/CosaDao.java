package it.html.spring.book;

import java.util.List;

public interface CosaDao {
	public void insert(Cosa cosa);

	public void update(Cosa cosa);

	public void delete(String isbn);

	public Cosa findByNome(String isbn);

	public List<Cosa> findAllBooks();

	public int bookCount();
}
