package org.usfirst.frc.team5427.robot.config;

public class ConfObjectBool {
	String name;boolean var;
	


	public ConfObjectBool(String s, boolean b){
		this.name=s;this.var=b;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getVar() {
		return var;
	}

	public void setVar(boolean var) {
		this.var = var;
	}
}

