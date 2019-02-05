package com.flairstech.app.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "country")
public class Country implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 3)
	private String code;

	private String name;

	private String continent;

	private String region;

	private Float surface_area;

	private Short indep_year;

	private Integer population;

	private Float life_expectancy;

	@Column(precision = 10, scale = 2)
	private BigDecimal gnp;

	@Column(precision = 10, scale = 2)
	private BigDecimal gnp_old;

	private String local_name;

	private String government_form;

	private String head_of_state;

	@Column(length = 2)
	private String code2;

	@ManyToOne
	@JoinColumn(name = "capital")
	private City capital;
}
