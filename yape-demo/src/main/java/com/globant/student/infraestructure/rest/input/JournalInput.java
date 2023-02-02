package com.globant.student.infraestructure.rest.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class JournalInput {
    @NotEmpty(message = "type must no be empty")
    private String type;

    //@NotEmpty(message = "amount must no be empty")
    private Float amount;

    @NotEmpty(message = "uuidAccount must no be empty")
    private String uuidAccount;

}
