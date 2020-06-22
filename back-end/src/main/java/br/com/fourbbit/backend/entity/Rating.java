package br.com.fourbbit.backend.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;

@Embeddable
public class Rating {

	@Type(type = "text")
	@Column(name = "customer_description")
	private String customerDescription;

	@Column(name = "customer_rating", nullable = false, length = 1)
	private int customerRating;

	@Type(type = "text")
	@Column(name = "professional_description")
	private String professionalDescription;

	@Column(name = "professional_rating", nullable = false, length = 1)
	private int professionalRating;

	public Rating() {

	}

	public Rating(String customerDescription, int customerRating, String professionalDescription,
			int professionalRating) {
		super();
		this.customerDescription = customerDescription;
		this.customerRating = customerRating;
		this.professionalDescription = professionalDescription;
		this.professionalRating = professionalRating;
	}

	public String getCustomerDescription() {
		return customerDescription;
	}

	public void setCustomerDescription(String customerDescription) {
		this.customerDescription = customerDescription;
	}

	public int getCustomerRating() {
		return customerRating;
	}

	public void setCustomerRating(int customerRating) {
		this.customerRating = customerRating;
	}

	public String getProfessionalDescription() {
		return professionalDescription;
	}

	public void setProfessionalDescription(String professionalDescription) {
		this.professionalDescription = professionalDescription;
	}

	public int getProfessionalRating() {
		return professionalRating;
	}

	public void setProfessionalRating(int professionalRating) {
		this.professionalRating = professionalRating;
	}
}