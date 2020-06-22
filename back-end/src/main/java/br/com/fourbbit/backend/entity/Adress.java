package br.com.fourbbit.backend.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class Adress {

	@Column(name = "street", nullable = false, length = 100)
	private String street;

	@Column(name = "number", nullable = false, length = 10)
	private String number;

	@Column(name = "complement", length = 40)
	private String complement;

	@Column(name = "zip_code", nullable = false, length = 8)
	private String zipCode;

	@OneToOne
	@JoinColumn(name = "district_id", nullable = false)
	private District district;

	public Adress() {

	}

	public Adress(String street, String number, String complement, String zipCode, District district) {
		super();
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.zipCode = zipCode;
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}
}