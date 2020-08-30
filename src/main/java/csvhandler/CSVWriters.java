package csvhandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

import summary.ReportTransaction;

public class CSVWriters {
	public static void writeToFile(ArrayList<ReportTransaction> summary) {
		File file = new File("Output.csv"); 
	    try { 
	        FileWriter outputfile = new FileWriter(file); 
	        CSVWriter writer = new CSVWriter(outputfile); 
	        String[] header = { "Client ID ", "Transaction Type", "Transaction Date", "Priority","Processing Fees" }; 
	        writer.writeNext(header); 
	        List<String[]> data = new ArrayList<String[]>(); 
	        for(ReportTransaction report:summary) {
	        	data.add(new String[] { report.getClientID(), report.getType().toString(), report.getDate().toString(),report.getFlag().toString(),report.getFee().toString() });
	        }
	        writer.writeAll(data);
	        writer.close();
	    } 
	    catch (IOException e) { 
	        // TODO Auto-generated catch block 
	        e.printStackTrace(); 
	    } 
	}
}
