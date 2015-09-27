package com.project.managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class LoginBean {

	public LoginBean() {

	}
	
	public String verificarCredenciais() {
		return "home";
	}

}
