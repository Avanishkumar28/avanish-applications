package com.n26.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.n26.persistance.TransactionDAO;
import com.n26.service.TransactionService;
import com.n26.service.StatisticsService;
import com.n26.pojo.Transaction;

@Service
public class TransactionServiceImpl implements  TransactionService{

    @Autowired
    private TransactionDAO transactionDAO;

    @Autowired
    private StatisticsService statisticsService;

    @Override
    public void create(Transaction transaction) {
        transactionDAO.save(transaction);
        statisticsService.addTransaction(transaction);
    }
    
    @Override 
    public void removeAll(){
    	transactionDAO.deleteAll();
    	statisticsService.removeAll();
    }

}