package bj.softit.server.service;

import bj.softit.server.domain.Groupe;
import java.util.List;

/**
 * Service Interface for managing Groupe.
 */
public interface GroupeService {

    /**
     * Save a groupe.
     *
     * @param groupe the entity to save
     * @return the persisted entity
     */
    Groupe save(Groupe groupe);

    /**
     *  Get all the groupes.
     *  
     *  @return the list of entities
     */
    List<Groupe> findAll();

    /**
     *  Get the "id" groupe.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    Groupe findOne(Long id);

    /**
     *  Delete the "id" groupe.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
