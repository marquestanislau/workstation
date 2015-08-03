package com.project.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import com.project.report.ReportUtl;
import com.project.util.FacesUtil;
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
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context
				.getExternalContext().getResponse();
		response.reset();

		try {
			this.reports.exportarParaPdf("relatorio_utilizador.jasper",
					new Repositorio().getUsuarios().todos(), response);
			context.responseComplete();
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.adicionaMensagem(FacesMessage.SEVERITY_ERROR,
					FacesUtil.getMensagemI18n("relatorio_erro"));
		}
		
	}
}