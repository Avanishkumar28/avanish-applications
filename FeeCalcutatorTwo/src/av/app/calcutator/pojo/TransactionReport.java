package av.app.calcutator.pojo;

public class TransactionReport {

	private String clientId;
	private String transactionType;
	private String transactionDate;
	private String priorityFlag;
	private String processingFee;
	
	public TransactionReport(String clientId, String transactionType, String transactionDate, String priorityFlag,
			String processingFee) {
		this.clientId = clientId;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.priorityFlag = priorityFlag;
		this.processingFee = processingFee;
	}

	public String getClientId() {
		return clientId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public String getPriorityFlag() {
		return priorityFlag;
	}

	public String getProcessingFee() {
		return processingFee;
	}

	@Override
	public String toString() {
		return "TransactionReport [clientId=" + clientId + ", transactionType=" + transactionType + ", transactionDate="
				+ transactionDate + ", priorityFlag=" + priorityFlag + ", processingFee=" + processingFee + "]";
	}
	
	
	
}
