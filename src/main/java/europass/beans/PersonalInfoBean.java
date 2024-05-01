package europass.beans;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Full personal information of a user.  
 */
public record PersonalInfoBean (
	/* Name + surname or whatever the user feels like. */
	String name,
	/* Street address with zip code, etc. */
	String address,
	/* Home phone. */
	String homePhone,
	/* Mobile phone. */
	String mobilePhone,
	/* e-mail */
	String mail,
	/* Personal website(s). */
	List<String> webs,
	/* Instant messaging: protocol -> identity. */
	Map<String, String> instantMessaging
) {
	
	/**
	 * Adss an instant messaging protocol with an identity in it.
	 * @param protocol Protocol name.
	 * @param identity User's identity in that protocol.
	 */
	public void addInstantMessaging(String protocol, String identity) {
		instantMessaging.put(protocol, identity);
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
