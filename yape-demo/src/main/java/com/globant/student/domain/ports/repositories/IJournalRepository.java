package com.globant.student.domain.ports.repositories;

import com.globant.student.infraestructure.entities.Journal;

/**
 * @author william.meza
 *
 */
public interface IJournalRepository {
    Journal save(Journal journal);

}
