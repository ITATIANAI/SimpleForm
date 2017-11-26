package ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;

import data.Function;
import data.FunctionParameter;
import data.GroupFunction;
import service.FuncParamService;
import service.FunctionService;
import service.GroupFunctionService;

@ManagedBean
@ViewScoped
public class SimpleFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(SimpleFormBean.class);

	@ManagedProperty(value = "#{funcParamService}")
	private FuncParamService funcParamService;

	@ManagedProperty(value = "#{functionService}")
	private FunctionService functionService;

	@ManagedProperty(value = "#{groupFunctionService}")
	private GroupFunctionService groupFunctionService;

	private List<Function> functionsList;
	private List<FunctionParameter> parametersList;
	private List<GroupFunction> groupsList;

	private List<Function> filteredFunctionsList;
	private List<FunctionParameter> filteredFuncParamList;

	private GroupFunction selectedGroup;
	private Function selectedFunction;

	@PostConstruct
	public void init() {
		LOGGER.info("Initializing " + this.getClass());
		filteredFunctionsList = new ArrayList<>();
		filteredFuncParamList = new ArrayList<>();
		groupsList = groupFunctionService.getAllGroups();
	}

	public void getSelectedFunctionsList(SelectEvent event) {
		selectedGroup = (GroupFunction) event.getObject();
		LOGGER.info("Selected group with id " + selectedGroup.getId());
		filteredFuncParamList = new ArrayList<>();
		filteredFunctionsList = functionService.getFuncByGroupId(selectedGroup.getId());
	}

	public void getSelectedFuncParamList(SelectEvent event) {
		selectedFunction = (Function) event.getObject();
		LOGGER.info("Selected function with id " + selectedFunction.getId());
		filteredFuncParamList = funcParamService.getParameterByFunctionId(selectedFunction.getId());
	}

	public void setFuncParamService(FuncParamService funcParamService) {
		this.funcParamService = funcParamService;
	}

	public void setFunctionService(FunctionService functionService) {
		this.functionService = functionService;
	}

	public void setGroupFunctionService(GroupFunctionService groupFunctionService) {
		this.groupFunctionService = groupFunctionService;
	}

	public FuncParamService getFuncParamService() {
		return funcParamService;
	}

	public FunctionService getFunctionService() {
		return functionService;
	}

	public GroupFunctionService getGroupFunctionService() {
		return groupFunctionService;
	}

	public List<Function> getFunctionsList() {
		return functionsList;
	}

	public void setFunctionsList(List<Function> functionsList) {
		this.functionsList = functionsList;
	}

	public List<FunctionParameter> getParametersList() {
		return parametersList;
	}

	public void setParametersList(List<FunctionParameter> parametersList) {
		this.parametersList = parametersList;
	}

	public List<GroupFunction> getGroupsList() {
		return groupsList;
	}

	public void setGroupsList(List<GroupFunction> groupsList) {
		this.groupsList = groupsList;
	}

	public GroupFunction getSelectedGroup() {
		return selectedGroup;
	}

	public void setSelectedGroup(GroupFunction selectedGroup) {
		this.selectedGroup = selectedGroup;
	}

	public Function getSelectedFunction() {
		return selectedFunction;
	}

	public void setSelectedFunction(Function selectedFunction) {
		this.selectedFunction = selectedFunction;
	}

	public List<Function> getFilteredFunctionsList() {
		return filteredFunctionsList;
	}

	public void setFilteredFunctionsList(List<Function> filteredFunctionsList) {
		this.filteredFunctionsList = filteredFunctionsList;
	}

	public List<FunctionParameter> getFilteredFuncParamList() {
		return filteredFuncParamList;
	}

	public void setFilteredFuncParamList(List<FunctionParameter> filteredFuncParamList) {
		this.filteredFuncParamList = filteredFuncParamList;
	}

}
