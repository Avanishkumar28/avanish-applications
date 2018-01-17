package av.app.calcutator.service;

import java.util.List;

import av.app.calcutator.pojo.Transaction;
import av.app.calcutator.pojo.TransactionReport;

public interface TransactionReportService {

	List<TransactionReport> getTransactionReports(List<Transaction> transactions);
	
	public boolean isTransactionHighPriority(Transaction transaction);
	
	public boolean isTransactionBuyAndDeposit(Transaction transaction);
	
	public boolean isTransactionSellAndWithdraw(Transaction transaction);

}
