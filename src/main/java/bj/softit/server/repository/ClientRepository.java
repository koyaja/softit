package bj.softit.server.repository;

import bj.softit.server.domain.Client;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Client entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    Client findBySignature(String signature);
}
