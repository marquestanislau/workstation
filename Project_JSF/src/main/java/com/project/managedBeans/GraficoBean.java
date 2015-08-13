package com.project.managedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.PieChartModel;

@ManagedBean
@ViewScoped
public class GraficoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private PieChartModel modelo;

	public GraficoBean() {
		modelo = new PieChartModel();
		modelo.set("Imelda", 2000);
		modelo.set("Sheila", 2005);
		modelo.set("Amélia", 20400);
		modelo.set("Estanislau", 24000);
		modelo.setTitle("Aqui ira ficar o grafico");
		modelo.setLegendPosition("w");
	}
	
	public PieChartModel getModelo() {
		return modelo;
	}

	public void setModelo(PieChartModel modelo) {
		this.modelo = modelo;
	}
	
}
