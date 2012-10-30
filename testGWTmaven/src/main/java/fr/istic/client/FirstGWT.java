package fr.istic.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class FirstGWT implements EntryPoint {
	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final CompareServiceAsync compareService = GWT
			.create(CompareService.class);
	private final CreateServiceAsync createService = GWT
			.create(CreateService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		AbsolutePanel addUserPanel = getAddUserPanel();
		AbsolutePanel addFriendToUserPanel = getAddFriendToUserPanel();
		AbsolutePanel compareOverallConsPanel = getCompareOverallConsPanel();
		AbsolutePanel addHomePanel = getAddHomePanel();
		AbsolutePanel addElectronicDevicePanel = getAddElectronicDevicePanel();
		AbsolutePanel addHeaterPanel = getAddHeaterPanel();
		AbsolutePanel getUserIdPanel = getGetUserIdPanel();	
		
		// ------------ USER TAB PANEL --------------
		TabLayoutPanel userTabPanel = new TabLayoutPanel(2, Unit.EM);
		userTabPanel.setAnimationDuration(1000);
		userTabPanel.setWidth("1300px");
		userTabPanel.setHeight("1300px");

		// userTabPanel.add(null, "Show");
		userTabPanel.add(addUserPanel, "Add");
		userTabPanel.add(addFriendToUserPanel, "Add Friend To User");
		userTabPanel.add(addFriendToUserPanel, "Add Friend To User");
		

		// ---------- USER ID TAB PANEL -------------
		TabLayoutPanel userIdTabPanel = new TabLayoutPanel(2, Unit.EM);
		userIdTabPanel.setAnimationDuration(1000);
		userIdTabPanel.setWidth("1300px");
		userIdTabPanel.setHeight("1300px");

		userIdTabPanel.add(getUserIdPanel, "Add");

		
		
		// ------------ HOME TAB PANEL --------------
		TabLayoutPanel homeTabPanel = new TabLayoutPanel(2, Unit.EM);
		homeTabPanel.setAnimationDuration(1000);
		homeTabPanel.setWidth("1300px");
		homeTabPanel.setHeight("1300px");

		// homeTabPanel.add(null, "Show");
		homeTabPanel.add(addHomePanel, "Add");
		// homeTabPanel.add(null, "Delete");

		

		// ------------ ELECTRONIC DEVICE TAB PANEL --------------
		TabLayoutPanel electronicDeviceTabPanel = new TabLayoutPanel(2, Unit.EM);
		electronicDeviceTabPanel.setAnimationDuration(1000);
		electronicDeviceTabPanel.setWidth("1300px");
		electronicDeviceTabPanel.setHeight("1300px");

		// homeTabPanel.add(null, "Show");
		electronicDeviceTabPanel.add(addElectronicDevicePanel, "Add");
		// homeTabPanel.add(null, "Delete");

		
		

		// ------------ HEATER TAB PANEL --------------
		TabLayoutPanel heaterTabPanel = new TabLayoutPanel(2, Unit.EM);
		heaterTabPanel.setAnimationDuration(1000);
		heaterTabPanel.setWidth("1300px");
		heaterTabPanel.setHeight("1300px");

		// homeTabPanel.add(null, "Show");
		heaterTabPanel.add(addHeaterPanel, "Add");
		// homeTabPanel.add(null, "Delete");

		
		

		// ------------ MAIN TAB PANEL --------------
		TabLayoutPanel mainTabPanel = new TabLayoutPanel(2.5, Unit.EM);

		mainTabPanel.add(userTabPanel, "User");
		mainTabPanel.add(homeTabPanel, "Home");
		mainTabPanel.add(electronicDeviceTabPanel, "Electronic Device");
		mainTabPanel.add(heaterTabPanel, "Heater");
		mainTabPanel.add(getUserIdPanel, "Retrieve ID");

		mainTabPanel.setAnimationDuration(1000);
		mainTabPanel.addStyleName("tabPanelExample1");
		mainTabPanel.setWidth("1000px");
		mainTabPanel.setHeight("700px");

		RootPanel.get().add(mainTabPanel);
	}

	private AbsolutePanel getGetUserIdPanel() {
		final Button getUserIdButton = new Button("Chercher");
		getUserIdButton.addStyleName("sendButton");

		Label mailGetUserIdLabel = new Label("Votre E-Mail :");
		final TextBox mailGetUserIdField = new TextBox();
		mailGetUserIdField.setText("");

		AbsolutePanel getUserIdPanel = new AbsolutePanel();
		getUserIdPanel.add(mailGetUserIdLabel, 10, 20);
		getUserIdPanel.add(mailGetUserIdField, 70, 20);
		getUserIdPanel.add(getUserIdButton, 30, 120);
		
		getUserIdButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				createService.getPersonIdWithMailAddress(
						mailGetUserIdField.getText(),
						new AsyncCallback<Long>() {

							public void onFailure(Throwable caught) {
								Window.alert("Erreur de connection.\n\n"
										+ caught.toString());
							}

							public void onSuccess(Long result) {
								Window.alert("Voici l'id associé à votre adresse mail : "
										+ result);
							}

						});
			}
		});
		return getUserIdPanel;
	}

	private AbsolutePanel getAddHeaterPanel() {
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

		Label homeIdAddHeaterLabel = new Label(
				"Identifiant maison :");
		final TextBox homeIdAddHeaterField = new TextBox();
		homeIdAddHeaterField.setText("");
		
		AbsolutePanel addHeaterPanel = new AbsolutePanel();
		addHeaterPanel.add(nameAddHeaterLabel, 10, 20);
		addHeaterPanel.add(nameAddHeaterField, 140, 20);
		addHeaterPanel.add(modelAddHeaterLabel, 10, 50);
		addHeaterPanel.add(modelAddHeaterField, 140, 50);
		addHeaterPanel.add(powerAddHeaterLabel, 10, 80);
		addHeaterPanel.add(powerAddHeaterField, 140, 80);
		addHeaterPanel.add(homeIdAddHeaterLabel, 10, 110);
		addHeaterPanel.add(homeIdAddHeaterField, 140, 110);
		addHeaterPanel.add(addHeaterButton, 30, 140);
		
		
		addHeaterButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				createService.addHeater(nameAddHeaterField.getText(),
						modelAddHeaterField.getText(),
						Integer.parseInt(powerAddHeaterField.getText()),
						Long.parseLong(homeIdAddHeaterField.getText()),
						new AsyncCallback<Integer>() {

							public void onFailure(Throwable arg0) {
								Window.alert("fail");

							}

							public void onSuccess(Integer arg0) {
								if (arg0 == 0) Window.alert("Heater ajoute avec succes");
								else Window.alert("Erreur lors de l'ajout du Heater");
							}
						});
			}
		});
		
		
		
		return addHeaterPanel;
	}

	private AbsolutePanel getAddElectronicDevicePanel() {
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

		Label personIdAddElectronicDeviceLabel = new Label(
				"Identifiant personne :");
		final TextBox personIdAddElectronicDeviceField = new TextBox();
		personIdAddElectronicDeviceField.setText("");

		AbsolutePanel addElectronicDevicePanel = new AbsolutePanel();
		addElectronicDevicePanel.add(nameAddElectronicDeviceLabel, 10, 20);
		addElectronicDevicePanel.add(nameAddElectronicDeviceField, 140, 20);
		addElectronicDevicePanel.add(typeAddElectronicDeviceLabel, 10, 50);
		addElectronicDevicePanel.add(typeAddElectronicDeviceField, 140, 50);
		addElectronicDevicePanel.add(powerAddElectronicDeviceLabel, 10, 80);
		addElectronicDevicePanel.add(powerAddElectronicDeviceField, 140, 80);
		addElectronicDevicePanel.add(personIdAddElectronicDeviceLabel, 10, 110);
		addElectronicDevicePanel.add(personIdAddElectronicDeviceField, 140, 110);
		addElectronicDevicePanel.add(addElectronicDeviceButton, 30, 150);
		
		addElectronicDeviceButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent arg0) {
				createService.addElectronicDevice(nameAddElectronicDeviceField.getText(),
						typeAddElectronicDeviceField.getText(),
						Integer.parseInt(powerAddElectronicDeviceField.getText()),
						Long.parseLong(personIdAddElectronicDeviceField.getText()),
						new AsyncCallback<Integer>() {
							public void onFailure(Throwable caught) {
								Window.alert("Erreur de connection.\n\n"
										+ caught.toString());
							}
							public void onSuccess(Integer arg0) {
								if (arg0 == 0) Window.alert("Electronic Device ajoute avec succes");
								else Window.alert("Erreur lors de l'ajout de l'Electronic Device");
							}
						});
			}
		});
		return addElectronicDevicePanel;
	}

	private AbsolutePanel getAddHomePanel() {
		final Button addHomeButton = new Button("Ajouter le domicile");
		addHomeButton.addStyleName("sendButton");

		Label personIdAddHomeLabel = new Label("Identifiant personne :");
		final TextBox personIdAddHomeField = new TextBox();
		personIdAddHomeField.setText("");

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
		addHomePanel.add(nameAddHomeField, 140, 20);
		addHomePanel.add(addressAddHomeLabel, 10, 50);
		addHomePanel.add(addressAddHomeField, 140, 50);
		addHomePanel.add(zipAddHomeLabel, 10, 80);
		addHomePanel.add(zipAddHomeField, 140, 80);
		addHomePanel.add(townAddHomeLabel, 10, 110);
		addHomePanel.add(townAddHomeField, 140, 110);
		addHomePanel.add(personIdAddHomeLabel, 10, 140);
		addHomePanel.add(personIdAddHomeField, 140, 140);
		addHomePanel.add(addHomeButton, 30, 180);


		addHomeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				createService.addHome(nameAddHomeField.getText(),
						addressAddHomeField.getText(),
						townAddHomeField.getText(), zipAddHomeField.getText(),
						Long.parseLong(personIdAddHomeField.getText()),
						new AsyncCallback<Integer>() {

							public void onFailure(Throwable caught) {
								Window.alert("Erreur de connection.\n\n"
										+ caught.toString());
							}

							public void onSuccess(Integer arg0) {
								if (arg0 == 0) Window.alert("Home ajoutee avec succes");
								else Window.alert("Erreur lors de l'ajout de l'Home");
							}
						});
			}
		});
		return addHomePanel;
	}

	private AbsolutePanel getAddUserPanel() {
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
		
		addUserButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				createService.addUser(firstNameAddUserField.getText(),
						lastNameAddUserField.getText(),
						mailAddUserField.getText(),
						new AsyncCallback<Integer>() {

							public void onSuccess(Integer arg0) {
								if (arg0 == 0) Window.alert("User ajoute avec succes");
								else Window.alert("Erreur lors de l'ajout de l'User");
							}

							public void onFailure(Throwable arg0) {
								Window.alert("fail");
							}
						});
			}
		});
		return addUserPanel;
	}
	
	private AbsolutePanel getAddFriendToUserPanel() {
		final Button addFriendToUserButton = new Button("Ajouter l'ami");
		addFriendToUserButton.addStyleName("sendButton");

		Label idUserLabel = new Label("Id utilisateur :");
		final TextBox idUserField = new TextBox();
		idUserField.setText("");

		Label idFriendLabel = new Label("Id ami :");
		final TextBox idFriendField = new TextBox();
		idFriendField.setText("");

		AbsolutePanel addFriendToUserPanel = new AbsolutePanel();
		addFriendToUserPanel.add(idUserLabel, 10, 20);
		addFriendToUserPanel.add(idUserField, 130, 20);
		addFriendToUserPanel.add(idFriendLabel, 10, 50);
		addFriendToUserPanel.add(idFriendField, 130, 50);
		addFriendToUserPanel.add(addFriendToUserButton, 30, 120);
		
		addFriendToUserButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				createService.addFriendToUser(Long.parseLong(idUserField.getText()),
						Long.parseLong(idFriendField.getText()),
						new AsyncCallback<Void>() {

							public void onFailure(Throwable arg0) {
								Window.alert("Erreur durant l'ajout de l'ami :" + arg0.getMessage());

							}

							public void onSuccess(Void arg0) {
								Window.alert("Ami ajouté avec succes");
							}
						});
			}
		});
		return addFriendToUserPanel;
	}

	private AbsolutePanel getCompareOverallConsPanel() {
		final Button compareButton = new Button("Comparer !");
		compareButton.addStyleName("sendButton");

		Label mail1Label = new Label("e-mail 1 :");
		final TextBox mail1Field = new TextBox();
		mail1Field.setText("");
		
		Label mail2Label = new Label("e-mail 2 :");
		final TextBox mail2Field = new TextBox();
		mail2Field.setText("");
		
		final Label resultLabel = new Label("Result :");
		
		

		AbsolutePanel compareOverallConsPanel = new AbsolutePanel();
		compareOverallConsPanel.add(mail1Label, 10, 20);
		compareOverallConsPanel.add(mail1Field, 70, 20);
		compareOverallConsPanel.add(mail2Label, 10, 50);
		compareOverallConsPanel.add(mail2Field, 70, 50);
		compareOverallConsPanel.add(compareButton, 30, 80);
		compareOverallConsPanel.add(resultLabel, 10, 110);
		
		compareButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				compareService.compareOverallConsummation(mail1Field.getText(), mail2Field.getText(),
						new AsyncCallback<Integer>() {

					public void onFailure(Throwable arg0) {
						Window.alert("Erreur durant la comparaison :" + arg0.getMessage());

					}

					public void onSuccess(Integer arg0) {
						resultLabel.setText(arg0.toString());
					}
				});
			}
		});
		return compareOverallConsPanel;
	}

}
