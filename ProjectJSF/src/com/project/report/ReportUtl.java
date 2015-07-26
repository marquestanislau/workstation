package com.project.report;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import com.project.model.User;

public class ReportUtl {

	private final String reportPath = "jasper/";

	@SuppressWarnings("unchecked")
	public void exportarParaPdf(String relatorio, List<User> usuarios,
			HttpServletResponse resposta) throws Exception {
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
				usuarios);
		@SuppressWarnings("rawtypes")
		JasperPrint jasperPrint = JasperFillManager.fillReport(getClass()
				.getResourceAsStream(reportPath + relatorio + ".jasper"),
				new HashMap(), beanCollectionDataSource);
		JasperExportManager.exportReportToPdfStream(jasperPrint, resposta.getOutputStream());
	}

}
