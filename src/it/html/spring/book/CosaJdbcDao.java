package it.html.spring.book;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class CosaJdbcDao implements CosaDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// Inserimento
	public void insert(Cosa cosa) {
		jdbcTemplate.update(
				"insert into persone (nome, eta) values (?, ?)",
				new Object[] { cosa.getNome(), cosa.getEta() });
	}

	// Modifica
	public void update(Cosa cosa) {
		jdbcTemplate.update(
				"update persone set nome = ?, eta = ? where nome = ?",
				new Object[] { cosa.getNome(), cosa.getEta(),
						cosa.getNome() });
	}

	// Eliminazione
	public void delete(String nome) {
		jdbcTemplate.update("delete from persone where nome = ?",
				new Object[] { nome });
	}

	// Query di un intero
	public int bookCount() {
		int rowCount = jdbcTemplate.queryForInt("select count(1) from persone");
		return rowCount;
	}

	// Query di un singolo oggetto
	public Cosa findByNome(String isbn) {
		Cosa cosa = (Cosa) jdbcTemplate.queryForObject(
				"select * from persone where nome= ?", new Object[] { isbn },
				new CosaRowMapper());
		return cosa;
	}

	// Query di una lista
	public List<Cosa> findAllBooks() {
		List<Cosa> cosas = (List<Cosa>) jdbcTemplate.query(
				"select * from persone", new CosaRowMapper());
		return cosas;
	}

}