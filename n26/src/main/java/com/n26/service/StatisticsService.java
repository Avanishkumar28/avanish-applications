package com.n26.service;

import com.n26.pojo.Transaction;
import com.n26.pojo.Statistics;

public interface StatisticsService {

	public void addTransaction(Transaction transaction);
	public Statistics getStatistics();
	public void removeAll();

}