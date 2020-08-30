package summary;

import java.util.Comparator;

public class RTSorter implements Comparator<ReportTransaction> {
	public int compare(ReportTransaction o1, ReportTransaction o2) {
        if(!o1.getClientID().equals(o2.getClientID()))
        	return o2.getClientID().compareTo(o1.getClientID());
        else if(!o1.getType().toString().equals(o2.getType().toString())) {
        	return o1.getType().toString().compareTo(o2.getType().toString());
        }
        else if(!o1.getDate().toString().equals(o2.getDate().toString())) {
        	return o1.getDate().toString().compareTo(o2.getDate().toString());
        }
        else if(!o1.getFlag().toString().equals(o2.getFlag().toString())) {
        	return o1.getFlag().toString().compareTo(o2.getFlag().toString());
        }
        else {
        	return 0;
        }
    }
}
