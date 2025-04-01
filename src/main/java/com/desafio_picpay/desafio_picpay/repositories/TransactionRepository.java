package com.desafio_picpay.desafio_picpay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio_picpay.desafio_picpay.domain.transaction.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
