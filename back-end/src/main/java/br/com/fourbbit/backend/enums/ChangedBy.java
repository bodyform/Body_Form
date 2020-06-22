package br.com.fourbbit.backend.enums;

public enum ChangedBy {

	P("Professor"), C("Aluno");

	private String label;

	private ChangedBy(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}