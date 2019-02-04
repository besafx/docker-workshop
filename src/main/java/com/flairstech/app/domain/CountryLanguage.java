package com.flairstech.app.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "country_language")
public class CountryLanguage implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CountryCodePK id;

	private Boolean is_official;

	private Float percentage;

}
