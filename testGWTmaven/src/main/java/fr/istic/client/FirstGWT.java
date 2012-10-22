package fr.istic.client;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;

import fr.istic.entity.Person;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class FirstGWT implements EntryPoint {
	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	private final CreateServiceAsync createService = GWT
			.create(CreateService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		// -------------- ADD USER PANEL -------------
		final Button addUserButton = new Button("Ajouter l'utilisateur");
		addUserButton.addStyleName("sendButton");

		Label firstNameAddUserLabel = new Label("Prénom :");
		final TextBox firstNameAddUserField = new TextBox();
		firstNameAddUserField.setText("");

		Label lastNameAddUserLabel = new Label("Nom :");
		final TextBox lastNameAddUserField = new TextBox();
		lastNameAddUserField.setText("");

		Label mailAddUserLabel = new Label("Email :");
		final TextBox mailAddUserField = new TextBox();
		mailAddUserField.setText("");

		AbsolutePanel addUserPanel = new AbsolutePanel();
		addUserPanel.add(firstNameAddUserLabel, 10, 20);
		addUserPanel.add(firstNameAddUserField, 70, 20);
		addUserPanel.add(lastNameAddUserLabel, 10, 50);
		addUserPanel.add(lastNameAddUserField, 70, 50);
		addUserPanel.add(mailAddUserLabel, 10, 80);
		addUserPanel.add(mailAddUserField, 70, 80);
		addUserPanel.add(addUserButton, 30, 120);
		// --------------------------------------------

		// -------------- ADD HOME PANEL -------------
		final Button addHomeButton = new Button("Ajouter le domicile");
		addHomeButton.addStyleName("sendButton");

		Label nameAddHomeLabel = new Label("Nom :");
		final TextBox nameAddHomeField = new TextBox();
		nameAddHomeField.setText("");

		Label addressAddHomeLabel = new Label("Addresse :");
		final TextBox addressAddHomeField = new TextBox();
		addressAddHomeField.setText("");

		Label zipAddHomeLabel = new Label("Code postal :");
		final TextBox zipAddHomeField = new TextBox();
		zipAddHomeField.setText("");

		Label townAddHomeLabel = new Label("Ville :");
		final TextBox townAddHomeField = new TextBox();
		townAddHomeField.setText("");

		AbsolutePanel addHomePanel = new AbsolutePanel();
		addHomePanel.add(nameAddHomeLabel, 10, 20);
		addHomePanel.add(nameAddHomeField, 70, 20);
		addHomePanel.add(addressAddHomeLabel, 10, 50);
		addHomePanel.add(addressAddHomeField, 70, 50);
		addHomePanel.add(zipAddHomeLabel, 10, 80);
		addHomePanel.add(zipAddHomeField, 70, 80);
		addHomePanel.add(townAddHomeLabel, 10, 110);
		addHomePanel.add(townAddHomeField, 70, 110);
		addHomePanel.add(addHomeButton, 30, 150);
		// --------------------------------------------

		// -------------- ADD ELECTRONIC DEVICE PANEL -------------
		final Button addElectronicDeviceButton = new Button(
				"Ajouter l'appareil electronique");
		addElectronicDeviceButton.addStyleName("sendButton");

		Label nameAddElectronicDeviceLabel = new Label("Nom :");
		final TextBox nameAddElectronicDeviceField = new TextBox();
		nameAddElectronicDeviceField.setText("");

		Label typeAddElectronicDeviceLabel = new Label("Type :");
		final TextBox typeAddElectronicDeviceField = new TextBox();
		typeAddElectronicDeviceField.setText("");

		Label powerAddElectronicDeviceLabel = new Label("Power :");
		final TextBox powerAddElectronicDeviceField = new TextBox();
		powerAddElectronicDeviceField.setText("");

		AbsolutePanel addElectronicDevicePanel = new AbsolutePanel();
		addElectronicDevicePanel.add(nameAddElectronicDeviceLabel, 10, 20);
		addElectronicDevicePanel.add(nameAddElectronicDeviceField, 70, 20);
		addElectronicDevicePanel.add(typeAddElectronicDeviceLabel, 10, 50);
		addElectronicDevicePanel.add(typeAddElectronicDeviceField, 70, 50);
		addElectronicDevicePanel.add(powerAddElectronicDeviceLabel, 10, 80);
		addElectronicDevicePanel.add(powerAddElectronicDeviceField, 70, 80);
		addElectronicDevicePanel.add(addElectronicDeviceButton, 30, 110);
		// --------------------------------------------

		// -------------- ADD HEATER PANEL -------------
		final Button addHeaterButton = new Button("Ajouter le chauffage");
		addHeaterButton.addStyleName("sendButton");

		Label nameAddHeaterLabel = new Label("Nom :");
		final TextBox nameAddHeaterField = new TextBox();
		nameAddHeaterField.setText("");

		Label modelAddHeaterLabel = new Label("Model :");
		final TextBox modelAddHeaterField = new TextBox();
		modelAddHeaterField.setText("");

		Label powerAddHeaterLabel = new Label("Power :");
		final TextBox powerAddHeaterField = new TextBox();
		powerAddHeaterField.setText("");

		AbsolutePanel addHeaterPanel = new AbsolutePanel();
		addHeaterPanel.add(nameAddHeaterLabel, 10, 20);
		addHeaterPanel.add(nameAddHeaterField, 70, 20);
		addHeaterPanel.add(modelAddHeaterLabel, 10, 50);
		addHeaterPanel.add(modelAddHeaterField, 70, 50);
		addHeaterPanel.add(powerAddHeaterLabel, 10, 80);
		addHeaterPanel.add(powerAddHeaterField, 70, 80);
		addHeaterPanel.add(addHeaterButton, 30, 110);
		// --------------------------------------------

		// ------------ USER TAB PANEL --------------
		TabLayoutPanel userTabPanel = new TabLayoutPanel(1, Unit.EM);
		userTabPanel.setAnimationDuration(1000);
		userTabPanel.setWidth("300px");
		userTabPanel.setHeight("300px");

		// userTabPanel.add(null, "Show");
		userTabPanel.add(addUserPanel, "Add");
		// userTabPanel.add(null, "Delete");
		// ------------------------------------------

		// ------------ HOME TAB PANEL --------------
		TabLayoutPanel homeTabPanel = new TabLayoutPanel(1, Unit.EM);
		homeTabPanel.setAnimationDuration(1000);
		homeTabPanel.setWidth("300px");
		homeTabPanel.setHeight("300px");

		// homeTabPanel.add(null, "Show");
		homeTabPanel.add(addHomePanel, "Add");
		// homeTabPanel.add(null, "Delete");
		// ------------------------------------------

		// ------------ ELECTRONIC DEVICE TAB PANEL --------------
		TabLayoutPanel electronicDeviceTabPanel = new TabLayoutPanel(1, Unit.EM);
		electronicDeviceTabPanel.setAnimationDuration(1000);
		electronicDeviceTabPanel.setWidth("300px");
		electronicDeviceTabPanel.setHeight("300px");

		// homeTabPanel.add(null, "Show");
		electronicDeviceTabPanel.add(addElectronicDevicePanel, "Add");
		// homeTabPanel.add(null, "Delete");
		// ------------------------------------------

		// ------------ HEATER TAB PANEL --------------
		TabLayoutPanel heaterTabPanel = new TabLayoutPanel(1, Unit.EM);
		heaterTabPanel.setAnimationDuration(1000);
		heaterTabPanel.setWidth("300px");
		heaterTabPanel.setHeight("300px");

		// homeTabPanel.add(null, "Show");
		heaterTabPanel.add(addHeaterPanel, "Add");
		// homeTabPanel.add(null, "Delete");
		// ------------------------------------------

		// ------------ MAIN TAB PANEL --------------
		TabLayoutPanel mainTabPanel = new TabLayoutPanel(2.5, Unit.EM);

		mainTabPanel.add(userTabPanel, "User");
		mainTabPanel.add(homeTabPanel, "Home");
		mainTabPanel.add(electronicDeviceTabPanel, "Electronic Device");
		mainTabPanel.add(heaterTabPanel, "Heater");

		mainTabPanel.setAnimationDuration(1000);
		mainTabPanel.addStyleName("tabPanelExample1");
		mainTabPanel.setWidth("1000px");
		mainTabPanel.setHeight("700px");

		RootPanel rootPanel = RootPanel.get();
		rootPanel.add(mainTabPanel);

		addUserButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				createService.addUser(firstNameAddUserField.getText(),
						lastNameAddUserField.getText(),
						mailAddUserField.getText(), new AsyncCallback<Void>() {

							public void onSuccess(Void arg0) {
								Window.alert("succes");
							}

							public void onFailure(Throwable arg0) {
								Window.alert("fail");

							}
						});
			}
		});

		// TEST DE getPerson() avec le boutton addHome
		addHomeButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {

				/*
				 * 
				 * 
				 * http://www.developpez.net/forums/d95178/java/general-java/
				 * persistance
				 * /hibernate/hibernate-3-0-lazyinitializationexception/
				 * 
				 * salut
				 * 
				 * - Pourquoi?? Est ce que cela vient du fait que la session
				 * dans laquelle je travaille n'est pas la même que celle qui à
				 * loadé initialement le "MemberDAO"??
				 * 
				 * --> en fait l'objet que tu passes en paramètre n'est plus en
				 * état persistant, et lorsque tu appel une collection mappé
				 * avec une initialisation à "lazy=true" sur un objet détaché,
				 * ca génère une LazyInitializationException.
				 * 
				 * - Pourquoi dois je rattacher l'objet "accessDAO" et non pas
				 * le "membreDAO" directement?? En effet, l'instruction suivante
				 * ne fonctionne pas
				 * 
				 * --> la méthode "session.lock(memberDAO, LockMode.NONE); " ne
				 * rattache pas les associations à la session sauf si c'est
				 * indiqué spécifiquement dans l'association par la propriété
				 * " cascade='lock' ".
				 * 
				 * En gros la propriété access n'est pas persisté et la méthode
				 * getAccess() retourne simplement la liste que contenait
				 * membreDAO (ie surement une liste vide). Comme ta requete
				 * indique une contrainte IN sur une liste qui ne contient rien,
				 * ca te retourne une liste vide.
				 */
				// createService.getPersons(new AsyncCallback<List<Person>>() {
				//
				// public void onFailure(Throwable caught) {
				// Window.alert("Gros fail du test\n" + caught.toString());
				// }
				//
				// public void onSuccess(List<Person> persons) {
				//
				// String textRes = "";
				// for (Person person : persons) {
				// textRes += "- " + person.getFirstName() + "\n";
				// }
				// Window.alert(textRes);
				// }
				//
				// });

				
				// It works !!
				createService.getAllOfPerson(new AsyncCallback<String>() {

					public void onFailure(Throwable caught) {
						Window.alert(caught.toString());

					}

					public void onSuccess(String result) {
						Window.alert(result);
					}

				});
			}
		});

	}
}
