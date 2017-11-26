package data;

import java.util.ArrayList;
import java.util.List;

public class Function extends BaseObject {

	private List<FunctionParameter> parameters;

	public Function() {
		parameters = new ArrayList<>();
	}

	public List<FunctionParameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<FunctionParameter> parameters) {
		this.parameters = parameters;
	}

	@Override
	public String toString() {
		return "Function [parameters=" + parameters + ", getParameters()=" + getParameters() + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getDescription()=" + getDescription() + ", getCtime()=" + getCtime()
				+ "]";
	}

}
