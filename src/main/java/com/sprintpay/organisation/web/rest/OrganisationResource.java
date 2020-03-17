package com.sprintpay.organisation.web.rest;

import com.sprintpay.organisation.domain.Organisation;
import com.sprintpay.organisation.proxy.RestClientRecette;
import com.sprintpay.organisation.repository.OrganisationRepository;
import com.sprintpay.organisation.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.sprintpay.organisation.domain.Organisation}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class OrganisationResource {
	
    private final Logger log = LoggerFactory.getLogger(OrganisationResource.class);

    private static final String ENTITY_NAME = "msOrganisationOrganisation";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final OrganisationRepository organisationRepository;
    
    private final RestClientRecette restClientRecette;
    
    public OrganisationResource(OrganisationRepository organisationRepository, RestClientRecette restClientRecette) {
        this.organisationRepository = organisationRepository;
        this.restClientRecette = restClientRecette;
    }

    /**
     * {@code POST  /organisations} : Create a new organisation.
     *
     * @param organisation the organisation to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new organisation, or with status {@code 400 (Bad Request)} if the organisation has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/organisations")
    public ResponseEntity<Organisation> createOrganisation(@RequestBody Organisation organisation) throws URISyntaxException {
        log.debug("REST request to save Organisation : {}", organisation);
        if (organisation.getId() != null) {
            throw new BadRequestAlertException("A new organisation cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Organisation result = organisationRepository.save(organisation);
        return ResponseEntity.created(new URI("/api/organisations/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /organisations} : Updates an existing organisation.
     *
     * @param organisation the organisation to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated organisation,
     * or with status {@code 400 (Bad Request)} if the organisation is not valid,
     * or with status {@code 500 (Internal Server Error)} if the organisation couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/organisations")
    public ResponseEntity<Organisation> updateOrganisation(@RequestBody Organisation organisation) throws URISyntaxException {
        log.debug("REST request to update Organisation : {}", organisation);
        if (organisation.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Organisation result = organisationRepository.save(organisation);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, organisation.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /organisations} : get all the organisations.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of organisations in body.
     */
    @GetMapping("/organisations")
    public List<Organisation> getAllOrganisations() {
        log.debug("REST request to get all Organisations");
        System.out.print("---------------------------");
        System.out.println(this.restClientRecette.getRecetteByIdOrg(1L));
        return organisationRepository.findAll();
    }

    /**
     * {@code GET  /organisations/:id} : get the "id" organisation.
     *
     * @param id the id of the organisation to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the organisation, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/organisations/{id}")
    public ResponseEntity<Organisation> getOrganisation(@PathVariable Long id) {
        log.debug("REST request to get Organisation : {}", id);
        Optional<Organisation> organisation = organisationRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(organisation);
    }

    /**
     * {@code DELETE  /organisations/:id} : delete the "id" organisation.
     *
     * @param id the id of the organisation to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/organisations/{id}")
    public ResponseEntity<Void> deleteOrganisation(@PathVariable Long id) {
        log.debug("REST request to delete Organisation : {}", id);
        organisationRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
