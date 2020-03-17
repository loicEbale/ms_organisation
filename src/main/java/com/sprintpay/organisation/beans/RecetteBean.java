package com.sprintpay.organisation.beans;

import java.math.BigDecimal;

public class RecetteBean  {

    public RecetteBean() {

    }

    private Long id;

    private String intitule;

    private BigDecimal montant;

    private Long id_organisation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    
    public Long getId_organisation() {
		return id_organisation;
	}

	public void setId_organisation(Long id_organisation) {
		this.id_organisation = id_organisation;
	}

	@java.lang.Override
    public java.lang.String toString() {
        return "RecetteBean{" +
            "id=" + id +
            ", intitule='" + intitule + '\'' +
            ", montant=" + montant +
            ", organisation='" + id_organisation + '\'' +
            '}';
    }
}
