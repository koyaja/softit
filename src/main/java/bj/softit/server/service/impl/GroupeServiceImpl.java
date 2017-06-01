package bj.softit.server.service.impl;

import bj.softit.server.service.GroupeService;
import bj.softit.server.domain.Groupe;
import bj.softit.server.repository.GroupeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service Implementation for managing Groupe.
 */
@Service
@Transactional
public class GroupeServiceImpl implements GroupeService{

    private final Logger log = LoggerFactory.getLogger(GroupeServiceImpl.class);
    
    private final GroupeRepository groupeRepository;

    public GroupeServiceImpl(GroupeRepository groupeRepository) {
        this.groupeRepository = groupeRepository;
    }

    /**
     * Save a groupe.
     *
     * @param groupe the entity to save
     * @return the persisted entity
     */
    @Override
    public Groupe save(Groupe groupe) {
        log.debug("Request to save Groupe : {}", groupe);
        Groupe result = groupeRepository.save(groupe);
        return result;
    }

    /**
     *  Get all the groupes.
     *  
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Groupe> findAll() {
        log.debug("Request to get all Groupes");
        List<Groupe> result = groupeRepository.findAll();

        return result;
    }

    /**
     *  Get one groupe by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Groupe findOne(Long id) {
        log.debug("Request to get Groupe : {}", id);
        Groupe groupe = groupeRepository.findOne(id);
        return groupe;
    }

    /**
     *  Delete the  groupe by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Groupe : {}", id);
        groupeRepository.delete(id);
    }
}
