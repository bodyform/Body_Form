package br.com.fourbbit.backend.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.fourbbit.backend.enums.LessonType;
import br.com.fourbbit.backend.enums.UserType;

@Entity
@Table(name = "user")
public class User implements Serializable{

	private static final long serialVersionUID = 8305696706723776920L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@Column(name = "cpf", nullable = false, length = 11)
	private String cpf;

	@Column(name = "password", nullable = false, length = 250)
	private String password;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "birthdate", nullable = false)
	private Date birthdate;

	@Column(name = "photo", length = 500)
	private String photo;
	
	@ElementCollection
	@AttributeOverrides({ @AttributeOverride(name = "ddd", column = @Column(name = "ddd")),
			@AttributeOverride(name = "number", column = @Column(name = "number")),
			@AttributeOverride(name = "whatsapp", column = @Column(name = "whatsapp")) })
	private List<Phone> phones;
	
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "street")),
			@AttributeOverride(name = "number", column = @Column(name = "number")),
			@AttributeOverride(name = "complement", column = @Column(name = "complement")),
			@AttributeOverride(name = "zipCode", column = @Column(name = "zip_code")),
			@AttributeOverride(name = "district", column = @Column(name = "district")) })
	private Adress adress;
	
	@Column(name = "lesson_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private LessonType lessonType;
	
	@Column(name = "user_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private UserType userType;

	public User() {

	}

	public User(Integer id, String name, String cpf, String password, Date birthdate, String photo, List<Phone> phones,
			Adress adress, LessonType lessonType, UserType userType) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.password = password;
		this.birthdate = birthdate;
		this.photo = photo;
		this.phones = phones;
		this.adress = adress;
		this.lessonType = lessonType;
		this.userType = userType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public LessonType getLessonType() {
		return lessonType;
	}

	public void setLessonType(LessonType lessonType) {
		this.lessonType = lessonType;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}