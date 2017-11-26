package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import dao.FunctionDao;
import data.Function;

@Repository
public class FunctionDaoImpl implements FunctionDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Function> getFuncByGroupId(Long groupId) {
		String sql = "SELECT * FROM FUNCTIONS WHERE ID_GROUP = ?";
		List<Function> functions = jdbcTemplate.query(sql, new FunctionRowMapper(), groupId);
		return functions;
	}

	private static final class FunctionRowMapper implements RowMapper<Function> {

		@Override
		public Function mapRow(ResultSet resultset, int rowNumber) throws SQLException {
			Function function = new Function();
			function.setId(resultset.getLong("ID"));
			function.setName(resultset.getString("NAME"));
			function.setDescription(resultset.getString("DESCRIPTION"));
			function.setCtime(resultset.getTimestamp("CTIME"));
			return function;
		}

	}

}
