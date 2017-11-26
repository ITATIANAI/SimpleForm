package service;

import java.util.List;

import data.FunctionParameter;

public interface FuncParamService {

	void save(FunctionParameter parameter);

	FunctionParameter findById(Long id);

	List<FunctionParameter> getAllParameters();

	List<FunctionParameter> getParameterByFunctionId(Long functionId);
}
