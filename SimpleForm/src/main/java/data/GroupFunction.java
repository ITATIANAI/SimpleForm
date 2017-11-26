package data;

import java.util.ArrayList;
import java.util.List;

public class GroupFunction extends BaseObject {

	private List<Function> functions;

	public GroupFunction() {
		functions = new ArrayList<>();
	}

	public List<Function> getFunctions() {
		return functions;
	}

	public void setFunctions(List<Function> functions) {
		this.functions = functions;
	}

	@Override
	public String toString() {
		return "GroupFunction [functions=" + functions + ", getFunctions()=" + getFunctions() + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getDescription()=" + getDescription() + ", getCtime()=" + getCtime()
				+ "]";
	}

}
