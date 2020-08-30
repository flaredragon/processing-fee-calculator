package summary;

import java.time.LocalDate;

import transaction.priority;
import transaction.type;

public class ReportTransaction {
	private String clientID;
	private type transactionType;
	private LocalDate date;
	private Double processingFee;
	private priority flag;
	
	public ReportTransaction(String newClientID,type newTransactionType,LocalDate newDate,priority newFlag) {
		this.clientID = newClientID;
		this.transactionType = newTransactionType;
		this.date = newDate;
		this.processingFee = (double) 0;
		this.flag = newFlag;
	}
	@Override 
	public String toString(){
		return this.clientID + " " + this.transactionType.toString() + " " + this.date.toString() + " " + this.processingFee.toString() + " " + this.flag;
	}

	public String toKeyString(){
		return this.clientID+this.date.toString();
	}

	public void addFee(double fee) {
		this.processingFee += fee;
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
	
	public Double getFee() {
		return this.processingFee;
	}
}
