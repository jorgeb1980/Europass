package europass.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;

/**
 * Gives font functionality.
 */
public class EuropassFonts {

	//-------------------------------------------------
	// Class properties
	
	/** Color for deep blue titles. */
	public static final BaseColor DEEP_BLUE_COLOR = new BaseColor(14, 65, 148);
	/** Document base color (black). */
	public static final BaseColor BASE_COLOR = new BaseColor(63, 58, 67);
	// Static singleton instances for the fonts
	private static Font LEFT_TITLE_FONT = null;
	private static Font BASE_FONT = null;
	private static Font RELEVANT_FONT = null;
	private static Font JOB_TITLE_FONT = null;
	private static Font LITTLE_BLUE_FONT = null;
	
	//-------------------------------------------------
	// Class methods
	
	/**
	 * Returns the font for the containers' left side.
	 * @return Font for the containers' left side (arial 9 pt. deep blue).
	 */
	public static Font leftTitleFont() {
		if (LEFT_TITLE_FONT == null) {
			LEFT_TITLE_FONT = 
				FontFactory.getFont("arial", 9, DEEP_BLUE_COLOR);
		}
		return LEFT_TITLE_FONT;
	}
	
	/**
	 * Returns the base font for the document.
	 * @return Base font for the document (arial 9 pt. black).
	 */
	public static Font baseFont() {
		if (BASE_FONT == null) {
			BASE_FONT = 
				FontFactory.getFont("arial", 9, BASE_COLOR);
		}
		return BASE_FONT;
	}
	
	/**
	 * Returns the font used for relevant details.
	 * @return Font for relevant details (arial 13 pt. black).
	 */
	public static Font relevantFont() {
		if (RELEVANT_FONT == null) {
			RELEVANT_FONT = 
				FontFactory.getFont("arial", 13, BASE_COLOR);
		}
		return RELEVANT_FONT;
	}
	
	/**
	 * Returns the font for the job title.
	 * @return Font for the jobTitle (arial 11 pt. deep blue).
	 */
	public static Font jobTitleFont() {
		if (JOB_TITLE_FONT == null) {
			JOB_TITLE_FONT = 
				FontFactory.getFont("arial", 11, DEEP_BLUE_COLOR);
		}
		return JOB_TITLE_FONT;
	}

	/**
	 * Creates an 8 pt. blue font.
	 * @return 8 pt. blue font (arial 8 pt. deep blue).
	 */
	public static Font littleBlueFont() {
		if (LITTLE_BLUE_FONT == null) {
			LITTLE_BLUE_FONT = 
				FontFactory.getFont("arial", 8, DEEP_BLUE_COLOR);
		}
		return LITTLE_BLUE_FONT;
	}
}
