package av.app.calcutator.main;

import java.util.List;

import av.app.calcutator.enums.FileType;
import av.app.calcutator.excel.ExcelFileWriter;
import av.app.calcutator.pojo.Transaction;
import av.app.calcutator.pojo.TransactionReport;
import av.app.calcutator.service.AppFileWriter;
import av.app.calcutator.service.TransactionReportService;
import av.app.calcutator.serviceImpl.TransactionReportServiceImpl;

public class FeeCalculator {

	public static void main(String[] args) {
		List<Transaction> transactions = FileType.XLSX.processFile();
		transactions.forEach(System.out::println);
		System.out.println("***********************************");
		TransactionReportService transactionReportService = new TransactionReportServiceImpl();
		List<TransactionReport> transactionReport =  transactionReportService.getTransactionReports(transactions);
		transactionReport.forEach(System.out :: println);
		
		AppFileWriter appFileWriter = new ExcelFileWriter();
		appFileWriter.createReportFile(transactionReport);
		System.out.println("Report Created!");

	}

}
