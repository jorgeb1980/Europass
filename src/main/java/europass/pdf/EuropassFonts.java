package europass.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;

import static com.itextpdf.text.FontFactory.getFont;

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
	public static Font LEFT_TITLE_FONT = getFont("arial", 9, DEEP_BLUE_COLOR);
	public static Font BASE_FONT = getFont("arial", 9, BASE_COLOR);
	public static Font RELEVANT_FONT = getFont("arial", 13, BASE_COLOR);
	public static Font JOB_TITLE_FONT = getFont("arial", 11, DEEP_BLUE_COLOR);
	public static Font LITTLE_BLUE_FONT = getFont("arial", 8, DEEP_BLUE_COLOR);

}
