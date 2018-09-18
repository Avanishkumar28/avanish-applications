package com.n26.controller;

import static com.n26.service.TransactionService.TIME_LIMIT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

import java.time.Instant;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.n26.pojo.Transaction;
import com.n26.service.TransactionService;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping(value = "/transactions")
    public ResponseEntity<Void> create(@Valid @NotNull @RequestBody Transaction transaction) {
    	if(transaction.getTimestamp().isAfter(Instant.now()))
    		return new ResponseEntity<>(UNPROCESSABLE_ENTITY);
        if (Instant.now().toEpochMilli() - transaction.getTimestamp().toEpochMilli() > TIME_LIMIT) {
            return new ResponseEntity<>(NO_CONTENT);
        } else {
            transactionService.create(transaction);
            return new ResponseEntity<>(CREATED);
        }
    }
    
    @DeleteMapping(value = "/transactions")
    public ResponseEntity<Void> removeAll() {
        transactionService.removeAll();
        return new ResponseEntity<>(NO_CONTENT);
        
    }

}