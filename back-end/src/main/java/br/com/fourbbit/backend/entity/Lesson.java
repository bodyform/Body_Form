package br.com.fourbbit.backend.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "lesson")
public class Lesson implements Serializable {

	private static final long serialVersionUID = 4929444019595982483L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Column(name = "date")
	private LocalDateTime localDateTime;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "street")),
			@AttributeOverride(name = "number", column = @Column(name = "number")),
			@AttributeOverride(name = "complement", column = @Column(name = "complement")),
			@AttributeOverride(name = "zipCode", column = @Column(name = "zip_code")),
			@AttributeOverride(name = "district", column = @Column(name = "district")) })
	private Adress adress;

	@OneToOne
	@JoinColumn(name = "activity_id", nullable = false)
	private Activity activity;

	@OneToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	@OneToOne
	@JoinColumn(name = "professional_id", nullable = false)
	private Professional professional;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "customerDescription", column = @Column(name = "description")),
			@AttributeOverride(name = "customerRating", column = @Column(name = "rating")),
			@AttributeOverride(name = "professionalDescription", column = @Column(name = "rating_professional_description")),
			@AttributeOverride(name = "professionalRating", column = @Column(name = "rating_professional_rating")) })
	private Rating rating;

	@ElementCollection
	@AttributeOverrides({
			@AttributeOverride(name = "date", column = @Column(name = "status_date")),
			@AttributeOverride(name = "reason", column = @Column(name = "status_reason")),
			@AttributeOverride(name = "value", column = @Column(name = "status_value")),
			@AttributeOverride(name = "progress", column = @Column(name = "status_progress")),
			@AttributeOverride(name = "changedBy", column = @Column(name = "status_changed_by")) })
	private List<Status> status;

	public Lesson() {

	}

	public Lesson(Integer id, LocalDateTime localDateTime, Adress adress, Activity activity, Customer customer, Professional professional,
			Rating rating, List<Status> status) {
		super();
		this.id = id;
		this.localDateTime = localDateTime;
		this.adress = adress;
		this.activity = activity;
		this.customer = customer;
		this.professional = professional;
		this.rating = rating;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Professional getProfessional() {
		return professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public List<Status> getStatus() {
		return status;
	}

	public void setStatus(List<Status> status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}