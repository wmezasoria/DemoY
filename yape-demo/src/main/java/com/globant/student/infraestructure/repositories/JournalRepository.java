package com.globant.student.infraestructure.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globant.student.domain.ports.repositories.IJournalRepository;
import com.globant.student.infraestructure.entities.Journal;
import com.globant.student.infraestructure.repositories.jpa.JournalJpa;

@Repository
public class JournalRepository implements IJournalRepository {
    @Autowired
    JournalJpa journalJpa;

    public Journal save(Journal account){
        return journalJpa.save(account);
    }


}