package av.app.calcutator.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import av.app.calcutator.constants.AppConstant;
import av.app.calcutator.pojo.Transaction;

public class ExcelFileReader {

	public List<Transaction> readFile() {
		
		List<Transaction> transactions = null;
		try(FileInputStream fileInputStream = new FileInputStream(new File(AppConstant.INPUT_FILE));
				Workbook workbook = new XSSFWorkbook(fileInputStream);) {
			Sheet sheet = workbook.getSheetAt(0);
			transactions = new ArrayList<>();
			for(Row row : sheet) {
				if(row.getRowNum()==0)
					continue;
				Transaction transaction = getTransactionDetaile(row);
				
				transactions.add(transaction);
			}
			updateIntraDayTransactions(transactions);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return transactions;
	}

	private void updateIntraDayTransactions(List<Transaction> transactions) {
		transactions.stream()
					.filter(outTran -> ExcelFileReader.intradayFilter(transactions, outTran))
					.map(outTran -> ExcelFileReader.updateToIntraday(outTran))
					.forEach(intradayTran -> {/*Nothing to do here*/});
		
	}
	
	private static boolean intradayFilter(List<Transaction> transactions, Transaction outTran) {
		return transactions.stream()
				.anyMatch(innTran -> ExcelFileReader.isIntraday(outTran, innTran));
	}
	
	private static boolean isIntraday(Transaction outTran, Transaction innTran) {
		
		return outTran.getClientId().equals(innTran.getClientId())
				&& outTran.getSecurityId().equals(innTran.getSecurityId())
				&& outTran.getTransactionDate().equals(innTran.getTransactionDate())
				&& !outTran.getTransactionType().equals(innTran.getTransactionType())
				&& (AppConstant.BUY.equals(outTran.getTransactionType())
						|| AppConstant.SELL.equals(outTran.getTransactionType()));
	}
	
	private static Transaction updateToIntraday(Transaction transaction) {
		transaction.setIntraDay(true);
		return transaction;
	}

	private Transaction getTransactionDetaile(Row row) {
		Transaction transaction = new Transaction()
									.setTransactionId(row.getCell(0).toString())
									.setClientId(row.getCell(1).toString())
									.setSecurityId(row.getCell(2).toString())
									.setTransactionType(row.getCell(3).toString())
									.setTransactionDate(row.getCell(4).toString())
									.setMarketValue(Double.parseDouble(row.getCell(5).toString()))
									.setPriorityFlag(row.getCell(6).toString());
		return transaction;
	}
	
	/*private void updateIntraDayTransactions(Map<String, List<Transaction>> transactionMap, Transaction transaction) {
		String key = transaction.getClientId()+"_"+transaction.getSecurityId()+"_"+transaction.getTransactionDate();
		List<Transaction>  oldTransaction = null;
		if(transactionMap.get(key) != null) {
			 oldTransaction = transactionMap.get(key);
			if(!oldTransaction.getTransactionType().equals(transaction.getTransactionType()) 
					&& (AppConstant.BUY.equals(transaction.getTransactionType()) 
							|| AppConstant.SELL.equals(transaction.getTransactionType()
						)) 
					){
				transaction.setIntraDay(true);
				oldTransaction.setIntraDay(true);
				transaction = oldTransaction;
			}
		}
		List<Transaction> tList = new ArrayList<>();
		if(oldTransaction != null && !oldTransaction.isEmpty())
			tList.addAll(oldTransaction);
		tList.add(transaction);
		
		transactionMap.put(key, tList);
	}*/

}
