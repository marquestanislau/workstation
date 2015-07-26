package com.project.report;

import java.io.File;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

@SuppressWarnings("deprecation")
public class ReportUtl {
	
	private final String reportPath = "jasper/";
	
	public void exportarParaPdf(String relatorio, HttpServletResponse resposta) throws Exception {
		File file = new File(reportPath + relatorio + ".jasper");
		JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(file);
		JRPdfExporter pdfReport = new JRPdfExporter();
		pdfReport.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		pdfReport.setParameter(JRExporterParameter.OUTPUT_STREAM, resposta.getOutputStream());
		pdfReport.exportReport();
	}
	
}
