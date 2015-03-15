package org.usfirst.frc.team5427.robot.config;

public class ConfObjectDoub {
	String name;Double var;
	


	public ConfObjectDoub(String s, double d){
		this.name=s;this.var=d;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getVar() {
		return var;
	}

	public void setVar(Double var) {
		this.var = var;
	}
}

