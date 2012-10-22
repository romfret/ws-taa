package fr.istic.client;

import java.util.List;

import business.BusinessInterface;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fr.istic.entity.Person;

@RemoteServiceRelativePath("createService")
public interface CreateService extends RemoteService{
	public void addUser(String firstName, String lastName, String email);
	public void addElectronicDevice(String name, String type, int power, long personId );
	public void addHeater(String name, String model, int power, long homeId);
	public void addHome(String name, String address, String town, String zip, long personId);
	
	public List<Person> getPersons();
	public String getAllOfPerson();
}
