package business;

import java.util.List;

import javax.ejb.Remote;

import fr.istic.entity.Person;

@Remote
public interface BusinessInterface {
	/**
	 * Populates the database with a few data
	 */
	public void init();

    /**
     * Get all persons in the database.
     * @return list of persons
     */
    public List<Person> getPersons();

    /**
     * Get a person by its id.
     * @param number id of the person
     * @return the given person, else null
     */
    public Person getPersonById(final long id);
    
    /**
     * Get a person Id
     * @param the mail address of a person
     * @return the person id if the mail address exists, else null
     */
    public long getPersonIdByMailAddress(final String mail);
    
    /**
     * Create and add a person to the database by details given
     * @param lastName The last name
     * @param firstName The first name
     * @param email The mail address
     * @return  0 if successfully added
     */
    public int createPerson(String lastName, String firstName, String email);
    
    /**
     * Create and add an electronic device to the database by details given
     * @param name A chosen name
     * @param type The type of device
     * @param power The power in W/h
     * @param personId The Person ID who owned the device
     * @return  0 if successfully added
     */
    public int createElectronicDevice(String name, String type, int power, long personId );
    
    /**
     * Create and add a heater to the database by details given
     * @param name A chosen name
     * @param model The model of the heater
     * @param power The power in W/h
     * @param homeId The Home ID who owned the device
     * @return  0 if successfully added
     */
	public int createHeater(String name, String model, int power, long homeId);
	
	/**
	 * Create and add a home to the database by details given
	 * @param name A chosen name
	 * @param address The home address
	 * @param town The home town
	 * @param zip The zip corresponding to the town
	 * @param personId The Person ID who owned the home
     * @return  0 if successfully added
	 */
	public int createHome(String name, String address, String town, String zip, long personId);

	/**
	 * Add a friend to a given Person
	 * @param idUser The Person ID who owned a friend
	 * @param idFriend The Person ID who is the friend added
     * @return  0 if successfully added
	 */
	public int addFriendToUser(long idUser, long idFriend);

	/**
	 * 
	 * @param person1Id
	 * @param person2Id
	 * @return
	 */
	public int compareOverallConsummation(long person1Id, long person2Id);
	
	/**
	 * 
	 * @param person1Id
	 * @param person2Id
	 * @return
	 */
	public int compareHeatersConsummation(long person1Id, long person2Id);

	/**
	 * 
	 * @param person1Id
	 * @param person2Id
	 * @return
	 */
	public int compareElectronicDevicesConsummation(long person1Id, long person2Id);
}
