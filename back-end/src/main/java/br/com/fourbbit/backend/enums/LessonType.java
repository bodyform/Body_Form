package br.com.fourbbit.backend.enums;

public enum LessonType {

	B("Ambas"), O("Online"), P("Presencial");

	private String label;

	private LessonType(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}