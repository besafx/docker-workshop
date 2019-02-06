package com.flairstech.app.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
@Table(name = "country", schema = "public")
@Data
public class Country implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "code", unique = true, nullable = false, length = 3)
	private String code;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "capital")
	private City city;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "continent", nullable = false)
	private String continent;

	@Column(name = "region", nullable = false)
	private String region;

	@Column(name = "surface_area", nullable = false, precision = 8, scale = 8)
	private float surfaceArea;

	@Column(name = "indep_year")
	private Short indepYear;

	@Column(name = "population", nullable = false)
	private int population;

	@Column(name = "life_expectancy", precision = 8, scale = 8)
	private Float lifeExpectancy;

	@Column(name = "gnp", precision = 10)
	private BigDecimal gnp;

	@Column(name = "gnp_old", precision = 10)
	private BigDecimal gnpOld;

	@Column(name = "local_name", nullable = false)
	private String localName;

	@Column(name = "government_form", nullable = false)
	private String governmentForm;

	@Column(name = "head_of_state")
	private String headOfState;

	@Column(name = "code2", nullable = false, length = 2)
	private String code2;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	private Set<CountryLanguage> countryLanguages = new HashSet<CountryLanguage>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	private Set<City> cities = new HashSet<City>(0);
	
	public List<String> getLanguages() {
		return this.countryLanguages.stream()
				.map(countryLangauge -> countryLangauge.getId().getLanguage())
				.collect(Collectors.toList());
	}
	
	public List<String> getOfficialLanguages() {
		return this.countryLanguages.stream()
				.filter(CountryLanguage::isIsOfficial)
				.map(countryLangauge -> countryLangauge.getId().getLanguage())
				.collect(Collectors.toList());
	}

}
