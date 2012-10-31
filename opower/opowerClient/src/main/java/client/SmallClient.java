package client;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JPanel;

import business.BusinessInterface;
import fr.istic.entity.Person;

public class SmallClient extends JPanel {
	public SmallClient() {
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -6099849382011875415L;
	/**
	 * Use Smart Factory by default.
	 */
	private static final String DEFAULT_INITIAL_CONTEXT_FACTORY = "org.ow2.easybeans.component.smartclient.spi.SmartContextFactory";

	/**
	 * @param args
	 * @throws NamingException
	 */
	public static void main(String[] args) throws NamingException {
		BusinessInterface serv = (BusinessInterface) getInitialContext().lookup("businessImpl");		
		serv.init();
		
		serv.createPerson("lastName", "firstName", "email");
		
		List<Person> persons = serv.getPersons();
		for (Person person : persons) {
			System.out.println(person.getFirstName());
		}
		SmallClientSwing ihm = new SmallClientSwing();
	}

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
