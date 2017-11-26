package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import dao.GroupFunctionDao;
import data.GroupFunction;

@Repository
public class GroupFunctionDaoImpl implements GroupFunctionDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<GroupFunction> getAllGroups() {
		String sql = "SELECT * FROM GROUP_FUNCTION";
		List<GroupFunction> groups = jdbcTemplate.query(sql, new FunctionGroupRowMapper());
		return groups;
	}

	private static final class FunctionGroupRowMapper implements RowMapper<GroupFunction> {

		@Override
		public GroupFunction mapRow(ResultSet resultset, int rowNumber) throws SQLException {
			GroupFunction group = new GroupFunction();
			group.setId(resultset.getLong("ID"));
			group.setName(resultset.getString("NAME"));
			group.setDescription(resultset.getString("DESCRIPTION"));
			group.setCtime(resultset.getTimestamp("CTIME"));
			return group;
		}

	}

}
