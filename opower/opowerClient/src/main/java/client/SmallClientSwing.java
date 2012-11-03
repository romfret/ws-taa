package client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import business.BusinessInterface;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Hashtable;

public class SmallClientSwing extends JFrame {
	/**
	 * Use Smart Factory by default.
	 */
	private static final String DEFAULT_INITIAL_CONTEXT_FACTORY = "org.ow2.easybeans.component.smartclient.spi.SmartContextFactory";

	private static final long serialVersionUID = -1603136224097745591L;
	private JPanel contentPane;
	
	private JTabbedPane tabbedPane;
	private JPanel personTab;
	private JPanel homeTab;
	private JPanel heaterTab;
	private JPanel electronicDeviceTab;
	
	// Person.panelLeft
	private JPanel panelPersonLeft;
	private JTextField textFieldNomAddPerson;
	private JTextField textFieldPrenomAddPerson;
	private JLabel lblMailAddPerson;
	private JTextField textFieldMailAddPerson;
	private JButton btnAddPerson;
	
	// Person.panelLeftFriends
	private JPanel panelPersonLeftFriends;
	private JLabel lblPersonLeftFirendsPanelTitle;
	private JTextField textFieldMailUtilisateurAddFriends;
	private JTextField textFieldMailAmiAddFriends;
	private JLabel lblMailUtilisateurAddFriends;
	private JLabel lblMailAmiAddFriends;
	private JButton btnAddFriend;
	

	// Person.panelRight
	private JPanel panelPersonRight;
	private JLabel lblPersonLeftPanelTitle;
	private JLabel lblPersonRightPanelTitle;
	private JLabel lblMail1ComparePower;
	private JTextField textFieldMail1ComparePower;
	private JLabel lblMail2ComparePower;
	private JTextField textFieldMail2ComparePower;
	private JButton btnComparer;
	private JButton btnComparer_2;
	private JButton btnComparer_1;
	
	// Home.panelHomeLeft
	private JPanel panelHomeLeft;
	private JLabel lblHomeLeftPanelTitle;
	private JLabel lblMailAddHome;
	private JTextField textFieldMailAddHome;
	private JLabel lblNomAddHome;
	private JTextField textFieldNomAddHome;
	private JLabel lblAdresseAddHome;
	private JTextField textFieldAdresseAddHome;
	private JLabel lblVilleAddHome;
	private JTextField textFieldVilleAddHome;
	private JLabel lblCodePostalAddHome;
	private JTextField textFieldCodePostalAddHome;
	private JButton btnAddHome;
	
	// Home.panelHomeRight
	private JPanel panelHomeRight;
	private JLabel lblRsultatComparePower;
	private JTextField textFieldRsultatComparePower;
	private JLabel lblWattComparePower;
	
	// Heatrer.panelHeaterLeft
	private JPanel panelHeaterLeft;
	private JLabel lblPanelHeaterLeftTitle;
	private JLabel lblNomAddHeater;
	private JTextField textFieldNomAddHeater;
	private JLabel lblModleAddHeater;
	private JTextField textFieldModleAddHeater;
	private JLabel lblPuissanceAddHeater;
	private JTextField textFieldPuissanceAddHeater;
	private JLabel lblIdentifiantMainsonAddHeater;
	private JTextField textFieldIdentifiantMaisonAddHeater;
	private JButton btnAjouterRadiateur;
	
	// Heater.panelHeaterRight
	private JPanel panelHeaterRight;
	private JLabel lblpanelHeaterRight;
	private JLabel lblMail1CompareHeater;
	private JTextField textFieldMail1CompareHeater;
	private JLabel lblMail2CompareHeater;
	private JTextField textFieldMail2CompareHeater;
	private JLabel lblRsultatCompareHeater;
	private JTextField textFieldRsultatCompareHeater;
	private JLabel lblWattCompareHeater;
	
	// ElectronicDevice.panelElectronicDeviceLeft
	private JPanel panelElectronicDeviceLeft;
	private JLabel lblElectronicDeviceLeftPanelTitle;
	private JLabel lblMailAddElectronicDevice;
	private JTextField textFieldMailAddElectronicDevice;
	private JLabel lblNomAddElectronicDevice;
	private JTextField textFieldNomAddElectronicDevice;
	private JLabel lblTypeAddElectronicDevice;
	private JTextField textFieldTypeAddElectronicDevice;
	private JLabel lblPuissanceAddElectronicDevice;
	private JTextField textFieldPuissanceAddElectronicDevice;
	private JButton btnAddElectronicDevice;
	
