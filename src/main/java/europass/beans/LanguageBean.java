package europass.beans;

/**
 * Information of the skill level on a particular language.  
 */
public record LanguageBean (
	/* Language name. */
	String language,
	/* Language conversation level. */
	String conversationLevel,
	/* Language reading level. */
	String readingLevel,
	/* Language writing level. */
	String writingLevel
) { }
