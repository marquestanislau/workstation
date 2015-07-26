package com.project.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import com.project.report.ReportUtl;
import com.project.util.Repositorio;

@ManagedBean
@RequestScoped
public class RelatoriosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private ReportUtl reports;
	
	public RelatoriosBean() {
		reports = new ReportUtl();
	}

	public void gerarRelatorioUtilizadores() {
		System.out.println("Working on reports..");
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse)context.getExternalContext().getResponse();
		try {
			this.reports.exportarParaPdf("relatorio_utilizador", new Repositorio().getUsuarios().todos() ,response);
			context.responseComplete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}