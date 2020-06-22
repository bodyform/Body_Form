package br.com.fourbbit.backend.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class Experience {

	@Column(name = "company_name", length = 150)
	private String companyName;

	@Column(name = "occupation", length = 150)
	private String occupation;

	@Type(type = "text")
	@Column(name = "description")
	private String description;

	@Column(name = "locality", length = 100)
	private String locality;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "start_date")
	private Date startDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "finish_date")
	private Date finishDate;

	@Column(name = "current_job")
	private boolean currentJob;

	public Experience() {

	}

	public Experience(String companyName, String occupation, String description, String locality, Date startDate,
			Date finishDate, boolean currentJob) {
		super();
		this.companyName = companyName;
		this.occupation = occupation;
		this.description = description;
		this.locality = locality;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.currentJob = currentJob;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public boolean isCurrentJob() {
		return currentJob;
	}

	public void setCurrentJob(boolean currentJob) {
		this.currentJob = currentJob;
	}
}