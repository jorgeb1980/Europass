import europass.beans.*;
import europass.core.EuropassException;
import org.junit.jupiter.api.Assertions;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

public class ResumeData {
	public ResumeBean buildInfo() throws EuropassException {
		var personal = new PersonalInfoBean(
			"Conan of Cimmeria",
			"Aquilonia Royal Palace",
			"123456789",
			"777888999",
			"conan@aquilonia.gov",
			Arrays.asList("www.aquilonia.gov", "www.crom.com"),
			Map.of(
				"ICQ", "conanxxxx0r",
				"Skype", "amra"
			)
		);
		ResumeBean ret = new ResumeBean(
			personal,
			Arrays.asList(
				new WorkExperienceBean(
					"Self employed",
					buildDate("25/05/1970"),
					buildDate("11/02/1973"),
					"Mercenary / Thief",
					"Asgard and Hyperborea campaign, raiding of the Tower of the Elephant"
				),
				new WorkExperienceBean(
					"Tigress",
					buildDate("11/02/1973"),
					buildDate("15/11/1975"),
					"First Mate",
					"Raiding the entire Black Coast under cpt. Bêlit's command"
				),
				new WorkExperienceBean(
					"Turtle Islands",
					buildDate("18/11/1982"),
					buildDate("02/03/1986"),
					"Pirate / First Mate / Boat Captain",
					"Boarding of Argus and Zingarian vessels"
				),
				new WorkExperienceBean(
					"Aquilonia",
					buildDate("03/12/2013"),
					buildDate("15/03/2015"),
					"Royal Guard Captain",
					"Mercenary captain, Royal Guard Captain, army general"
				),
				new WorkExperienceBean(
					"Aquilonia",
					buildDate("15/03/2015"),
					null,
					"King",
					"Head of the State"
				)
			),
			Arrays.asList(
				new TrainingBean(
					buildDate("01/01/1965"),
					buildDate("25/05/1970"),
					"Conan's father",
					"Better save yourself or go to hell",
					"Learnt on his father's knees"
				),
				new TrainingBean(
					buildDate("01/09/2014"),
					buildDate("15/12/2014"),
					"Aquilonia military academy",
					"Major Staff Course",
					"Aquilonian military formation"
				)
			),
			Arrays.asList(
				new LanguageBean("Kushite", "Low", "Low", "Low"),
				new LanguageBean("Aquilonian", "High", "Low", "Low"),
				new LanguageBean("Cimmerian", "Native", "Low", "Low")
			)
		);
		return ret;
	}

	private Date buildDate(String s) {
		Date ret = null;
		try {
			var sdf = new SimpleDateFormat("dd/MM/yyyy");
			ret = sdf.parse(s);
		}
		catch(Exception e) {
			e.printStackTrace();
			Assertions.fail();
		}
		return ret;
	}
}
