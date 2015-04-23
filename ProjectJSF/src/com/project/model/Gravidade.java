package com.project.model;

public enum Gravidade {

	MEDIA("Media"),
	BAIXA("Baixa"),
	ALTA("Alta");
	
	private String label;
	
	private Gravidade(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
}
