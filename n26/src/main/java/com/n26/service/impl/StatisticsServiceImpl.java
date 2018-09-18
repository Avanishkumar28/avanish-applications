package com.n26.service.impl;

import java.util.concurrent.PriorityBlockingQueue;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.n26.pojo.Statistics;
import com.n26.pojo.Transaction;
import com.n26.service.StatisticsService;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private static final int QUEUE_INITIAL_CAPACITY = 1000;
    private static final int POLLING_INTERVAL_RATE_MS = 1;

    private final PriorityBlockingQueue<Transaction> transactionsQueue =
            new PriorityBlockingQueue<>(QUEUE_INITIAL_CAPACITY, (t1,t2)-> t1.getTimestamp().compareTo(t2.getTimestamp()));

    
    private Statistics statistics = new Statistics(transactionsQueue);

    @Scheduled(fixedRate = POLLING_INTERVAL_RATE_MS)
    private void discardOldEntries() {
        while (!transactionsQueue.isEmpty() && !transactionsQueue.peek().isNewerThanTimeLimit()) {
            transactionsQueue.poll();
        }
        updateStatistics();
    }

    @Override
    public void addTransaction(Transaction transaction) {
        transactionsQueue.add(transaction);
        updateStatistics();
    }

    private void updateStatistics() {
        statistics = new Statistics(transactionsQueue);
    }
    
    @Override
    public Statistics getStatistics(){
    	discardOldEntries();
        return statistics;
    }

	@Override
	public void removeAll() {
		transactionsQueue.clear();
	}

}