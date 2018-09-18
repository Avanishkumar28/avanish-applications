package com.n26.persistance;

import org.springframework.data.repository.CrudRepository;

import com.n26.pojo.Transaction;

@org.springframework.transaction.annotation.Transactional
public interface TransactionDAO extends CrudRepository<Transaction, Long> {

}