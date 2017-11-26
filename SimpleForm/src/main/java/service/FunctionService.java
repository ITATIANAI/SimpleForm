package service;

import java.util.List;

import data.Function;

public interface FunctionService {

	List<Function> getFuncByGroupId(Long groupId);

}
