package com.project.model;

public enum Role {
	ADMIN("Administrador"), NORMAL("Normal");

	private String label;

	private Role(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}
}
