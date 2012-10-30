package business;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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

    public int createPerson(String lastName, String firstName, String email) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setMail(email);
        this.entityManager.persist(person);
        return 0;
    }

	public int createElectronicDevice(String name, String type, int power,
			long personId) {
		ElectronicDevice device = new ElectronicDevice();
		device.setName(name);
		device.setType(type);
		device.setPower(power);
		Person p = this.getPersonById(personId);
		if(p == null) return -1;
		device.setOwner(p);
        this.entityManager.persist(device);
        return 0;
	}

	public int createHeater(String name, String model, int power, long homeId) {
		Heater heater = new Heater();
		heater.setName(name);
		heater.setModel(model);
		heater.setPower(power);
		Home h = this.getHomeById(homeId);
		if(h == null) return -1;
		heater.setHome(h);
        this.entityManager.persist(heater);
        return 0;
	}

	public int createHome(String name, String address, String town,
			String zip, long personId) {
		Person owner = getPersonById(personId); 
		if(owner == null)
			return -1;
		Home home = new Home();
		home.setName(name);
		home.setAddress(address);
		home.setTown(town);
		home.setZip(zip);
		home.setOwner(owner);
        this.entityManager.persist(home);
        return 0;
	}

    
	public List<Person> getPersons() {
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
		Root<Person> person = criteriaQuery.from(Person.class);
		return this.entityManager.createQuery(criteriaQuery.select(person)).getResultList();
	}

	public Person getPersonById(long id) {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
        Root<Person> person = criteriaQuery.from(Person.class);
        criteriaQuery.select(person).where(criteriaBuilder.equal(person.get("id"), id));
        try {
            return this.entityManager.createQuery(criteriaQuery).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
	}
	
	public long getPersonIdByMailAddress(final String mail) {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
        Root<Person> person = criteriaQuery.from(Person.class);
        criteriaQuery.select(person).where(criteriaBuilder.equal(person.get("mail"), mail));
        try {
            return this.entityManager.createQuery(criteriaQuery).getSingleResult().getId();
        } catch (NoResultException nre) {
            return (Long) null;
        }
	}

	public int addFriendToUser(long idUser, long idFriend) {
		Person user = this.getPersonById(idUser);
		if (user == null) return -1;
		Person friend = this.getPersonById(idFriend);
		if (friend == null) return -2;
		user.addFriend(friend);
		return 0;
	}
	
	public Home getHomeById(long homeId){
		  CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
	        CriteriaQuery<Home> criteriaQuery = criteriaBuilder.createQuery(Home.class);
	        Root<Home> home = criteriaQuery.from(Home.class);
	        criteriaQuery.select(home).where(criteriaBuilder.equal(home.get("id"), homeId));
	        try {
	            return this.entityManager.createQuery(criteriaQuery).getSingleResult();
	        } catch (NoResultException nre) {
	            return null;
	        }
	}

	public int compareOverallConsummation(long person1Id, long person2Id) {

		int diffConsHeaters = compareHeatersConsummation(person1Id, person2Id);
		int diffConsDevices = compareElectronicDevicesConsummation(person1Id, person2Id);
		
		return diffConsHeaters + diffConsDevices;
		
	}

	public int compareHeatersConsummation(long person1Id, long person2Id) {
		
		int person1Cons = getHeatersCons(person1Id);
		int person2Cons = getHeatersCons(person2Id);
		
		return person2Cons - person1Cons ;
	}

	public int compareElectronicDevicesConsummation(long person1Id,
			long person2Id) {

		int person1Cons = getDevicesCons(person1Id);
		int person2Cons = getDevicesCons(person2Id);
		
		return person2Cons - person1Cons ;
	}

	private int getDevicesCons(long personId) {
		int personCons = 0;
		Person person = this.getPersonById(personId);
		List<ElectronicDevice> devices = person.getDevices();
		Iterator<ElectronicDevice> iter = devices.iterator();
		while(iter.hasNext()){
			ElectronicDevice device = iter.next();
			personCons += device.getPower();
		}
		return personCons;
	}
	
	private int getHeatersCons(long personId) {
		int heatersCons = 0;
		Person person = this.getPersonById(personId);
		List<Home> devices = person.getHomes();
		Iterator<Home> iterHome = devices.iterator();
		while(iterHome.hasNext()){
			Home home = iterHome.next();
			List<Heater> heaters = home.getHeaters();
			Iterator<Heater> iterHeater = heaters.iterator();
			while(iterHeater.hasNext()){
				Heater heater = iterHeater.next();
				heatersCons += heater.getPower();
			}
		}
		return heatersCons;
	}
}
