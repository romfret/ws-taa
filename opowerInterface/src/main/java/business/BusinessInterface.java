package business;

import java.util.List;

import javax.ejb.Remote;

import entity.Person;

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
    public List<Person> findPersons();

    /**
     * Allows to find an person by its name.
     * @param name the given name
     * @return the given person, else null
     */
    public Person findPersonWithItsGivenName(final String name);

    public String helloWorld();
	
}
