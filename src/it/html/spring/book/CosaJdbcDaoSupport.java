package it.html.spring.book;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class CosaJdbcDaoSupport extends JdbcDaoSupport implements CosaDao {

	// Inserimento
	public void insert(Cosa cosa) {
		getJdbcTemplate().update(
				"insert into persone (nome, eta) values (?, ?)",
				new Object[] { cosa.getNome(), cosa.getEta() });
	}

	// Modifica
	public void update(Cosa cosa) {
		getJdbcTemplate().update(
				"update persone set nome = ?, eta = ? where nome = ?",
				new Object[] { cosa.getNome(), cosa.getEta()});
	}

	// Eliminazione
	public void delete(String nome) {
		getJdbcTemplate().update("delete from persone where nome = ?",
				new Object[] { nome });
	}

	// Query di un intero
	public int bookCount() {
		int rowCount = getJdbcTemplate().queryForInt(
				"select count(1) from persone");
		return rowCount;
	}

	// Query di un singolo oggetto
	public Cosa findByNome(String nome) {
		Cosa cosa = (Cosa) getJdbcTemplate().queryForObject(
				"select * from persone where nome = ?", new Object[] {},
				new BeanPropertyRowMapper(Cosa.class));
		return cosa;
	}

	// Query di una lista di oggetti
	public List<Cosa> findAllBooks() {
		List<Cosa> cosas = (List<Cosa>) getJdbcTemplate().query(
				"select * from persone",
				ParameterizedBeanPropertyRowMapper.newInstance(Cosa.class));
		return cosas;
	}

}
