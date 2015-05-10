package com.project.model;

public enum Gravidade {

	LEVE("Leve"),
	MEDIA("Media"),
	GRAVE("Grave");
	
	private String label;
	
	private Gravidade(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
}
