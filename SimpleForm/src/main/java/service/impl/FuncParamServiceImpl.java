package service.impl;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.FunctionParamDao;
import data.FunctionParameter;
import service.FuncParamService;

@Service("funcParamService")
public class FuncParamServiceImpl implements FuncParamService, Serializable {

	private static final long serialVersionUID = 1L;
	private final FunctionParamDao functionParamDao;

	private static final Logger LOGGER = Logger.getLogger(FuncParamService.class);

	@Autowired
	public FuncParamServiceImpl(FunctionParamDao functionParamDao) {
		this.functionParamDao = functionParamDao;
	}

	@Override
	public void save(FunctionParameter parameter) {
		LOGGER.info("saving function parameter - " + parameter);
		functionParamDao.save(parameter);
	}

	@Override
	public FunctionParameter findById(Long id) {
		FunctionParameter parameter = functionParamDao.find(id);
		if (parameter != null) {
			LOGGER.info("Found 1 function parameter with id=" + id + ", :" + parameter);
		} else {
			LOGGER.info("There are no function parameters with id=" + id);
		}
		return parameter;
	}

	@Override
	public List<FunctionParameter> getAllParameters() {
		List<FunctionParameter> parameters = functionParamDao.getAll();
		if (parameters.isEmpty()) {
			return Collections.emptyList();
		}
		return parameters;
	}

	@Override
	public List<FunctionParameter> getParameterByFunctionId(Long functionId) {
		LOGGER.info("Getting parameters with functionId =" + functionId);
		List<FunctionParameter> parameters = functionParamDao.getFuncParamByFunctionId(functionId);
		if (parameters.isEmpty()) {
			return Collections.emptyList();
		}
		return parameters;
	}

}
