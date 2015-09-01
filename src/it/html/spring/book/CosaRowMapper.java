package it.html.spring.book;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CosaRowMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cosa cosa = new Cosa();
		cosa.setNome(rs.getString("nome"));
		cosa.setEta(rs.getString("eta"));
		return cosa;
	}
}