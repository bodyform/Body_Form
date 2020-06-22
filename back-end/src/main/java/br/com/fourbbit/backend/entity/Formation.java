package br.com.fourbbit.backend.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.fourbbit.backend.enums.FormationType;

@Embeddable
public class Formation {

	@Column(name = "school")
	private String school;

	@Column(name = "course")
	private String course;

	@Column(name = "year")
	private String year;

	@Column(name = "formation_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private FormationType formationType;

	public Formation() {

	}

	public Formation(String school, String course, String year, FormationType formationType) {
		super();
		this.school = school;
		this.course = course;
		this.year = year;
		this.formationType = formationType;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public FormationType getFormationType() {
		return formationType;
	}

	public void setFormationType(FormationType formationType) {
		this.formationType = formationType;
	}
}