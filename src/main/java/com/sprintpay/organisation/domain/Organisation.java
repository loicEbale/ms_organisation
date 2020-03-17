package com.sprintpay.organisation.domain;


import com.sprintpay.organisation.beans.RecetteBean;
import com.sprintpay.organisation.proxy.RestClientRecette;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.time.LocalDate;

/**
 * A Organisation.
 */
@Entity
@Table(name = "organisation")
public class Organisation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "registre_com")
    private String registreCom;

    @Column(name = "localisation")
    private String localisation;

    @Column(name = "date_creation")
    private LocalDate dateCreation;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public Organisation nom(String nom) {
        this.nom = nom;
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRegistreCom() {
        return registreCom;
    }

    public Organisation registreCom(String registreCom) {
        this.registreCom = registreCom;
        return this;
    }

    public void setRegistreCom(String registreCom) {
        this.registreCom = registreCom;
    }

    public String getLocalisation() {
        return localisation;
    }

    public Organisation localisation(String localisation) {
        this.localisation = localisation;
        return this;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public Organisation dateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
        return this;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Organisation)) {
            return false;
        }
        return id != null && id.equals(((Organisation) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Organisation{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", registreCom='" + getRegistreCom() + "'" +
            ", localisation='" + getLocalisation() + "'" +
            ", dateCreation='" + getDateCreation() + "'" +
            "}";
    }
}
