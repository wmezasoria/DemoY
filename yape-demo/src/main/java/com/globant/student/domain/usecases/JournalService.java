package com.globant.student.domain.usecases;

import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globant.student.domain.model.JournalDto;
import com.globant.student.domain.ports.repositories.IJournalRepository;
import com.globant.student.domain.ports.services.IJournalService;
import com.globant.student.infraestructure.entities.Journal;
import com.globant.student.infraestructure.rest.input.JournalInput;
import com.globant.student.infraestructure.util.ObjectMapperUtils;

import io.reactivex.rxjava3.core.Single;

@Service
public class JournalService implements IJournalService {
    private final IJournalRepository iJournalRepository;
//    private final IAccountRepository iAccountRepository;

    public JournalService(IJournalRepository journalRepository) {//, IAccountRepository accountRepository){
        this.iJournalRepository = journalRepository;
//        this.iAccountRepository = accountRepository;
    }

    @Transactional
    public JournalDto save(JournalInput journalInput) {
//        Account account = new Account();
        Float newBalance = null;
//        Optional<Account> accountOptional = iAccountRepository.findById(UUID.fromString(journalInput.getUuidAccount()));
//        if(!accountOptional.isEmpty()) {
//            account = accountOptional.get();
//        }

//        newBalance = account.getBalance()-journalInput.getAmount();
//        if(newBalance >= 0) {
            Journal journal = Journal.builder()
                    .uuidJournal(UUID.randomUUID())
//                    .account(account)//fk
                    .creationDate(new Date())
                    .balance(newBalance)
                    .amount(journalInput.getAmount())
                    .type(journalInput.getType())
                    .build();

            //update Account with the new balance
//            account.setBalance(journal.getBalance());
//            iAccountRepository.save(account);


            return ObjectMapperUtils.map(iJournalRepository.save(journal), JournalDto.class);
//        }else{
//            return null;
//        }

    }
    
    public Single<JournalDto> addBook(JournalInput journalInput) {
        return saveBookToRepository(journalInput);
    }
    
    private Single<JournalDto> saveBookToRepository(JournalInput journalInput) {
        return Single.create(singleSubscriber -> {
//            Optional<Author> optionalAuthor = authorRepository.findById(addBookRequest.getAuthorId());
//            if (!optionalAuthor.isPresent())
//                singleSubscriber.onError(new EntityNotFoundException());
//            else {
//                String addedBookId = iJournalRepository.save(toBook(addBookRequest)).getId();
//                singleSubscriber.onSuccess(addedBookId);
                
                
                Journal journal = Journal.builder()
                        .uuidJournal(UUID.randomUUID())
//                        .account(account)//fk
                        .creationDate(new Date())
                        .amount(journalInput.getAmount())
                        .type(journalInput.getType())
                        .build();
                singleSubscriber.onSuccess(ObjectMapperUtils.map(iJournalRepository.save(journal), JournalDto.class));
//            }
        });
    }


}
