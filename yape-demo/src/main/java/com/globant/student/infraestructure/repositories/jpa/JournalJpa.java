package com.globant.student.infraestructure.repositories.jpa;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.globant.student.infraestructure.entities.Journal;

/**
 * @author william.meza
 *
 */
public interface JournalJpa extends JpaRepository<Journal, UUID> {
}