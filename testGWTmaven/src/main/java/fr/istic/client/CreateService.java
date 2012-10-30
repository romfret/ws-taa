package fr.istic.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fr.istic.entity.Person;

@RemoteServiceRelativePath("createService")
public interface CreateService extends RemoteService{
	public int addUser(String firstName, String lastName, String email);
	public int addElectronicDevice(String name, String type, int power, long personId );
	public int addHeater(String name, String model, int power, long homeId);
	public int addHome(String name, String address, String town, String zip, long personId);
	
	public List<Person> getPersons();
	public String getAllOfPerson();
	
	public long getPersonIdWithMailAddress(String mail);
	
	public void addFriendToUser(long idUser, long idFriend);
	
}
