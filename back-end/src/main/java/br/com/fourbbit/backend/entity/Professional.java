package br.com.fourbbit.backend.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "professional")
public class Professional implements Serializable {

	private static final long serialVersionUID = -7100462314216162354L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@ManyToMany
	@JoinTable(name = "professional_activities", joinColumns = @JoinColumn(name = "professional_id"), inverseJoinColumns = @JoinColumn(name = "activity_id"))
	private List<Activity> activities;

	@ManyToMany
	@JoinTable(name = "professional_work_areas", joinColumns = @JoinColumn(name = "professional_id"), inverseJoinColumns = @JoinColumn(name = "district_id"))
	private List<District> workAreas;

	@ElementCollection
	@AttributeOverrides({ @AttributeOverride(name = "school", column = @Column(name = "school")),
			@AttributeOverride(name = "course", column = @Column(name = "course")),
			@AttributeOverride(name = "year", column = @Column(name = "year")),
			@AttributeOverride(name = "formationType", column = @Column(name = "type")) })
	private List<Formation> formations;

	@ElementCollection
	@AttributeOverrides({ @AttributeOverride(name = "companyName", column = @Column(name = "company_name")),
			@AttributeOverride(name = "occupation", column = @Column(name = "occupation")),
			@AttributeOverride(name = "description", column = @Column(name = "description")),
			@AttributeOverride(name = "locality", column = @Column(name = "locality")),
			@AttributeOverride(name = "startDate", column = @Column(name = "start_date")),
			@AttributeOverride(name = "finishDate", column = @Column(name = "finish_date")),
			@AttributeOverride(name = "currentJob", column = @Column(name = "current_job")) })
	private List<Experience> experiences;
	
	@OneToOne
	@JoinColumn(name  = "user_id", nullable = false)
	private User user;
	
	public Professional() {

	}

	public Professional(Integer id, List<Activity> activities, List<District> workAreas, List<Formation> formations,
			List<Experience> experiences, User user) {
		super();
		this.id = id;
		this.activities = activities;
		this.workAreas = workAreas;
		this.formations = formations;
		this.experiences = experiences;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public List<District> getWorkAreas() {
		return workAreas;
	}

	public void setWorkAreas(List<District> workAreas) {
		this.workAreas = workAreas;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}