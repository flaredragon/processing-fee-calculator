package transaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
	private String extID;
	private String clientID;
	private String securityID;
	private type transactionType;
	private LocalDate date;
	private Double value;
	private priority flag;
	
	public Transaction(String newExtID,String newClientID,String newSecurityID,
			String newTransactionType,String newDate,String newValue,String newFlag) {
		this.extID = newExtID;
		this.clientID = newClientID;
		this.securityID = newSecurityID;
		this.transactionType = Enum.valueOf(type.class, newTransactionType);
		this.date = LocalDate.parse(newDate,
	            DateTimeFormatter.ofPattern("LL/dd/yyyy"));
		this.value = Double.parseDouble(newValue);
		this.flag = Enum.valueOf(priority.class, newFlag);
	}
	
	public String getClientID() {
		return this.clientID;
	}
	
	public type getType() {
		return this.transactionType;
	}
	
	public LocalDate getDate() {
		return this.date;
	}
	
	public priority getFlag() {
		return this.flag;
	}
	
	
	
}
