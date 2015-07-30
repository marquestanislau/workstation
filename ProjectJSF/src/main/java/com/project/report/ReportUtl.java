package com.project.report;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

import com.project.model.User;

public class ReportUtl {

	private static final String reportPath = "/relatorios/";
	private HttpServletResponse resposta;
	private Map<String, Object> parametros = new HashMap<String, Object>();

	public void exportarParaPdf(String relatorio, List<User> usuarios,
			HttpServletResponse resposta) throws Exception, JRException {
		this.resposta = resposta;
		InputStream relatorioStream = this.getClass().getResourceAsStream(
				reportPath + relatorio + ".jasper");
		System.out.println(relatorioStream.toString());
		System.out.println(reportPath + relatorio + ".jasper");
		JasperPrint print = JasperFillManager.fillReport(relatorioStream,
				this.parametros, new JRBeanCollectionDataSource(usuarios));
		
		JRExporter exportador = new JRPdfExporter();
		exportador.setParameter(JRExporterParameter.OUTPUT_STREAM, this.resposta.getOutputStream());
		exportador.setParameter(JRExporterParameter.JASPER_PRINT, print);
		
		this.resposta.setContentType("application/pdf");
		this.resposta.setHeader("Content-Disposition", "attachment; filename=\""
				+ relatorio + "\"");
		exportador.exportReport();
	}

}