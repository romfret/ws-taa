package fr.istic.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("compareService")
public interface CompareService  extends RemoteService{
	//return the difference between the overall consummation of person1 
	//and the overall consummation of person2 
	public int compareOverallConsummation(String person1mail, String person2mail);

	//return the difference between the heaters consummation of person1 
	//and the heaters consummation of person2 
	public int compareHeatersConsummation(String person1mail, String person2mail);
	
	//return the difference between the electronic devices consummation of person1 
	//and the electronic devices consummation of person2 
	public int compareElectronicDevicesConsummation(String person1mail, String person2mail);
	
}
