package transaction;
import java.util.ArrayList;
import java.util.HashMap;

import summary.RTSorter;
import summary.ReportTransaction;

public class Processor {
	private static HashMap<String, ReportTransaction> runningReports = new HashMap<String, ReportTransaction>();
	public static ArrayList<ReportTransaction> processTransactions(ArrayList<Transaction> transactions){
		ArrayList<ReportTransaction> summary = new ArrayList<ReportTransaction>();
		for(Transaction transaction:transactions) {
			ReportTransaction report = new ReportTransaction(transaction.getClientID(),transaction.getType(),transaction.getDate(),transaction.getFlag());
			calculateFee(report);
			checkForIntraDay(report);
			summary.add(report);
		}
		summary.sort(new RTSorter());
		return summary;
	}
	
	public static void calculateFee(ReportTransaction report) {
		priority priorityFlag = report.getFlag();
		switch(priorityFlag) {
			case Y:
				report.addFee(500);
				break;
			case N:
			{
				type transactionType = report.getType();
				switch(transactionType) {
					case SELL:
					case WITHDRAW:
						report.addFee(100);
						break;
					case BUY:
					case DEPOSIT:
						report.addFee(50);
					default:
						break;
				}
				break;
					
			}
			default:
				break;
			
		}
	}
	
	public static void checkForIntraDay(ReportTransaction report) {
		if(runningReports.containsKey(report.toKeyString())) {
		    ReportTransaction oldTransaction = runningReports.get(report.toKeyString());
		    oldTransaction.addFee(10);
		    report.addFee(10);
		    runningReports.remove(report.toKeyString());
		}
		else {
			runningReports.put(report.toKeyString(),report);
		}
	}
}