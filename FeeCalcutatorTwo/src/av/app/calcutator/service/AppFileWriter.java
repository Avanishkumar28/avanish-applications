package av.app.calcutator.service;

import java.util.List;

import av.app.calcutator.pojo.TransactionReport;

public interface AppFileWriter {

	public void createReportFile(List<TransactionReport> transactionReports);
}
