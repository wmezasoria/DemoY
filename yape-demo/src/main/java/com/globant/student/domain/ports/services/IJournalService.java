package com.globant.student.domain.ports.services;

import com.globant.student.domain.model.JournalDto;
import com.globant.student.infraestructure.rest.input.JournalInput;

import io.reactivex.rxjava3.core.Single;

/**
 * @author william.meza
 *
 */
public interface IJournalService {
	JournalDto save(JournalInput journalInput);
	
	public Single<JournalDto> addBook(JournalInput journalInput);
}
