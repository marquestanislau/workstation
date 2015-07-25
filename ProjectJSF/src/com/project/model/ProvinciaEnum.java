package com.project.model;

public enum ProvinciaEnum {
	MAPUTO("Maputo"),
	CIDADE_DE_MAPUTO("Cidade de Maputo"),
	INHAMBANE("Inhambane"), 
	NAMPULA("Nampula"), 
	ZAMBEZIA("Zambezia"), 
	NIASSA("Niassa"), 
	CABO_DELGADO("Cabo Delgado"), 
	TETE("Tete"), 
	GAZA("Gaza"), 
	SOFALA("Sofala"), 
	MANICA("Manica");
	
	private String label;
	
	private ProvinciaEnum(String label) {
		setLabel(label);
	}
	
	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
