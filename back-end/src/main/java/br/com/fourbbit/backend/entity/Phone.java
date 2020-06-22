package br.com.fourbbit.backend.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Phone {

	@Column(name = "ddd", length = 2)
	private String ddd;

	@Column(name = "number", length = 9)
	private String number;

	@Column(name = "whatsApp", columnDefinition = "TINYINT(1)")
	private boolean whatsApp;

	public Phone() {

	}

	public Phone(String ddd, String number, Boolean whatsApp) {
		super();
		this.ddd = ddd;
		this.number = number;
		this.whatsApp = whatsApp;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Boolean getWhatsApp() {
		return whatsApp;
	}

	public void setWhatsApp(Boolean whatsApp) {
		this.whatsApp = whatsApp;
	}
}