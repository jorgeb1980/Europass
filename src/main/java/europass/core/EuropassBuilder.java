package europass.core;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import europass.beans.*;
import europass.pdf.EuropassFonts;

import javax.imageio.ImageIO;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static europass.pdf.EuropassFonts.*;

/**
 * Builds a curriculum vitae PDF in Europass format based on the information
 * passed as a parameter.
 */
public class EuropassBuilder {
	
	//--------------------------------------------------------------
	// Class constants
	
	// The CV page is built into horizontal containers (tables) with a title
	//	in its left side and information in the right side
	
	/** Containers' left side width (in %). */
	private static final float LEFT_SIDE_WIDTH = 30;
	
	/** Image read buffer. */
	private static final int BUFFER_SIZE = 8 * 1024;
	
	//--------------------------------------------------------------
	// Class properties	
	
	/** Dates format. */
	private final SimpleDateFormat sdf;
	/** Locale to be used while building the document. */
	private Locale locale = Locale.getDefault();
	
	//--------------------------------------------------------------
	// Class methods

	/**
	 * Creates a builder with the current machine default locale.
	 */
	public EuropassBuilder() {
		this(null);
	}
	
	/**
	 * Creates a builder with the specified locale.
	 * @param locale Locale to be used to render internationalized text.
	 */
	public EuropassBuilder(Locale locale) {
		if (locale != null) this.locale = locale;
		sdf = new SimpleDateFormat("MMMM yyyy", this.locale);
	}
	
	// Translates a literal into the appropriate value using the 
	//	selected locale 
	private String i18n(String literal) {
		return I18n.RESOURCES.getLabel(locale, literal);
	}
	
	/**
	 * Builds an iText document based on the CV information.
	 * @param information CV information.
	 * @param os Where to output the binary result (PDF document).
	 * @throws EuropassException Library exception wrapper. 
	 */
	public void buildCV(ResumeBean information, OutputStream os) 
			throws EuropassException {
		try {
			var document = new Document();
			var writer = PdfWriter.getInstance(document, os);
			document.open();
			setupDocument(document);
			paintPersonalInfo(document, information.personalInfo());
			paintProfessionalExperience(document, information.workExperience());
			paintTrainingCertifications(document, information.trainings());
			paintLanguages(document, information.languages());
			document.close();		
			writer.flush();		
		}
		catch(DocumentException | IOException de) {
			throw new EuropassException(de);
		}
    }
	
	/**
	 * Document margins, orientation, size, etc.
	 * @param document iText document to setup.
	 */
	private void setupDocument(Document document) {
		document.setPageSize(PageSize.A4);
		document.setMargins(0.5f, 0.5f, 0.5f, 0.5f);
	}
	
	/**
	 * Creates a horizontal section in the document.
	 * <pre>
	 * {@code
	 *  ____________________________________________________
	 * |       leftTitle        |                           |
	 * |                        |                           |
	 * |                        |       content             |
	 * |                        |                           |
	 * |________________________|___________________________|
	 * }</pre>
	 * @param document Document on which to draw a section.
	 * @param leftTitle Left side title (blue font).
	 * @param content Right side content, expressed as PdfTable.
	 * @throws DocumentException In case of any problem handling the PDF.
	 */
	private void section(
		Document document,
		String leftTitle,
		PdfPTable content
	) throws DocumentException {
		section(document, leftTitle, null, content);
	}
	
	/**
	 * Creates an horizontal section in the document.  If the right title is set,
	 * then it creates a title above the content.
	 * <pre>
	 * {@code
	 *  ____________________________________________________
	 * |       leftTitle        |      rightTitle           |
	 * |                        |                           |
	 * |                        |       content             |
	 * |                        |                           |
	 * |________________________|___________________________|
	 * }</pre>
	 * @param document Document on which to draw a section.
	 * @param leftTitle Left side title (blue font).
	 * @param rightTitle Right side title (relevant font).
	 * @param content Right side content, expressed as PdfTable.
	 * @throws DocumentException In case of any problem handling the PDF.
	 */
	private void section(
		Document document,
		String leftTitle,
		String rightTitle,
		PdfPTable content
	) throws DocumentException {
		section(document, leftTitle, rightTitle, RELEVANT_FONT, content);
	}

