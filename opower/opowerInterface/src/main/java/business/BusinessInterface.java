package business;

import java.util.List;

import javax.ejb.Remote;

import fr.istic.entity.Person;

@Remote
public interface BusinessInterface {

	 /**
     * Initialize the Database with new entities.
     */
	public void init();
	
	public void createPerson(String lastName, String firstName, String email);

    /**
     * Find all persons.
     * @return list of persons
     */
    public List<Person> getPersons();

    /**
     * Allows to find an person by its name.
     * @param name the given name
     * @return the given person, else null
     */
    public Person findPersonWithItsGivenName(final String name);

    
    public void createElectronicDevice(String name, String type, int power, long personId );
	public void createHeater(String name, String model, int power, long homeId);
	public void createHome(String name, String address, String town, String zip, long personId);
	
}
