package com.globant.student.domain.model;

import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JournalDto {
	private UUID uuidJournal;
	private Date creationDate;
	private String type;
	private Float amount;
	private Float balance;
	private UUID uuidAccount;

}