	/**
	 * Creates an horizontal section in the document.  If the right title is set, 
	 * it creates a title above the content.
	 * <pre>
	 * {@code
	 *  ____________________________________________________
	 * |       leftTitle        |      rightTitle           |
	 * |                        |                           |
	 * |                        |       content             |
	 * |                        |                           |
	 * |________________________|___________________________|
	 * }</pre>
	 * @param document Document on which to draw a section.
	 * @param leftTitle Left side title (blue font).
	 * @param rightTitle Right side title.
	 * @param rightTitleStyle Right side title font.
	 * @param content Right side content, expressed as PdfTable.
	 * @throws DocumentException In case of any problem handling the PDF.
	 */
	private void section(
		Document document,
		String leftTitle,
		String rightTitle,
		Font rightTitleStyle,
		PdfPTable content
	) throws DocumentException {
		var theSection = new PdfPTable(new float[]{LEFT_SIDE_WIDTH, 100 - LEFT_SIDE_WIDTH});
		theSection.setWidthPercentage(95);		
		// left part
		var titleCell = cell(new Phrase(leftTitle, LEFT_TITLE_FONT));
		titleCell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
		titleCell.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
		theSection.addCell(titleCell);
		if (rightTitle != null) {
			theSection.addCell(cell(new Phrase(rightTitle, rightTitleStyle))).setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
			theSection.addCell(cell(new Phrase("")));
		}
		// Right part
		theSection.addCell(cell(content));
		theSection.setSpacingBefore(15f);
		document.add(theSection);
	}
	
	/**
	 * Creates an horizontal section with a separator.
	 * @param document Document on which to draw a section.
	 * @param title Separator section title.
	 * @throws DocumentException In case of any problem handling the PDF.
	 * @throws IOException In case of any problem with I/O operations.
	 */
	private void separatorSection(Document document, String title)
			throws DocumentException, IOException {
		var separatorTable = new PdfPTable(new float[]{100});
		separatorTable.addCell(cell(iconPhrase("separator.png", "")));
		section(document, title, separatorTable);
	}
	
	/**
	 * Creates a cell with the given text.
	 * @param phrase Text in the cell.
	 * @return Cell w/o borders.
	 */
	private PdfPCell cell(Phrase phrase) {
		var ret = new PdfPCell(phrase);
		ret.setBorder(0);
		return ret;
	}
	
	/**
	 * Creates a cell with a phrase, with the base style.
	 * @param text Content for the cell.
	 * @return Cell w/o borders.
	 */
	private PdfPCell cell(String text) {
		return cell(text, BASE_FONT);
	}
	
	/**
	 * Creates a cell with a phrase, with the given font.
	 * @param text Content for the cell.
	 * @param font Font to render text in.
	 * @return Cell w/o borders.
	 */
	private PdfPCell cell(String text, Font font) {
		var ret = new PdfPCell(new Phrase(text, font));
		ret.setBorder(0);
		return ret;
	}
	
	/**
	 * Creates a cell with the given content, in the base style.
	 * @param table Content of the cell.
	 * @return Cell w/o borders.
	 */
	private PdfPCell cell(PdfPTable table) {
		var ret = new PdfPCell(table);
		ret.setBorder(0);
		return ret;
	}
	
	/**
	 * Loads the language information into the document.
	 * @param document iText document with the resum�.
	 * @param languages List of languages known to the user.
	 * @throws DocumentException If found any problem handling the PDF.
	 * @throws IOException If found any I/O problem.
	 */
	private void paintLanguages(
		Document document,
		List<LanguageBean> languages
	) throws DocumentException, IOException {
		if (languages != null) {
			separatorSection(document, i18n("languages.title"));
            var languagesTable = new PdfPTable(new float[]{25, 25, 25, 25});
            var languagesCell = cell(i18n("languages.header"), LITTLE_BLUE_FONT);
            languagesCell.setPaddingBottom(10);
            languagesHeadersBorders(languagesCell);
            languagesTable.addCell(languagesCell);
            var conversationCell = cell(i18n("conversation.title"), LITTLE_BLUE_FONT);
            languagesHeadersBorders(conversationCell);
            languagesTable.addCell(conversationCell);
			var writingCell = cell(i18n("writing.title"), LITTLE_BLUE_FONT);
            languagesHeadersBorders(writingCell);
            languagesTable.addCell(writingCell);
			var readingCell = cell(i18n("reading.title"), LITTLE_BLUE_FONT);
            languagesHeadersBorders(readingCell);
            languagesTable.addCell(readingCell);
            for (LanguageBean language: languages) {
				var languageCell = cell(language.language());
                languagesTable.addCell(languageCell);
				var conversationLevelCell = cell(language.conversationLevel());
                languageBorders(conversationLevelCell);
                languagesTable.addCell(conversationLevelCell);
				var writingLevelCell = cell(language.writingLevel());
                languageBorders(writingLevelCell);
                languagesTable.addCell(writingLevelCell);
				var readingLevelCell = cell(language.readingLevel());
                languageBorders(readingLevelCell);
                languagesTable.addCell(readingLevelCell);
            }
            section(document, "", languagesTable);
        }
	}
	
