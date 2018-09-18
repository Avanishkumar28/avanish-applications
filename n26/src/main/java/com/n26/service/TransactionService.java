package com.n26.service;

import com.n26.pojo.Transaction;

public interface TransactionService {
    
    public static final int TIME_LIMIT = 60000;

	public void create(Transaction transaction);

	public void removeAll();

}