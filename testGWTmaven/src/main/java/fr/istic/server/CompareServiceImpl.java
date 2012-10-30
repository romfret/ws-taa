package fr.istic.server;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import business.BusinessInterface;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fr.istic.client.CompareService;

public class CompareServiceImpl extends RemoteServiceServlet implements
CompareService {

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
	public int compareOverallConsummation(String person1mail, String person2mail) {
		long person1Id = serv.getPersonIdByMailAddress(person1mail);
		long person2Id = serv.getPersonIdByMailAddress(person2mail);
		return serv.compareOverallConsummation(person1Id, person2Id);
	}

	public int compareHeatersConsummation(String person1mail, String person2mail) {
		long person1Id = serv.getPersonIdByMailAddress(person1mail);
		long person2Id = serv.getPersonIdByMailAddress(person2mail);
		return serv.compareHeatersConsummation(person1Id, person2Id);
	}

	public int compareElectronicDevicesConsummation(String person1mail, String person2mail) {
		long person1Id = serv.getPersonIdByMailAddress(person1mail);
		long person2Id = serv.getPersonIdByMailAddress(person2mail);
		return serv.compareElectronicDevicesConsummation(person1Id, person2Id);
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
