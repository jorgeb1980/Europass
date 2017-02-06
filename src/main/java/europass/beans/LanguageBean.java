package europass.beans;

/**
 * Information of the skill level on a particular language.  
 */
public class LanguageBean {

	//------------------------------------------------------
	// Bean properties
	
	/** Language name. */
	private String language;
	/** Language conversation level. */
	private String conversationLevel;
	/** Language reading level. */
	private String readingLevel;
	/** Language writing level. */
	private String writingLevel;
	
	//------------------------------------------------------
	// Bean methods
	
	/**
	 * Returns the language name.
	 * @return The language name.
	 */
	public String getLanguage() {
		return language;
	}
	
	/**
	 * Sets the language name.
	 * @param language The language name.
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	
	/**
	 * Returns the language conversation level.
	 * @return The language conversation level.
	 */
	public String getConversationLevel() {
		return conversationLevel;
	}
	
	/**
	 * Sets the language conversation level.
	 * @param conversationLevel the nivelConversacion to set.
	 */
	public void setConversationLevel(String conversationLevel) {
		this.conversationLevel = conversationLevel;
	}
	
	/**
	 * Returns the language reading level.
	 * @return The language reading level.
	 */
	public String getReadingLevel() {
		return readingLevel;
	}
	
	/**
	 * Sets the language reading level.
	 * @param readingLevel The language reading level.
	 */
	public void setReadingLevel(String readingLevel) {
		this.readingLevel = readingLevel;
	}
	
	/**
	 * Returns the language writing level.
	 * @return The language writing level.
	 */
	public String getWritingLevel() {
		return writingLevel;
	}
	
	/**
	 * Sets the language writing level.
	 * @param writingLevel The language writing level.
	 */
	public void setWritingLevel(String writingLevel) {
		this.writingLevel = writingLevel;
	}
	
	/**
	 * Builds a language skill item with its full information.
	 * @param language Language name.
	 * @param conversationLevel Conversation level (description of it).
	 * @param readingLevel Reading level (description of it).
	 * @param writingLevel Writing level (description of it).
	 */
	public LanguageBean(String language, String conversationLevel,
			String readingLevel, String writingLevel) {
		super();
		this.language = language;
		this.conversationLevel = conversationLevel;
		this.readingLevel = readingLevel;
		this.writingLevel = writingLevel;
	}	
}
