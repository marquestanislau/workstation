package com.project.model;

public enum Gravidade {

	BAIXA("Baixa"),
	MEDIA("Media"),
	ALTA("Alta");
	
	private String label;
	
	private Gravidade(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
}
