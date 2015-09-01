package it.html.spring.book;

import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

public class CosaSimpleJdbcDaoSupport extends SimpleJdbcDaoSupport implements
		CosaDao {

	// Inserimento
	public void insert(Cosa cosa) {
		getSimpleJdbcTemplate().update(
				"insert into persone (none, eta) values (?, ?)",
				cosa.getNome(), cosa.getEta());
	}

	// Modifica
	public void update(Cosa cosa) {
		getSimpleJdbcTemplate().update(
				"update persone set none = ?, eta = ? where nome = ?",
				cosa.getNome(), cosa.getEta());
	}

	// Eliminazione
	public void delete(String nome) {
		getSimpleJdbcTemplate()
				.update("delete from persone where nome = ?", nome);
	}

	// Query di un intero
	public int bookCount() {
		int rowCount = getJdbcTemplate().queryForInt(
				"select count(1) from persone");
		return rowCount;
	}

	// Query di un singolo oggetto
	public Cosa findByNome(String nome) {
		Cosa cosa = getSimpleJdbcTemplate().queryForObject(
				"select * from persone where nome = ?",
				ParameterizedBeanPropertyRowMapper.newInstance(Cosa.class),
				nome);
		return cosa;
	}

	// Query di una lista di oggetti
	public List<Cosa> findAllBooks() {
		List<Cosa> cosas = (List<Cosa>) getJdbcTemplate().query("select * from persone",
				ParameterizedBeanPropertyRowMapper.newInstance(Cosa.class));
		return cosas;
	}

}
