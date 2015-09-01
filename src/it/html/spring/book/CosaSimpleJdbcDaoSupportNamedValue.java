package it.html.spring.book;

import java.util.List;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

public class CosaSimpleJdbcDaoSupportNamedValue extends SimpleJdbcDaoSupport
		implements CosaDao {

	// Inserimento
	public void insert(Cosa cosa) {
		// Binding automatico dei parametri
		SqlParameterSource parameters = new BeanPropertySqlParameterSource(cosa);
		// Inserimento
		getSimpleJdbcTemplate()
				.update(
						"insert into persone (nome, eta) values (:nome, :eta)",
						parameters);
	}

	// Modifica
	public void update(Cosa cosa) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("nome", cosa.getNome());
		parameters.addValue("eta", cosa.getEta());
		getSimpleJdbcTemplate()
				.update(
						"update persone set nome = :nome, eta = :eta where nome = :nome",
						parameters);
	}

	// Eliminazione
	public void delete(String nome) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("nome", nome);
		getSimpleJdbcTemplate().update("delete from persone where nome = :nome",
				parameters);
	}

	// Query di un intero
	public int bookCount() {
		int rowCount = getJdbcTemplate().queryForInt(
				"select count(1) from persone");
		return rowCount;
	}

	// Query di un singolo oggetto
	public Cosa findByNome(String nome) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("nome", nome);
		Cosa cosa = getSimpleJdbcTemplate().queryForObject(
				"select * from persone where nome = :nome",
				ParameterizedBeanPropertyRowMapper.newInstance(Cosa.class),
				parameters);
		return cosa;
	}

	// Query di una lista di oggetti
	public List<Cosa> findAllBooks() {
		List<Cosa> cosas = getSimpleJdbcTemplate().query("select * from persone",
				ParameterizedBeanPropertyRowMapper.newInstance(Cosa.class));
		return cosas;
	}

}
