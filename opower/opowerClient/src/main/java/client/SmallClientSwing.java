package client;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SmallClientSwing extends JFrame {

	private static final long serialVersionUID = -1603136224097745591L;
	private JPanel contentPane;
	
	private JTabbedPane tabbedPane;
	private JPanel personTab;
	private JPanel homeTab;
	private JPanel heaterTab;
	
	// Person.panelLeft
	private JPanel panelPersonLeft;
	private JTextField textFieldNomAddPerson;
	private JTextField textFieldPrenomAddPerson;
	private JLabel lblMailAddPerson;
	private JTextField textFieldMailAddPerson;
	private JButton btnAddPerson;
	

	// Person.panelRight
	private JPanel panelPersonRight;
	private JLabel lblPersonLeftPanelTitle;
	private JLabel lblPersonRightPanelTitle;
	
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


	/**
	 * Create the frame.
	 */
	public SmallClientSwing() {
		setTitle("Opower, Le Client Lourd =)");
		setSize(1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		// Person.leftPanel
		panelPersonLeft = new JPanel();
		panelPersonLeft.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelPersonLeft.setLocation(0, 0);
		panelPersonLeft.setSize(614, 632);
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
		btnAddPerson.setBounds(10, 237, 150, 23);
		panelPersonLeft.add(btnAddPerson);
		
		lblPersonLeftPanelTitle = new JLabel("Ajout d'une personne :");
		lblPersonLeftPanelTitle.setBounds(10, 11, 594, 14);
		panelPersonLeft.add(lblPersonLeftPanelTitle);
		
		// Person.rightPanel
		panelPersonRight = new JPanel();
		panelPersonRight.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelPersonRight.setLocation(625, 0);
		panelPersonRight.setSize(614, 632);
		personTab.add(panelPersonRight, JPanel.RIGHT_ALIGNMENT);
		panelPersonRight.setLayout(null);
		
		lblPersonRightPanelTitle = new JLabel("Truc muche");
		lblPersonRightPanelTitle.setBounds(10, 11, 594, 14);
		panelPersonRight.add(lblPersonRightPanelTitle);
		
		
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
		
		btnAddHome = new JButton("Ajouter mainson");
		btnAddHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		
		
		this.setVisible(true);
	}
}
