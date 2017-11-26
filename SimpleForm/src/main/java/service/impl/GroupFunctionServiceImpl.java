package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.GroupFunctionDao;
import data.GroupFunction;
import service.GroupFunctionService;

@Service("groupFunctionService")
public class GroupFunctionServiceImpl implements GroupFunctionService {

	private final GroupFunctionDao groupFunctionDao;

	private static final Logger LOGGER = Logger.getLogger(GroupFunctionService.class);

	@Autowired
	public GroupFunctionServiceImpl(GroupFunctionDao groupFunctionDao) {
		this.groupFunctionDao = groupFunctionDao;
	}

	@Override
	public List<GroupFunction> getAllGroups() {
		LOGGER.info("Getting the functions");
		List<GroupFunction> functions = groupFunctionDao.getAllGroups();

		if ((functions == null) || functions.isEmpty()) {
			return new ArrayList<>();
		}

		return functions;
	}
}
