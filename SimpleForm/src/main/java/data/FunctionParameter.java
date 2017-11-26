package data;

import java.io.Serializable;

public class FunctionParameter extends BaseObject implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "FunctionParameter [getId()=" + getId() + ", getName()=" + getName() + ", getDescription()="
				+ getDescription() + ", getCtime()=" + getCtime() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
