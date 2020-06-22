package br.com.fourbbit.backend.enums;

public enum UserType {

	P("Professor"), C("Aluno");

	private String label;

	private UserType(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}