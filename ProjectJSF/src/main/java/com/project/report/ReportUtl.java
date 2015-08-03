package com.project.report;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import com.project.model.User;
import com.project.util.excepcoes.RelatorioVazioException;

public class ReportUtl {

	public void exportarParaPdf(String relatorio, List<User> usuarios,
			HttpServletResponse resposta) throws IOException, JRException,
			RelatorioVazioException {

		JRBeanCollectionDataSource fonteDeDados = new JRBeanCollectionDataSource(
				usuarios);

		InputStream relatorioStream = this.getClass().getResourceAsStream(
				"/relatorios/" + relatorio);
		Map<String, Object> parametros = new HashMap<String, Object>();

		JasperPrint jasperPrint = JasperFillManager.fillReport(relatorioStream,
				parametros, fonteDeDados);

		String fileName = "utilizadores.pdf";
		resposta.setContentType("Application/pdf");
		resposta.setHeader("Content-Disposition", "attachment; filename=\""
				+ fileName + "\"");
		JasperExportManager.exportReportToPdfStream(jasperPrint,
				resposta.getOutputStream());

	}

}