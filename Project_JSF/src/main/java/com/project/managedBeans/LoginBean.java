package com.project.managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class LoginBean {

	public LoginBean() {

	}
	
	public String verificarCredenciais() {
		return "home";
	}

}
