package europass.beans;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Full personal information of a user.  
 */
public class PersonalInfoBean {
	
	//-------------------------------------------------------
	// Campos del bean

	/** Name + surname or whatever the user feels like. */
	private String name;
	/** Street address with zip code, etc. */
	private String address;
	/** Home phone. */
	private String homePhone;
	/** Mobile phone. */
	private String mobilePhone;
	/** Correo electrónico. */
	private String mail;
	/** Personal website(s). */
	private List<String> webs;
	/** Instant messaging: protocol -> identity. */
	private Map<String, String> instantMessaging;
	
	//-------------------------------------------------------
	// Métodos del bean
	
	/**
	 * Empty constructor.
	 */
	public PersonalInfoBean() {
		instantMessaging = new HashMap<>();
		webs = new LinkedList<>();
	}
	
	/**
	 * Adss an instant messaging protocol with an identity in it.
	 * @param protocol Protocol name.
	 * @param identity User's identity in that protocol.
	 */
	public void addInstantMessaging(String protocol, String identity) {
		instantMessaging.put(protocol, identity);
	}
	
	/**
	 * Returns the name of the user.
	 * @return User's name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the personal information name.
	 * @param name User's name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the user's address.
	 * @return User's address.
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setAdress(String direccion) {
		this.address = direccion;
	}
	/**
	 * @return the fijo
	 */
	public String getHomePhone() {
		return homePhone;
	}
	/**
	 * @param fijo the fijo to set
	 */
	public void setHomePhone(String fijo) {
		this.homePhone = fijo;
	}
	/**
	 * @return the movil
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}
	/**
	 * @param movil the movil to set
	 */
	public void setMobilePhone(String movil) {
		this.mobilePhone = movil;
	}
	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	/**
	 * Returns the list of the user's web addresses. 
	 * @return List of web addresses
	 */
	public List<String> getWebAddresses() {
		List<String> defensiveCopy = new LinkedList<>();
		defensiveCopy.addAll(webs);
		return defensiveCopy;
	}
	/**
	 * Adds a web to the list of web addresses.
	 * @param web Web URL to add.
	 */
	public void addWeb(String web) {
		this.webs.add(web);
	}
	/**
	 * Returns the table of identities of the user in each instant messaging
	 * protocol.
	 * @return The list of identities, indexed by protocol name.
	 */
	public Map<String, String> getInstantMessaging() {
		Map<String, String> defensiveCopy = new HashMap<>();
		for (String key: instantMessaging.keySet()) {
			defensiveCopy.put(key, instantMessaging.get(key));
		}
		return defensiveCopy;
	}
	
}
