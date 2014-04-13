package mz.com.cstock.report;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public abstract class GenericReport {
	private static final String PATH = "/resources/jasper/";

	public void showReport(String jasper) {
		InputStream reportStream = this.getClass().getResourceAsStream(
				PATH + jasper);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/cstockDB", "root", "");

			JasperReport report = (JasperReport) JRLoader
					.loadObject(reportStream);
			@SuppressWarnings({ "unchecked", "rawtypes" })
			JasperPrint print = JasperFillManager.fillReport(report,
					new HashMap(), connection);
			try {
				UIManager.setLookAndFeel(new HiFiLookAndFeel());
			} catch (UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JasperViewer.viewReport(print, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
