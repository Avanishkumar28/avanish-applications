package av.app.calcutator.pojo;

public class Transaction {
	
	private String transactionId;
	private String clientId;
	private String securityId;
	private String transactionType;
	private String transactionDate;
	private double marketValue;
	private String priorityFlag;
	
	private boolean isIntraDay;
	
	
	public String getTransactionId() {
		return transactionId;
	}
	public Transaction setTransactionId(String transactionId) {
		this.transactionId = transactionId;
		return this;
	}
	public String getClientId() {
		return clientId;
	}
	public Transaction setClientId(String clientId) {
		this.clientId = clientId;
		return this;
	}
	public String getSecurityId() {
		return securityId;
	}
	public Transaction setSecurityId(String securityId) {
		this.securityId = securityId;
		return this;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public Transaction setTransactionType(String transactionType) {
		this.transactionType = transactionType;
		return this;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public Transaction setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
		return this;
	}
	public double getMarketValue() {
		return marketValue;
	}
	public Transaction setMarketValue(double marketValue) {
		this.marketValue = marketValue;
		return this;
	}
	public String getPriorityFlag() {
		return priorityFlag;
	}
	public Transaction setPriorityFlag(String priorityFlag) {
		this.priorityFlag = priorityFlag;
		return this;
	}
	public boolean isIntraDay() {
		return isIntraDay;
	}
	public void setIntraDay(boolean isIntraDay) {
		this.isIntraDay = isIntraDay;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
		result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (transactionId == null) {
			if (other.transactionId != null)
				return false;
		} else if (!transactionId.equals(other.transactionId))
			return false;
		if (transactionType == null) {
			if (other.transactionType != null)
				return false;
		} else if (!transactionType.equals(other.transactionType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", clientId=" + clientId + ", securityId=" + securityId
				+ ", transactionType=" + transactionType + ", transactionDate=" + transactionDate + ", marketValue="
				+ marketValue + ", priorityFlag=" + priorityFlag + ", isIntraDay=" + isIntraDay + "]";
	}
	
	
}
