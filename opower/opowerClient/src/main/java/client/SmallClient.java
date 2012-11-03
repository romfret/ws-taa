package client;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JPanel;

public class SmallClient extends JPanel {
	public SmallClient() {
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -6099849382011875415L;
	
	/**
	 * @param args
	 * @throws NamingException
	 */
	public static void main(String[] args) throws NamingException {
		SmallClientSwing ihm = new SmallClientSwing();
		ihm.setVisible(true);
	}

	
}