	// Border style for languages headers
	private void languagesHeadersBorders(PdfPCell cell) {
		cell.setBorderColor(EuropassFonts.BASE_COLOR);
		cell.setBorderWidthBottom(1);
	}

	// Border style for languages data
	private void languageBorders(PdfPCell cell) {
		cell.setBorderColor(EuropassFonts.BASE_COLOR);
		cell.setBorderWidthBottom(0.5f);
	}

	/**
	 * Paints the training and certifications of the user into the document.
	 * @param document iText document with the resum�.
	 * @param education User's training and certificates.
	 * @throws DocumentException If found any problem handling the PDF.
	 * @throws IOException If found any I/O problem.
	 */
	private void paintTrainingCertifications(
		Document document,
		List<TrainingBean> education
	) throws DocumentException, IOException {
		if (education != null) {
			separatorSection(document, i18n("training.title"));
            for (var training: education.stream().sorted().toList()) {
                var title = buildTimePeriod(training.start(), training.end());
                var content = new PdfPTable(new float[]{100});
                if (isSet(training.educationPlace())) {
                    content.addCell(cell(training.educationPlace()));
                }
                if (isSet(training.description())) {
                    content.addCell(cell(training.description()));
                }
                section(
					document,
					title,
					training.title(),
                    JOB_TITLE_FONT,
					content
				);
            }
        }
	}

	/**
	 * Paints the professional experience into the document.
	 * @param document iText document with the resum�.
	 * @param professionalExperience Uers's professional experience.
	 */
	private void paintProfessionalExperience(
		Document document,
		List<WorkExperienceBean> professionalExperience
	) throws DocumentException, IOException {
		if (professionalExperience != null) {
			separatorSection(document, i18n("experience.title"));
            for (var exp: professionalExperience.stream().sorted().toList()) {
                // Section title is the time period (left side)
                var title = buildTimePeriod(exp.start(), exp.end());
                var content = new PdfPTable(new float[]{100});
                if (isSet(exp.company())) {
                    // First line of the content: company
                    content.addCell(cell(exp.company()));
                }
                if (isSet(exp.description())) {
                    // Second line of the content: description
                    content.addCell(cell(exp.description()));
                }
                section(
					document,
					title,
					exp.title(),
                    JOB_TITLE_FONT,
					content
				);
            }
        }
	}


	/**
	 * Builds the representation of a time period between two dates.
	 * @param startDate Start date.
	 * @param endDate End date.
	 * @return Renders the period as 'startMonth startYear - endMonth endYear',
	 * or else 'startMonth startYear - ${currently}' if the end date is null.
	 */
	private String buildTimePeriod(Date startDate, Date endDate) {
		var start = startDate!=null?sdf.format(startDate):"";
		var end = endDate!=null?sdf.format(endDate): i18n("misc.currently");
		var title = start;
		title += " - ";
		if (isSet(end)) {
			title += end;
		}
		return toCamelCase(title);
	}
	
	//
	//         _   _
	//        / \_/ \   __
	//       /       \_/__\
 	//      / ______ __/
	//      ||      ||
	//		||		||
	//
	//
	private String toCamelCase(final String init) {
	    if (init==null) return null;
	    var ret = new StringBuilder(init.length());
	    for (var word : init.split(" ")) {
	        if (!word.isEmpty()) {
	            ret.append(word.substring(0, 1).toUpperCase());
	            ret.append(word.substring(1).toLowerCase());
	        }
	        if (!(ret.length()==init.length())) ret.append(" ");
	    }
	    return ret.toString();
	}
	
