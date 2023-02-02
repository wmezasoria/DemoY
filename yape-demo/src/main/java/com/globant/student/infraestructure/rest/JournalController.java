package com.globant.student.infraestructure.rest;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axell.reactive.servicedto.request.AddBookRequest;
import com.axell.reactive.webdto.response.BaseWebResponse;
import com.globant.student.domain.model.JournalDto;
import com.globant.student.domain.ports.services.IJournalService;
import com.globant.student.infraestructure.rest.input.FormatInput;
import com.globant.student.infraestructure.rest.input.JournalInput;
import com.globant.student.infraestructure.rest.output.FormatMessage;
import com.globant.student.infraestructure.rest.output.FormatOutput;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/journal/v1")
@CrossOrigin
@Slf4j
public class JournalController {

	@Autowired
	private IJournalService iJournalService;

	@PostMapping("/save")
	@Operation(description = "save journal")
	public ResponseEntity<FormatOutput<JournalDto>> save(@Valid @RequestBody FormatInput<JournalInput> input) {
		HttpStatus status = HttpStatus.CREATED;
		JournalDto journalDto = new JournalDto();
		FormatMessage message = new FormatMessage(String.valueOf(status.value()), status.getReasonPhrase());

		try {
			journalDto = iJournalService.save(input.getData());
			message = new FormatMessage(String.valueOf(status.value()), status.getReasonPhrase());
		} catch (NullPointerException e) {
			journalDto = JournalDto.builder()
					// .account(input.getData().getUuidAccount())
					.amount(input.getData().getAmount()).type(input.getData().getType()).build();
			message = new FormatMessage(String.valueOf(status.value()), "Saldo no disponible");
		}

		FormatOutput<JournalDto> formatOutput = new FormatOutput<>(List.of(journalDto), List.of(message));
		return new ResponseEntity<>(formatOutput, status);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Single<ResponseEntity<FormatOutput<JournalDto>>> addBook(@RequestBody FormatInput<JournalInput> input) {
		return iJournalService.save(input.getData()).subscribeOn(
				Schedulers.io()).map(
						s -> ResponseEntity.created(URI.create("/reactiveApi/journals/" + s))
						.body(BaseWebResponse.successNoData()));
	}
}
