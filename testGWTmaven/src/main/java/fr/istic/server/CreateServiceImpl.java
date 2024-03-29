package fr.istic.server;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import business.BusinessInterface;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fr.istic.client.CreateService;
import fr.istic.entity.Person;

public class CreateServiceImpl extends RemoteServiceServlet implements
		CreateService {

	private static final long serialVersionUID = 1L;

	private BusinessInterface serv;

	public void init() {
		if (serv == null) {
			try {
				serv = (BusinessInterface) getInitialContext().lookup(
						"businessImpl");
			} catch (NamingException e) {
				e.printStackTrace();
			}
			// serv.init();
		}
	}

	public int addUser(String firstName, String lastName, String email) {
		init();
		return serv.createPerson(lastName, firstName, email);
	}

	public int addElectronicDevice(String name, String type, int power,
			long personId) {
		init();
		return serv.createElectronicDevice(name, type, power, personId);
	}

	public int addHeater(String name, String model, int power, long homeId) {
		init();
		return serv.createHeater(name, model, power, homeId);
	}

	public int addHome(String name, String address, String town, String zip,
			long personId) {
		init();
		return serv.createHome(name, address, town, zip, personId);
	}
	
	public List<Person> getPersons() {
		init();
		List<Person> persons = serv.getPersons();
		for (Person person : persons) {
			System.out.println(person.getFirstName());
		}
		return persons;
	}
	
	
	/***
	 * Retourne un affichage de la table person
	 */
	public String getAllOfPerson() {
		init();
		List<Person> persons = serv.getPersons();
		String res = "";
		for (Person person : persons) {
			res += person.toString() + "\n";
		}
		
		return res;
	}
	
	/**
	 * Retrouve l'id d'une personne grace a son adresse mail
	 */
	public long getPersonIdWithMailAddress(String mail) {
		init();
		return serv.getPersonIdByMailAddress(mail);
	}

	public void addFriendToUser(long idUser, long idFriend) {
		init();
		serv.addFriendToUser(idUser, idFriend);
	}
	
	/**
	 * Use Smart Factory by default.
	 */
	private static final String DEFAULT_INITIAL_CONTEXT_FACTORY = "org.ow2.easybeans.component.smartclient.spi.SmartContextFactory";

	/**
	 * @return Returns the InitialContext.
	 * @throws NamingException
	 *             If the Context cannot be created.
	 */
	private static Context getInitialContext() throws NamingException {
		// if user don't use jclient/client container
		// we can specify the InitialContextFactory to use
		// But this is *not recommended*.
		Hashtable<String, Object> env = new Hashtable<String, Object>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, getInitialContextFactory());
		// Usually a simple new InitialContext() without any parameters is
		// sufficent.
		// return new InitialContext();
		return new InitialContext(env);
	}

	/**
	 * Returns a configurable InitialContextFactory classname.<br/>
	 * Can be configured with the
	 * <code>easybeans.client.initial-context-factory</code> System property.
	 * 
	 * @return Returns a configurable InitialContextFactory classname.
	 */
	private static String getInitialContextFactory() {
		String prop = System
				.getProperty("easybeans.client.initial-context-factory");
		// If not found, use the default
		if (prop == null) {
			prop = DEFAULT_INITIAL_CONTEXT_FACTORY;
		}
		return prop;
	}


}
