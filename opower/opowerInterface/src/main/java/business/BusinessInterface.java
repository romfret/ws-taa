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
	
	public String createPerson(String lastName, String firstName, String email);

    /**
     * Find all persons.
     * @return list of persons
     */
    public List<Person> getPersons();

    /**
     * Allows to find an person by its id.
     * @param number id of the person
     * @return the given person, else null
     */
    public Person findPersonWithHisID(final long id);

    /**
     * Retrouve l'id d'une personne grace a son adresse mail
     */
    public String findPersonIdWithMailAddress(final String mail);
    
    public void createElectronicDevice(String name, String type, int power, long personId );
	public void createHeater(String name, String model, int power, long homeId);
	public String createHome(String name, String address, String town, String zip, long personId);
	
}
