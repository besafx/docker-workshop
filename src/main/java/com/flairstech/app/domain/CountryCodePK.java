package com.flairstech.app.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Embeddable
public class CountryCodePK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String language;
	
	@ManyToOne
    @JoinColumn(name = "country_code")
    private Country country_code;

}
