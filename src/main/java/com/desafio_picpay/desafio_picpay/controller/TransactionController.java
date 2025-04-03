package com.desafio_picpay.desafio_picpay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio_picpay.desafio_picpay.domain.dtos.TransactionDTO;
import com.desafio_picpay.desafio_picpay.domain.transaction.Transaction;
import com.desafio_picpay.desafio_picpay.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

   @PostMapping
   public ResponseEntity<Transaction> createTransaction (@RequestBody TransactionDTO transaction) throws Exception{
    Transaction newTransaction = this.transactionService.createTransaction(transaction);

    return new ResponseEntity<>(newTransaction, HttpStatus.OK);
   }


}
