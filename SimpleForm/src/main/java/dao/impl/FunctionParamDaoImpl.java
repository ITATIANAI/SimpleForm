package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import dao.FunctionParamDao;
import data.FunctionParameter;

@Repository
public class FunctionParamDaoImpl implements FunctionParamDao {

	private static final Logger LOGGER = Logger.getLogger(FunctionParamDaoImpl.class);

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void save(FunctionParameter object) {
		String sql = "INSERT INTO FUN_PARAM (name, description, ctime) values (?,?,?)";
		jdbcTemplate.update(sql, object.getName(), object.getDescription(), object.getCtime());
		LOGGER.info("Created Function param = " + object.getName() + " Description = " + object.getDescription());
	}

	@Override
	public void update(FunctionParameter object) {
		String sql = "UPDATE FUN_PARAM SET NAME=?, DESCRIPTION=?, CTIME=? WHERE ID=?";
		jdbcTemplate.update(sql, object.getName(), object.getDescription(), object.getCtime(), object.getId());
		LOGGER.info("Updated Record with ID = " + object.getId());
	}

	@Override
	public void delete(FunctionParameter object) {
		String sql = "DELETE FROM FUN_PARAM WHERE ID=?";
		jdbcTemplate.update(sql, object.getId());
		LOGGER.info("Deleted Record with ID = " + object.getId());
	}

	@Override
	public FunctionParameter find(Long id) {
		String sql = "SELECT * FROM FUN_PARAM WHERE ID=?";
		return jdbcTemplate.queryForObject(sql, new FuncParamRowMapper(), id);
	}

	@Override
	public List<FunctionParameter> getAll() {
		String sql = "SELECT * FROM FUN_PARAM";
		List<FunctionParameter> parameters = jdbcTemplate.query(sql, new FuncParamRowMapper());
		return parameters;
	}

	private static final class FuncParamRowMapper implements RowMapper<FunctionParameter> {

		@Override
		public FunctionParameter mapRow(ResultSet resultset, int rowNumber) throws SQLException {
			FunctionParameter functionParam = new FunctionParameter();
			functionParam.setId(resultset.getLong("ID"));
			functionParam.setName(resultset.getString("NAME"));
			functionParam.setDescription(resultset.getString("DESCRIPTION"));
			functionParam.setCtime(resultset.getTimestamp("CTIME"));
			return functionParam;
		}

	}

	@Override
	public List<FunctionParameter> getFuncParamByFunctionId(Long funcId) {
		String sql = "SELECT * FROM FUN_PARAM WHERE FUNC_ID=?";
		List<FunctionParameter> parameters = jdbcTemplate.query(sql, new FuncParamRowMapper(), funcId);
		return parameters;
	}
}
