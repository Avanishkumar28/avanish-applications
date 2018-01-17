package av.app.calcutator.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import av.app.calcutator.constants.AppConstant;
import av.app.calcutator.pojo.Transaction;
import av.app.calcutator.pojo.TransactionReport;
import av.app.calcutator.service.TransactionReportService;

public class TransactionReportServiceImpl implements TransactionReportService {

	@Override
	public List<TransactionReport> getTransactionReports(List<Transaction> transactions) {
		List<TransactionReport> transactionReports = new ArrayList<>();
		for(Transaction transaction : transactions) {
			TransactionReport transactionReport = new TransactionReport(
														transaction.getClientId(), 
														transaction.getTransactionType(), 
														transaction.getTransactionDate(), 
														transaction.getPriorityFlag(), 
														getTransactionFee(transaction));
			transactionReports.add(transactionReport);
			
		}
		return transactionReports;
	}

	private String getTransactionFee(Transaction transaction) {
		if(transaction.isIntraDay()) {
			return "$10";
		}else if(isTransactionHighPriority(transaction)){
			return "$500";
		}else if(isTransactionSellAndWithdraw(transaction)){
			return "$100";
		}else if(isTransactionBuyAndDeposit(transaction)){
			return "$50";
		}else
			return "$0";
	}

	@Override
	public boolean isTransactionHighPriority(Transaction transaction) {
		
		return AppConstant.PRIORITY_YES.equals(transaction.getPriorityFlag());
	}

	@Override
	public boolean isTransactionBuyAndDeposit(Transaction transaction) {
		return AppConstant.BUY.equals(transaction.getTransactionType()) || AppConstant.DEPOSIT.equals(transaction.getTransactionType()) ;
	}

	@Override
	public boolean isTransactionSellAndWithdraw(Transaction transaction) {
		return AppConstant.SELL.equals(transaction.getTransactionType()) || AppConstant.WITHDRAW.equals(transaction.getTransactionType()) ;
	}

}
