package com.monash;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value="employeeBean")
@SessionScoped
public class Employeebean implements Serializable {

	private String name = "Tony";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void callBean() {
	   String temp = this.getName();
	   
	   String temp2 = temp;
	}
	
}
