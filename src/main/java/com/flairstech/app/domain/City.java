package com.flairstech.app.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "city", schema = "public")
@Data
public class City implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_code", nullable = false)
	private Country country;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "district", nullable = false)
	private String district;

	@Column(name = "population", nullable = false)
	private int population;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
	private Set<Country> countries = new HashSet<Country>(0);

}
