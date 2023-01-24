package org.octoosmo.PgJsonbDemo.repository;

import org.octoosmo.PgJsonbDemo.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<PersonEntity, UUID> {
}
