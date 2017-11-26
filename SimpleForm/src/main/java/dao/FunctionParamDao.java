package dao;

import java.util.List;

import data.FunctionParameter;

public interface FunctionParamDao {

	void save(FunctionParameter o);

	void update(FunctionParameter o);

	void delete(FunctionParameter o);

	FunctionParameter find(Long id);

	List<FunctionParameter> getAll();

	List<FunctionParameter> getFuncParamByFunctionId(Long funcId);
}
