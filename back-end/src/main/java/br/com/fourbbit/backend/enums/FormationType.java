package br.com.fourbbit.backend.enums;

public enum FormationType {
	D("Diploma"), C("Certificação"), L("Palestra"), LI("Licença");

	private String label;

	private FormationType(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}