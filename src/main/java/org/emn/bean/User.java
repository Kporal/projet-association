/*
 * Created on 7 oct. 2013 ( Time 10:50:02 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
// This Bean has a basic Primary Key (not composite) 

package org.emn.bean;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Persistent class for entity stored in table "UTILISATEUR"
 * 
 * @author Telosys Tools Generator
 * 
 */
@XmlRootElement
// JAXB annotation for REST Web Services
@XmlAccessorType(XmlAccessType.PROPERTY)
// JAXB accessor = getter/setter pair
@Entity
@Table(name = "UTILISATEUR", schema = "PASSO")
// Define named queries here
// @NamedQueries ( {
// @NamedQuery ( name="User.query1", query="SELECT x FROM User x WHERE  " ),
// @NamedQuery ( name="User.query2", query="SELECT x FROM User x WHERE  " )
// } )
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
	// ----------------------------------------------------------------------
	@Id
	@Column(name = "ID", nullable = false)
	private int id;

	// ----------------------------------------------------------------------
	// ENTITY DATA FIELDS
	// ----------------------------------------------------------------------
	@Column(name = "LOGIN", length = 30)
	private String login;

	@Column(name = "PASS", length = 20)
	private String password;

	@Column(name = "NOM", length = 40)
	private String lastName;

	@Column(name = "PRENOM", length = 30)
	private String firstName;

	@Column(name = "ADRESSE", length = 100)
	private String address;

	@Column(name = "CODE_POSTAL", length = 5)
	private String zipCode;

	@Column(name = "VILLE", length = 30)
	private String city;

	// "countryId" (column "PAYS_ID") is not defined by itself because used as
	// FK in a link

	// ----------------------------------------------------------------------
	// ENTITY LINKS ( RELATIONSHIP )
	// ----------------------------------------------------------------------
	@ManyToOne
	@JoinColumn(name = "PAYS_ID", referencedColumnName = "ID", insertable = false, updatable = false)
	private Country country;

	@ManyToMany(mappedBy = "listOfUser", targetEntity = Item.class)
	private List<Item> listOfItem;

	// ----------------------------------------------------------------------
	// CONSTRUCTOR(S)
	// ----------------------------------------------------------------------
	public User() {
		super();
	}

	// ----------------------------------------------------------------------
	// GETTER & SETTER FOR THE KEY FIELD
	// ----------------------------------------------------------------------
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	// ----------------------------------------------------------------------
	// GETTERS & SETTERS FOR FIELDS
	// ----------------------------------------------------------------------
	// --- DATABASE MAPPING : LOGIN ( VARCHAR )
	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return this.login;
	}

	// --- DATABASE MAPPING : PASS ( VARCHAR )
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	// --- DATABASE MAPPING : NOM ( VARCHAR )
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return this.lastName;
	}

	// --- DATABASE MAPPING : PRENOM ( VARCHAR )
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	// --- DATABASE MAPPING : ADRESSE ( VARCHAR )
	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}

	// --- DATABASE MAPPING : CODE_POSTAL ( VARCHAR )
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	// --- DATABASE MAPPING : VILLE ( VARCHAR )
	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return this.city;
	}

	// ----------------------------------------------------------------------
	// GETTERS & SETTERS FOR LINKS
	// ----------------------------------------------------------------------
	public void setCountry(Country country) {
		this.country = country;
	}

	public Country getCountry() {
		return this.country;
	}

	@XmlTransient
	public void setListOfItem(List<Item> listOfItem) {
		this.listOfItem = listOfItem;
	}

	public List<Item> getListOfItem() {
		return this.listOfItem;
	}

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(id);
		sb.append("|");
		sb.append(login);
		sb.append("|");
		sb.append(password);
		sb.append("|");
		sb.append(lastName);
		sb.append("|");
		sb.append(firstName);
		sb.append("|");
		sb.append(address);
		sb.append("|");
		sb.append(zipCode);
		sb.append("|");
		sb.append(city);
		return sb.toString();
	}
}
