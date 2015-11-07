package mz.co.sisgf.report;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

import javafx.scene.control.DatePicker;
import mz.co.sisgf.model.Accao;
import mz.co.sisgf.model.Banco;
import mz.co.sisgf.model.dao.SimpleEntityManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class ReportUtil {

	public void createReport(String path, Banco b) {
		SimpleEntityManager simpleEntityManager = null;
		try {
			InputStream inputStream = this.getClass().getResourceAsStream(path);

			simpleEntityManager = new SimpleEntityManager("gestaoPU");

			Query query = simpleEntityManager.getEntityManager().createNamedQuery("Accao.findByBank");
			query.setParameter("banco_id", b.getId());

			List<Accao> lista = query.getResultList();
			
			JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(
					lista);
			Double total = calculaTotal(lista, b);			
			
			Map params = new HashMap();
			ImageIcon logo = new ImageIcon(getClass().getResource("../view/img/dc_logo.jpg"));
			params.put("logo", logo.getImage());
			params.put("userName", CamposUtil.userName);
			params.put("nome_banco", b.getNome());
			params.put("total", total.doubleValue());
			params.put("saldo_inicial", b.getSaldoInicial());
			
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, params, jrBeanCollectionDataSource);

			JasperViewer.viewReport(jasperPrint, false);
			simpleEntityManager.close();

		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}

	public void createReport(String path, Banco b, DatePicker dataInicioPicker, DatePicker dataFimPicker) {
		SimpleEntityManager simpleEntityManager = null;
		
		LocalDate ld = dataInicioPicker.getValue();
		Calendar day = Calendar.getInstance();
		day.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth());
		
		LocalDate ld_ = dataFimPicker.getValue();
		Calendar day_ = Calendar.getInstance();
		day_.set(ld_.getYear(), ld_.getMonthValue() - 1, ld_.getDayOfMonth());
		
		try {
			InputStream inputStream = this.getClass().getResourceAsStream(path);

			simpleEntityManager = new SimpleEntityManager("gestaoPU");

			Query query = simpleEntityManager.getEntityManager().createNamedQuery("Accao.findByDate");
			query.setParameter("banco_id", b.getId());
			query.setParameter("data_inicio", day);
			query.setParameter("data_fim", day_);

			List<Accao> lista = query.getResultList();
			
			JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(
					lista);
			
			Double total = calculaTotal(lista, b);
			
			Map params = new HashMap();
			ImageIcon logo = new ImageIcon(getClass().getResource("../view/img/dc_logo.jpg"));
						
			params.put("logo", logo.getImage());
			params.put("total", total.doubleValue());
			params.put("userName", CamposUtil.userName);
			params.put("nome_banco", b.getNome());
			params.put("inicio", day.getTime());
			params.put("fim", day_.getTime());
			params.put("saldo_inicial", b.getSaldoInicial());
			
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, params, jrBeanCollectionDataSource);

			JasperViewer.viewReport(jasperPrint, false);

			simpleEntityManager.close();

		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}
	
	private Double calculaTotal(List<Accao> accoes, Banco b) {
		Double total = new Double(b.getSaldoInicial());
		for (Accao a : accoes) {

			switch (a.getTipo()) {
			case TRANSFERENCIA_EFECTUADA:
				total -= a.getSaldo();
				break;
			case DEPOSITO:
				total += a.getSaldo();
				break;
			case LEVANTAMENTO:
				total -= a.getSaldo();
				break;
			case TRANSFERENCIA_RECEBIDA:
				total += a.getSaldo();
				break;
			default:
				break;
			}
		}
		return total;
	}
}
