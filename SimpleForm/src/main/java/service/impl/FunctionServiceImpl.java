package service.impl;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.FunctionDao;
import data.Function;
import service.FunctionService;

@Service("functionService")
public class FunctionServiceImpl implements FunctionService {

	private final FunctionDao functionDao;

	private static final Logger LOGGER = Logger.getLogger(FunctionService.class);

	@Autowired
	public FunctionServiceImpl(FunctionDao functionDao) {
		this.functionDao = functionDao;
	}

	@Override
	public List<Function> getFuncByGroupId(Long groupId) {
		LOGGER.info("Getting functions with groupId =" + groupId);
		List<Function> groups = functionDao.getFuncByGroupId(groupId);
		if (groups.isEmpty()) {
			return Collections.emptyList();
		}
		return groups;
	}

}
