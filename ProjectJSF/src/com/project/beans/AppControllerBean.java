package com.project.beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class AppControllerBean {

	public String redirect() {
		return "/index?faces-redirect=false";
	}
	
	public AppControllerBean() { }
}
