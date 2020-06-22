package br.com.fourbbit.backend.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "state")
public class State implements Serializable {

	private static final long serialVersionUID = 7107110375582388286L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@Column(name = "uf", nullable = false, length = 2)
	private String uf;

	@OneToMany(mappedBy = "state", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	private List<City> cities;

	public State() {

	}

	public State(Integer id, String name, String uf, List<City> cities) {
		super();
		this.id = id;
		this.name = name;
		this.uf = uf;
		this.cities = cities;
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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}