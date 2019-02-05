package com.flairstech.app.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class CountryLanguageId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "country_code", nullable = false, length = 3)
	private String countryCode;
	
	@Column(name = "language", nullable = false)
	private String language;
}
