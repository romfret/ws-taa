package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PERSON")
public class Person implements Serializable {

	private static final long serialVersionUID = -2396723987526536368L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String lastName;
	private String firstName;
	private String mail;

	@OneToMany(mappedBy="owner")
	@ElementCollection(fetch = FetchType.EAGER)
	private List<Home> homes;

	 // Faire une table de jointure pour friends
//	@OneToMany(mappedBy="id")
	@ElementCollection(fetch = FetchType.EAGER)
	private List<Person> friends;

	@OneToMany(mappedBy="owner")
	@ElementCollection(fetch = FetchType.EAGER)
	private List<ElectronicDevice> devices;

	public Person() {
		this.homes = new ArrayList<Home>();
		this.friends = new ArrayList<Person>();
		this.devices = new ArrayList<ElectronicDevice>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<Home> getHomes() {
		return homes;
	}

	public void setHomes(List<Home> homes) {
		this.homes = homes;
	}

	public void addHome(Home home) {
		homes.add(home);
	}

	public List<Person> getFriends() {
		return friends;
	}

	public void setFriends(List<Person> friends) {
		this.friends = friends;
	}

	public void addFriend(Person friend) {
		friends.add(friend);
	}

	public List<ElectronicDevice> getDevices() {
		return devices;
	}

	public void setDevices(List<ElectronicDevice> devices) {
		this.devices = devices;
	}

	public void addDevice(ElectronicDevice device) {
		devices.add(device);
	}

}
