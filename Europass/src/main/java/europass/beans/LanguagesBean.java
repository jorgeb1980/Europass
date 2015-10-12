package europass.beans;

import java.util.LinkedList;
import java.util.List;

/**
 * Full information of language skills for a person.  
 */
public class LanguagesBean {

		
	//------------------------------------------------------
	// Bean properties
	
	/** Language skills list. */
	private List<LanguageBean> languages = null;
	
	//------------------------------------------------------
	// Bean methods
	
	/** Empty constructor. */
	public LanguagesBean() {
		languages = new LinkedList<LanguageBean>();
	}

	/**
	 * Returns the list of language skills.
	 * @return Language skills.
	 */
	public List<LanguageBean> getLanguages() {
		List<LanguageBean> defensiveCopy = new LinkedList<>();
		defensiveCopy.addAll(languages);
		return defensiveCopy;
	}
	
	/**
	 * Adds a language skill to the list.
	 * @param language Language skill
	 */
	public void addLanguage(LanguageBean language) {
		languages.add(language);
	}
}
