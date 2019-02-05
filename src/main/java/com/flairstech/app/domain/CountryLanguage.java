package com.flairstech.app.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "country_language", schema = "public")
public class CountryLanguage implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "countryCode", column = @Column(name = "country_code", nullable = false, length = 3)),
			@AttributeOverride(name = "language", column = @Column(name = "language", nullable = false)) })
	private CountryLanguageId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_code", nullable = false, insertable = false, updatable = false)
	private Country country;

	@Column(name = "is_official", nullable = false)
	private boolean isOfficial;

	@Column(name = "percentage", nullable = false, precision = 8, scale = 8)
	private float percentage;

	public CountryLanguageId getId() {
		return this.id;
	}

	public void setId(CountryLanguageId id) {
		this.id = id;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public boolean isIsOfficial() {
		return this.isOfficial;
	}

	public void setIsOfficial(boolean isOfficial) {
		this.isOfficial = isOfficial;
	}

	public float getPercentage() {
		return this.percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

}