	/**
	 * Paints the user's personal information into the document.
	 * @param document iText document with the resum�.
	 * @param personalInfo User's personal information.
	 * @throws DocumentException If found any problem handling the PDF.
	 * @throws IOException If found any I/O problem.
	 */
	private void paintPersonalInfo(
		Document document,
		PersonalInfoBean personalInfo
	) throws DocumentException, IOException {
		if (personalInfo != null) {
			// Build the table with the personal info
			var content = new PdfPTable(new float[]{100});
			if (isSet(personalInfo.address()))
				content.addCell(cell(iconPhrase("address.png", personalInfo.address())));
			if (isSet(personalInfo.homePhone()) || isSet(personalInfo.mobilePhone())) {
				var tlPhrase = new Paragraph();
				if (isSet(personalInfo.homePhone())) {
					tlPhrase.add(iconPhrase("phone.png",personalInfo.homePhone()));
					tlPhrase.add("   ");
				}
				if (isSet(personalInfo.mobilePhone())) {
					tlPhrase.add(iconPhrase("mobile.png",personalInfo.mobilePhone()));
				}	
				content.addCell(cell(tlPhrase));		
			}
			if (isSet(personalInfo.mail()))
				content.addCell(cell(iconPhrase("mail.png",personalInfo.mail())));
			if (isSet(personalInfo.getWebAddresses()))
				content.addCell(cell(iconPhrase("web.png", composeWebAddresses(personalInfo.getWebAddresses()))));
            for (String key : personalInfo.getInstantMessaging().keySet()) {
                var value = personalInfo.getInstantMessaging().get(key);
                content.addCell(cell(iconPhrase("icq.png", key + " - " + value)));
            }
            // Compose the table in the document
			section(document, i18n("personal.title"), personalInfo.name(), content);
		}
	}
	
	// Composes a list of web addresses
	private String composeWebAddresses(List<String> webAddresses) {
		var ret = new StringBuilder();
		var counter = 0;
		for (String address: webAddresses) {
			if (counter++ > 0) {
				ret.append(System.lineSeparator());
			}
			ret.append(address);
		}
		return ret.toString();
	}



	// Tells whether a string is set
	private boolean isSet(String s) {
		return s != null && !s.trim().isEmpty();
	}
	
	// Tells whether a string list is set
	private boolean isSet(List<String> s) {
		return s != null && !s.isEmpty();
	}

	/**
	 * Creates a phrase preceded by an icon.
	 * @param iconPath Icon path (inside classpath).
	 * @param phrase Phrase text.
	 * @return Icon preceded phrase.
	 * @throws DocumentException If found any problem handling the PDF.
	 * @throws IOException If found any I/O problem.
	 */
	private Phrase iconPhrase(
			String iconPath,
			String phrase
	) throws IOException, DocumentException {
		var image = ImageIO.read(new ByteArrayInputStream(imageContent(iconPath)));
		var addressImg = Image.getInstance(image, null);
		addressImg.scalePercent(45);
		var paragraph = new Paragraph();
		var addressPhrase = new Phrase();
		addressPhrase.setFont(BASE_FONT);
		paragraph.add(new Chunk(addressImg, 0, 0, true));
		addressPhrase.add("   " + phrase);
		paragraph.add(addressPhrase);
		
		return paragraph;		
	}
	
	/**
	 * Returns the binary content of an image inside the classpath
	 * @param path Image path inside the classpath.
	 * @return Byte array with the binary content of the image.
	 * @throws IOException If found any problem reading the image
	 */
	private byte[] imageContent(String path) throws IOException {
		byte[] ret = null;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		byte[] buffer = new byte[BUFFER_SIZE];
		InputStream is = 
			EuropassBuilder.class.getClassLoader().getResourceAsStream(path);
		boolean keepOn = true;
		while (keepOn) {
			int bytesRead = is.read(buffer, 0, BUFFER_SIZE);
			if (bytesRead == -1) {
				keepOn = false;
			}
			else {
				os.write(buffer, 0, bytesRead);
			}
		}
		is.close();			
		ret = os.toByteArray();
		return ret;
	}
}
