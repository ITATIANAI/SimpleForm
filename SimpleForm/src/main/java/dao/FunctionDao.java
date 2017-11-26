package dao;

import java.util.List;

import data.Function;

public interface FunctionDao {

	List<Function> getFuncByGroupId(Long groupId);

}
