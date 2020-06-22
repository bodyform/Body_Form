package br.com.fourbbit.backend.enums;

public enum Progress {
	P("Pendente"), O("Aprovado"), D("Negado"), CA("Cancelado"), F("Finalizado"), CO("Confirmado");

	private String label;

	private Progress(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
