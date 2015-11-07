package mz.co.sisgf.model;

public enum Tipo {

	LEVANTAMENTO("Levantamento"),
	TRANSFERENCIA_EFECTUADA("Transferencia Efectuada"),
	DEPOSITO("Deposito"),
	TRANSFERENCIA_RECEBIDA("Transferencia Recebida");
	
	private String label;
	
	private Tipo(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
}