	// ElectronicDevice.panelElectronicDeviceRight
	private JPanel panelElectronicDeviceRight;
	private JLabel lblpanelElectronicDeviceRight;
	private JLabel lblMail1CompareElectronicDevice;
	private JTextField textFieldMail1CompareElectronicDevice;
	private JLabel lblMail2CompareElectronicDevice;
	private JTextField textFieldMail2CompareElectronicDevice;
	private JLabel lblRsultatCompareElectronicDevice;
	private JTextField textFieldRsultatCompareElectronicDevice;
	private JLabel lblWattCompareElectronicDevice;

	private BusinessInterface serv;
	/**
	 * Create the frame.
	 */
	public SmallClientSwing() {
		setTitle("Opower, Le Client Lourd =)");
		setSize(1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			serv = (BusinessInterface) getInitialContext().lookup(
					"businessImpl");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 1244, 660);
		contentPane.add(tabbedPane);
		
		// Person
		personTab = new JPanel();
		tabbedPane.addTab("Person", null, personTab, null);
		personTab.setLayout(null);
		
		// Person.panelLeft
		panelPersonLeft = new JPanel();
		panelPersonLeft.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelPersonLeft.setLocation(0, 0);
		panelPersonLeft.setSize(614, 310);
		personTab.add(panelPersonLeft, JPanel.LEFT_ALIGNMENT);
		panelPersonLeft.setLayout(null);
		
		JLabel lblNomAddPerson = new JLabel("Nom :");
		lblNomAddPerson.setBounds(10, 101, 78, 14);
		panelPersonLeft.add(lblNomAddPerson);
		
		textFieldNomAddPerson = new JTextField();
		textFieldNomAddPerson.setBounds(98, 98, 506, 20);
		panelPersonLeft.add(textFieldNomAddPerson);
		textFieldNomAddPerson.setColumns(10);
		
		JLabel lblPrenomAddPerson = new JLabel("Prenom :");
		lblPrenomAddPerson.setBounds(10, 146, 78, 14);
		panelPersonLeft.add(lblPrenomAddPerson);
		
		textFieldPrenomAddPerson = new JTextField();
		textFieldPrenomAddPerson.setBounds(98, 143, 506, 20);
		panelPersonLeft.add(textFieldPrenomAddPerson);
		textFieldPrenomAddPerson.setColumns(10);
		
		lblMailAddPerson = new JLabel("Mail :");
		lblMailAddPerson.setBounds(10, 191, 78, 14);
		panelPersonLeft.add(lblMailAddPerson);
		
		textFieldMailAddPerson = new JTextField();
		textFieldMailAddPerson.setBounds(98, 188, 506, 20);
		panelPersonLeft.add(textFieldMailAddPerson);
		textFieldMailAddPerson.setColumns(10);
		
		btnAddPerson = new JButton("Ajouter personne");
		btnAddPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				serv.createPerson(textFieldNomAddPerson.getText(), textFieldPrenomAddPerson.getText(), textFieldMailAddPerson.getText());			}
		});
		btnAddPerson.setBounds(10, 237, 150, 23);
		panelPersonLeft.add(btnAddPerson);
		
		lblPersonLeftPanelTitle = new JLabel("Ajout d'une personne :");
		lblPersonLeftPanelTitle.setBounds(10, 11, 594, 14);
		panelPersonLeft.add(lblPersonLeftPanelTitle);
		
		//Person.panelLeftFriends
		panelPersonLeftFriends = new JPanel();
		panelPersonLeftFriends.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelPersonLeftFriends.setBounds(0, 322, 614, 310);
		personTab.add(panelPersonLeftFriends);
		panelPersonLeftFriends.setLayout(null);
		
		lblPersonLeftFirendsPanelTitle = new JLabel("Ajout d'un ami :");
		lblPersonLeftFirendsPanelTitle.setBounds(10, 11, 594, 14);
		panelPersonLeftFriends.add(lblPersonLeftFirendsPanelTitle);
		
		lblMailUtilisateurAddFriends = new JLabel("Mail utilisateur :");
		lblMailUtilisateurAddFriends.setBounds(10, 98, 115, 14);
		panelPersonLeftFriends.add(lblMailUtilisateurAddFriends);
		
		textFieldMailUtilisateurAddFriends = new JTextField();
		textFieldMailUtilisateurAddFriends.setBounds(138, 95, 466, 20);
		panelPersonLeftFriends.add(textFieldMailUtilisateurAddFriends);
		textFieldMailUtilisateurAddFriends.setColumns(10);
		
		lblMailAmiAddFriends = new JLabel("Mail ami :");
		lblMailAmiAddFriends.setBounds(10, 149, 115, 14);
		panelPersonLeftFriends.add(lblMailAmiAddFriends);
		
		textFieldMailAmiAddFriends = new JTextField();
		textFieldMailAmiAddFriends.setBounds(138, 146, 466, 20);
		panelPersonLeftFriends.add(textFieldMailAmiAddFriends);
		textFieldMailAmiAddFriends.setColumns(10);
		
		btnAddFriend = new JButton("Ajouter ami");
		btnAddFriend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				serv.addFriendToUser(
						serv.getPersonIdByMailAddress(textFieldMailUtilisateurAddFriends.getText()), 
						serv.getPersonIdByMailAddress(textFieldMailAmiAddFriends.getText())
				);
			}
		});
		btnAddFriend.setBounds(10, 208, 150, 23);
		panelPersonLeftFriends.add(btnAddFriend);
		
		// Person.panelRight
		panelPersonRight = new JPanel();
		panelPersonRight.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelPersonRight.setLocation(625, 0);
		panelPersonRight.setSize(614, 632);
		personTab.add(panelPersonRight, JPanel.RIGHT_ALIGNMENT);
		panelPersonRight.setLayout(null);
		
		lblPersonRightPanelTitle = new JLabel("Compare !");
		lblPersonRightPanelTitle.setBounds(10, 11, 594, 14);
		panelPersonRight.add(lblPersonRightPanelTitle);
		
		lblMail1ComparePower = new JLabel("Mail 1 :");
		lblMail1ComparePower.setBounds(10, 106, 107, 14);
		panelPersonRight.add(lblMail1ComparePower);
		
		textFieldMail1ComparePower = new JTextField();
		textFieldMail1ComparePower.setBounds(127, 103, 477, 20);
		panelPersonRight.add(textFieldMail1ComparePower);
		textFieldMail1ComparePower.setColumns(10);
		
		lblMail2ComparePower = new JLabel("Mail 2 :");
		lblMail2ComparePower.setBounds(10, 164, 107, 14);
		panelPersonRight.add(lblMail2ComparePower);
		
		textFieldMail2ComparePower = new JTextField();
		textFieldMail2ComparePower.setBounds(127, 161, 477, 20);
		panelPersonRight.add(textFieldMail2ComparePower);
		textFieldMail2ComparePower.setColumns(10);

		textFieldRsultatComparePower = new JTextField();
		btnComparer = new JButton("Comparer !");
		btnComparer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int diff = serv.compareOverallConsummation (
						serv.getPersonIdByMailAddress(textFieldMail1ComparePower.getText()), 
						serv.getPersonIdByMailAddress(textFieldMail2ComparePower.getText())
				);
				textFieldRsultatComparePower.setText(String.valueOf(diff));
			}
		});
		btnComparer.setBounds(10, 227, 150, 23);
		panelPersonRight.add(btnComparer);
		
		lblRsultatComparePower = new JLabel("R\u00E9sultat :");
		lblRsultatComparePower.setBounds(10, 331, 107, 14);
		panelPersonRight.add(lblRsultatComparePower);
		
		textFieldRsultatComparePower.setEditable(false);
		textFieldRsultatComparePower.setBounds(127, 328, 175, 20);
		panelPersonRight.add(textFieldRsultatComparePower);
		textFieldRsultatComparePower.setColumns(10);
		
		lblWattComparePower = new JLabel("Watt");
		lblWattComparePower.setBounds(312, 331, 46, 14);
		panelPersonRight.add(lblWattComparePower);
		
		
		// Home
		homeTab = new JPanel();
		tabbedPane.addTab("Home", null, homeTab, null);
		homeTab.setLayout(null);
		
		// Home.panelHomeLeft
		panelHomeLeft = new JPanel();
		panelHomeLeft.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelHomeLeft.setBounds(0, 0, 614, 632);
		homeTab.add(panelHomeLeft, JPanel.LEFT_ALIGNMENT);
		panelHomeLeft.setLayout(null);
		
		lblHomeLeftPanelTitle = new JLabel("Ajout d'une maison");
		lblHomeLeftPanelTitle.setBounds(10, 11, 594, 14);
		panelHomeLeft.add(lblHomeLeftPanelTitle);
		
		lblMailAddHome = new JLabel("Votre adresse mail :");
		lblMailAddHome.setBounds(10, 101, 124, 14);
		panelHomeLeft.add(lblMailAddHome);
		
		textFieldMailAddHome = new JTextField();
		textFieldMailAddHome.setBounds(144, 98, 460, 20);
		panelHomeLeft.add(textFieldMailAddHome);
		textFieldMailAddHome.setColumns(10);
		
		lblNomAddHome = new JLabel("Nom :");
		lblNomAddHome.setBounds(10, 147, 124, 14);
		panelHomeLeft.add(lblNomAddHome);
		
		textFieldNomAddHome = new JTextField();
		textFieldNomAddHome.setBounds(144, 144, 460, 20);
		panelHomeLeft.add(textFieldNomAddHome);
		textFieldNomAddHome.setColumns(10);
		
		lblAdresseAddHome = new JLabel("Adresse :");
		lblAdresseAddHome.setBounds(10, 194, 124, 14);
		panelHomeLeft.add(lblAdresseAddHome);
		
		textFieldAdresseAddHome = new JTextField();
		textFieldAdresseAddHome.setBounds(144, 191, 460, 20);
		panelHomeLeft.add(textFieldAdresseAddHome);
		textFieldAdresseAddHome.setColumns(10);
		
		lblVilleAddHome = new JLabel("Ville :");
		lblVilleAddHome.setBounds(10, 240, 124, 14);
		panelHomeLeft.add(lblVilleAddHome);
		
		textFieldVilleAddHome = new JTextField();
		textFieldVilleAddHome.setBounds(144, 237, 460, 20);
		panelHomeLeft.add(textFieldVilleAddHome);
		textFieldVilleAddHome.setColumns(10);
		
		lblCodePostalAddHome = new JLabel("Code postal :");
		lblCodePostalAddHome.setBounds(10, 287, 132, 14);
		panelHomeLeft.add(lblCodePostalAddHome);
		
		textFieldCodePostalAddHome = new JTextField();
		textFieldCodePostalAddHome.setBounds(144, 284, 460, 20);
		panelHomeLeft.add(textFieldCodePostalAddHome);
		textFieldCodePostalAddHome.setColumns(10);
		
		btnAddHome = new JButton("Ajouter maison");
		btnAddHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				serv.createHome(
						textFieldNomAddHome.getText(),
						textFieldAdresseAddHome.getText(),
						textFieldVilleAddHome.getText(),
						textFieldCodePostalAddHome.getText(), 
						serv.getPersonIdByMailAddress(textFieldMailAddHome.getText())
				);
			}
		});
		btnAddHome.setBounds(10, 342, 210, 23);
		panelHomeLeft.add(btnAddHome);
		
		// Home.panelHomeRight
		panelHomeRight = new JPanel();
		panelHomeRight.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelHomeRight.setBounds(625, 0, 614, 632);
		homeTab.add(panelHomeRight, JPanel.RIGHT_ALIGNMENT);
		panelHomeRight.setLayout(null);
		
		// Heater
		heaterTab = new JPanel();
		tabbedPane.addTab("Heater", null, heaterTab, null);
		heaterTab.setLayout(null);
		
		// Heater.panelHeaterLeft
		panelHeaterLeft = new JPanel();
		panelHeaterLeft.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelHeaterLeft.setBounds(0, 0, 614, 632);
		heaterTab.add(panelHeaterLeft);
		panelHeaterLeft.setLayout(null);
		
		lblPanelHeaterLeftTitle = new JLabel("Ajouter un radiateur :");
		lblPanelHeaterLeftTitle.setBounds(10, 11, 594, 14);
		panelHeaterLeft.add(lblPanelHeaterLeftTitle);
		
		lblNomAddHeater = new JLabel("Nom :");
		lblNomAddHeater.setBounds(10, 67, 153, 14);
		panelHeaterLeft.add(lblNomAddHeater);
		
		textFieldNomAddHeater = new JTextField();
		textFieldNomAddHeater.setBounds(173, 64, 431, 20);
		panelHeaterLeft.add(textFieldNomAddHeater);
		textFieldNomAddHeater.setColumns(10);
		
		lblModleAddHeater = new JLabel("Mod\u00E8le :");
		lblModleAddHeater.setBounds(10, 114, 153, 14);
		panelHeaterLeft.add(lblModleAddHeater);
		
		textFieldModleAddHeater = new JTextField();
		textFieldModleAddHeater.setBounds(173, 111, 431, 20);
		panelHeaterLeft.add(textFieldModleAddHeater);
		textFieldModleAddHeater.setColumns(10);
		
		lblPuissanceAddHeater = new JLabel("Puissance :");
		lblPuissanceAddHeater.setBounds(10, 155, 153, 14);
		panelHeaterLeft.add(lblPuissanceAddHeater);
		
		textFieldPuissanceAddHeater = new JTextField();
		textFieldPuissanceAddHeater.setBounds(173, 152, 431, 20);
		panelHeaterLeft.add(textFieldPuissanceAddHeater);
		textFieldPuissanceAddHeater.setColumns(10);
		
		lblIdentifiantMainsonAddHeater = new JLabel("Identifiant maison :");
		lblIdentifiantMainsonAddHeater.setBounds(10, 211, 153, 14);
		panelHeaterLeft.add(lblIdentifiantMainsonAddHeater);
		
		textFieldIdentifiantMaisonAddHeater = new JTextField();
		textFieldIdentifiantMaisonAddHeater.setBounds(173, 208, 431, 20);
		panelHeaterLeft.add(textFieldIdentifiantMaisonAddHeater);
		textFieldIdentifiantMaisonAddHeater.setColumns(10);
		
		btnAjouterRadiateur = new JButton("Ajouter radiateur");
		btnAjouterRadiateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				serv.createHeater(
						textFieldNomAddHeater.getText(), 
						textFieldModleAddHeater.getText(), 
						Integer.parseInt(textFieldPuissanceAddHeater.getText())
						,  Long.parseLong(textFieldIdentifiantMaisonAddHeater.getText()));
			}
		});
		btnAjouterRadiateur.setBounds(10, 277, 150, 23);
		panelHeaterLeft.add(btnAjouterRadiateur);
		
		// Heater.panelHeaterRight
		panelHeaterRight = new JPanel();
		panelHeaterRight.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelHeaterRight.setBounds(625, 0, 614, 632);
		heaterTab.add(panelHeaterRight);
		panelHeaterRight.setLayout(null);
		
		lblpanelHeaterRight = new JLabel("Compare !");
		lblpanelHeaterRight.setBounds(10, 11, 594, 14);
		panelHeaterRight.add(lblpanelHeaterRight);
		
		lblMail1CompareHeater = new JLabel("Mail 1 :");
		lblMail1CompareHeater.setBounds(10, 106, 107, 14);
		panelHeaterRight.add(lblMail1CompareHeater);
		
		textFieldMail1CompareHeater = new JTextField();
		textFieldMail1CompareHeater.setBounds(127, 103, 477, 20);
		panelHeaterRight.add(textFieldMail1CompareHeater);
		textFieldMail1CompareHeater.setColumns(10);
		
		lblMail2CompareHeater = new JLabel("Mail 2 :");
		lblMail2CompareHeater.setBounds(10, 164, 107, 14);
		panelHeaterRight.add(lblMail2CompareHeater);
		
		textFieldMail2CompareHeater = new JTextField();
		textFieldMail2CompareHeater.setBounds(127, 161, 477, 20);
		panelHeaterRight.add(textFieldMail2CompareHeater);
		textFieldMail2CompareHeater.setColumns(10);
		
		textFieldRsultatCompareHeater = new JTextField();
		btnComparer_1 = new JButton("Comparer !");
		btnComparer_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int diff = serv.compareHeatersConsummation(
						serv.getPersonIdByMailAddress(textFieldMail1CompareHeater.getText()), 
						serv.getPersonIdByMailAddress(textFieldMail2CompareHeater.getText()));
				textFieldRsultatCompareHeater.setText(String.valueOf(diff));
			}
		});
		btnComparer_1.setBounds(10, 227, 150, 23);
		panelHeaterRight.add(btnComparer_1);
		
		lblRsultatCompareHeater = new JLabel("R\u00E9sultat :");
		lblRsultatCompareHeater.setBounds(10, 331, 107, 14);
		panelHeaterRight.add(lblRsultatCompareHeater);
		
		
		textFieldRsultatCompareHeater.setEditable(false);
		textFieldRsultatCompareHeater.setBounds(127, 328, 175, 20);
		panelHeaterRight.add(textFieldRsultatCompareHeater);
		textFieldRsultatCompareHeater.setColumns(10);
		
		lblWattCompareHeater = new JLabel("Watt");
		lblWattCompareHeater.setBounds(312, 331, 46, 14);
		panelHeaterRight.add(lblWattCompareHeater);
		
		
		// ElectronicDevice
		electronicDeviceTab = new JPanel();
		tabbedPane.addTab("Electronic device", null, electronicDeviceTab, null);
		electronicDeviceTab.setLayout(null);
		
		// ElectronicDevice.panelHomeLeft
		panelElectronicDeviceLeft = new JPanel();
		panelElectronicDeviceLeft.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelElectronicDeviceLeft.setBounds(0, 0, 614, 632);
		electronicDeviceTab.add(panelElectronicDeviceLeft, JPanel.LEFT_ALIGNMENT);
		panelElectronicDeviceLeft.setLayout(null);
		
		lblElectronicDeviceLeftPanelTitle = new JLabel("Ajout d'un appareil \u00E9lectronique");
		lblElectronicDeviceLeftPanelTitle.setBounds(10, 11, 594, 14);
		panelElectronicDeviceLeft.add(lblElectronicDeviceLeftPanelTitle);
		
		lblMailAddElectronicDevice = new JLabel("Votre adresse mail :");
		lblMailAddElectronicDevice.setBounds(10, 101, 124, 14);
		panelElectronicDeviceLeft.add(lblMailAddElectronicDevice);
		
		textFieldMailAddElectronicDevice = new JTextField();
		textFieldMailAddElectronicDevice.setBounds(144, 98, 460, 20);
		panelElectronicDeviceLeft.add(textFieldMailAddElectronicDevice);
		textFieldMailAddElectronicDevice.setColumns(10);
		
		lblNomAddElectronicDevice = new JLabel("Nom :");
		lblNomAddElectronicDevice.setBounds(10, 147, 124, 14);
		panelElectronicDeviceLeft.add(lblNomAddElectronicDevice);
		
		textFieldNomAddElectronicDevice = new JTextField();
		textFieldNomAddElectronicDevice.setBounds(144, 144, 460, 20);
		panelElectronicDeviceLeft.add(textFieldNomAddElectronicDevice);
		textFieldNomAddElectronicDevice.setColumns(10);
		
		lblTypeAddElectronicDevice = new JLabel("Type :");
		lblTypeAddElectronicDevice.setBounds(10, 194, 124, 14);
		panelElectronicDeviceLeft.add(lblTypeAddElectronicDevice);
		
		textFieldTypeAddElectronicDevice = new JTextField();
		textFieldTypeAddElectronicDevice.setBounds(144, 191, 460, 20);
		panelElectronicDeviceLeft.add(textFieldTypeAddElectronicDevice);
		textFieldTypeAddElectronicDevice.setColumns(10);
		
		lblPuissanceAddElectronicDevice = new JLabel("Puissance :");
		lblPuissanceAddElectronicDevice.setBounds(10, 240, 124, 14);
		panelElectronicDeviceLeft.add(lblPuissanceAddElectronicDevice);
		
		textFieldPuissanceAddElectronicDevice = new JTextField();
		textFieldPuissanceAddElectronicDevice.setBounds(144, 237, 460, 20);
		panelElectronicDeviceLeft.add(textFieldPuissanceAddElectronicDevice);
		textFieldPuissanceAddElectronicDevice.setColumns(10);
		
		btnAddElectronicDevice = new JButton("Ajouter appareil \u00E9lectronique");
		btnAddElectronicDevice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			long t = serv.getPersonIdByMailAddress(textFieldMailAddElectronicDevice.getText());
				serv.createElectronicDevice(textFieldNomAddElectronicDevice.getText(),
						textFieldTypeAddElectronicDevice.getText(),
						Integer.parseInt(textFieldPuissanceAddElectronicDevice.getText()),
						t);
			}
		});
		btnAddElectronicDevice.setBounds(10, 294, 210, 23);
		panelElectronicDeviceLeft.add(btnAddElectronicDevice);
		
		
		// ElectronicDevice.panelHomeRight
		panelElectronicDeviceRight = new JPanel();
		panelElectronicDeviceRight.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelElectronicDeviceRight.setBounds(625, 0, 614, 632);
		electronicDeviceTab.add(panelElectronicDeviceRight);
		panelElectronicDeviceRight.setLayout(null);
		
		lblpanelElectronicDeviceRight = new JLabel("Compare !");
		lblpanelElectronicDeviceRight.setBounds(10, 11, 594, 14);
		panelElectronicDeviceRight.add(lblpanelElectronicDeviceRight);
		
		lblMail1CompareElectronicDevice = new JLabel("Mail 1 :");
		lblMail1CompareElectronicDevice.setBounds(10, 106, 107, 14);
		panelElectronicDeviceRight.add(lblMail1CompareElectronicDevice);
		
		textFieldMail1CompareElectronicDevice = new JTextField();
		textFieldMail1CompareElectronicDevice.setBounds(127, 103, 477, 20);
		panelElectronicDeviceRight.add(textFieldMail1CompareElectronicDevice);
		textFieldMail1CompareElectronicDevice.setColumns(10);
		
		lblMail2CompareElectronicDevice = new JLabel("Mail 2 :");
		lblMail2CompareElectronicDevice.setBounds(10, 164, 107, 14);
		panelElectronicDeviceRight.add(lblMail2CompareElectronicDevice);
		
		textFieldMail2CompareElectronicDevice = new JTextField();
		textFieldMail2CompareElectronicDevice.setBounds(127, 161, 477, 20);
		panelElectronicDeviceRight.add(textFieldMail2CompareElectronicDevice);
		textFieldMail2CompareElectronicDevice.setColumns(10);
		
		textFieldRsultatCompareElectronicDevice = new JTextField();
		btnComparer_2 = new JButton("Comparer !");
		btnComparer_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long t1 = serv.getPersonIdByMailAddress(textFieldMail1CompareElectronicDevice.getText());
				long t2 = serv.getPersonIdByMailAddress(textFieldMail2CompareElectronicDevice.getText());

				int diff = serv.compareElectronicDevicesConsummation(
						t1, 
						t2
				);
				textFieldRsultatCompareElectronicDevice.setText(String.valueOf(diff));
			}
		});
		btnComparer_2.setBounds(10, 227, 150, 23);
		panelElectronicDeviceRight.add(btnComparer_2);
		
		lblRsultatCompareElectronicDevice = new JLabel("R\u00E9sultat :");
		lblRsultatCompareElectronicDevice.setBounds(10, 331, 107, 14);
		panelElectronicDeviceRight.add(lblRsultatCompareElectronicDevice);
		
		
		textFieldRsultatCompareElectronicDevice.setEditable(false);
		textFieldRsultatCompareElectronicDevice.setBounds(127, 328, 175, 20);
		panelElectronicDeviceRight.add(textFieldRsultatCompareElectronicDevice);
		textFieldRsultatCompareElectronicDevice.setColumns(10);
		
		lblWattCompareElectronicDevice = new JLabel("Watt");
		lblWattCompareElectronicDevice.setBounds(312, 331, 46, 14);
		panelElectronicDeviceRight.add(lblWattCompareElectronicDevice);
	
	}
	
	public void addHome() {
		System.out.println("maison !");
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
