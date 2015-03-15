package org.usfirst.frc.team5427.robot.config;

public class ConfObjectInt {
	String name;Integer var;
	


	public ConfObjectInt(String s, int i){
		this.name=s;this.var=i;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getVar() {
		return var;
	}

	public void setVar(Integer var) {
		this.var = var;
	}
}

