package business;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import business.BusinessInterface;
import fr.istic.entity.ElectronicDevice;
import fr.istic.entity.Heater;
import fr.istic.entity.Home;
import fr.istic.entity.Person;


/**
 * Stateless session bean that is using JPA 2.0.
 */
@Stateless(mappedName = "businessImpl")
public class BusinessImplementation implements BusinessInterface  {

	 /**
     * Entity manager used by this session bean.
     */
    @PersistenceContext
    private EntityManager entityManager;
    
    public void init() {
    	// Do nothing if already defined
        /*
         * Person test = findPersonWithItsGivenName("Florent");
        if (test != null) {
            return;
        }
        */
        // The first employee
        Person florent = new Person();
        florent.setFirstName("Florent");
        florent.setLastName("Dupond");
        florent.setMail("florent@mail.com");
        
        ElectronicDevice fDevice = new ElectronicDevice();
        fDevice.setName("Television1");
        fDevice.setOwner(florent);
        fDevice.setPower(200);
        fDevice.setType("television");
        
        florent.addDevice(fDevice);
        
        Home fHome = new Home();
        fHome.setAddress("rue de paris");
        fHome.setName("home1");
        fHome.setOwner(florent);
        fHome.setTown("Rennes");
        fHome.setZip("35000");
        florent.addHome(fHome);
        
        Heater fHeater = new Heater();
        fHeater.setHome(fHome);
        fHeater.setModel("convector");
        fHeater.setName("MonRadiateur");
        fHeater.setPower(1500);
        
        fHome.addHeater(fHeater);
        
        Person alain = new Person();
        alain.setFirstName("Alain");
        alain.setLastName("De Loin");
        alain.setMail("alain.de.loin.dtc@hadopi.fr");
        florent.addFriend(alain);
        
        this.entityManager.persist(fDevice);
        this.entityManager.persist(fHeater);
        this.entityManager.persist(fHome);
        this.entityManager.persist(alain);
        this.entityManager.persist(florent);
    }

    public void createPerson(String lastName, String firstName, String email) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setMail(email);
        this.entityManager.persist(person);
    }

	public void createElectronicDevice(String name, String type, int power,
			long personId) {
		ElectronicDevice device = new ElectronicDevice();
		device.setName(name);
		device.setType(type);
		device.setPower(power);
		Person owner = new Person();
		device.setOwner(owner);
        this.entityManager.persist(device);
	}

	public void createHeater(String name, String model, int power, long homeId) {
		Heater heater = new Heater();
		heater.setName(name);
		heater.setModel(model);
		heater.setPower(power);
		Home home = new Home();
		heater.setHome(home);
        this.entityManager.persist(heater);
	}

	public void createHome(String name, String address, String town,
			String zip, long personId) {
		Home home = new Home();
		home.setName(name);
		home.setAddress(address);
		home.setTown(town);
		home.setZip(zip);
		Person owner = new Person();
		home.setOwner(owner);
        this.entityManager.persist(home);
	}

    
	public List<Person> findPersons() {
		// TODO Auto-generated method stub
		return null;
	}

	public Person findPersonWithItsGivenName(String name) {
		return null;
	}
	
}
