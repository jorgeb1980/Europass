import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;

import europass.beans.EducationBean;
import europass.beans.ExperienceBean;
import europass.beans.LanguageBean;
import europass.beans.LanguagesBean;
import europass.beans.PersonalInfoBean;
import europass.beans.ProfessionalExperienceBean;
import europass.beans.ResumeBean;
import europass.beans.TrainingBean;
import europass.core.EuropassException;

public class ResumeData {
	public ResumeBean buildInfo() throws EuropassException {
		ResumeBean ret = new ResumeBean();
		PersonalInfoBean personal = new PersonalInfoBean();
		ret.setInfoPersonal(personal);
		
		personal.setName("Conan of Cimmeria");
		personal.setAdress("Aquilonia Royal Palace");
		personal.setHomePhone("123456789");
		personal.setMobilePhone("777888999");
		personal.setMail("conan@aquilonia.gov");
		personal.addInstantMessaging("ICQ", "conanxxxx0r");
		personal.addInstantMessaging("Skype", "amra");
		personal.addWeb("www.aquilonia.gov");
		personal.addWeb("www.crom.com");
		
		ProfessionalExperienceBean exp = new ProfessionalExperienceBean();
		exp.addExperience(
			new ExperienceBean(
				"Self employed", 
				buildDate("25/05/1970"),
				buildDate("11/02/1973"),
				"Mercenary / Thief",
				"Asgard and Hyperborea campaign, raiding of the Tower of the Elephant"));
		exp.addExperience(
			new ExperienceBean(
				"Tigress", 
				buildDate("11/02/1973"),
				buildDate("15/11/1975"),
				"First Mate",
				"Raiding the entire Black Coast under cpt. Bêlit's command"));
		exp.addExperience(
			new ExperienceBean(
				"Turtle Islands", 
				buildDate("18/11/1982"),
				buildDate("02/03/1986"),
				"Pirate / First Mate / Boat Captain",
				"Boarding of Argus and Zingarian vessels"));
		exp.addExperience(
			new ExperienceBean(
				"Aquilonia", 
				buildDate("03/12/2013"),
				buildDate("15/03/2015"),
				"Royal Guard Captain",
				"Mercenary captain, Royal Guard Captain, army general"));
		exp.addExperience(
			new ExperienceBean(
				"Aquilonia", 
				buildDate("15/03/2015"),
				null,
				"King",
				"Administration of the State"));
		
		ret.setProfessionalExperience(exp);
		
		EducationBean edu = new EducationBean();
		edu.addTraining(new TrainingBean(
				"Conan's father",
				buildDate("01/01/1965"),
				buildDate("25/05/1970"),
				"Better save yourself or go to hell",
				"Learnt on his father's knees"
				));
		edu.addTraining(new TrainingBean(
				"Aquilonia military academy",
				buildDate("01/09/2014"),
				buildDate("15/12/2014"),
				"Major Staff Course",
				"Aquilonian military formation"
				));
		ret.setEducacionFormacion(edu);
		
		LanguagesBean languages = new LanguagesBean();
		languages.addLanguage(new LanguageBean("Kushite", "Low", "Low", "Low"));
		languages.addLanguage(new LanguageBean("Aquilonian", "High", "Low", "Low"));
		languages.addLanguage(new LanguageBean("Cimmerian", "Native", "Low", "Low"));
		
		ret.setLanguages(languages);
		
		return ret;
	}

	private Date buildDate(String s) {
		Date ret = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			ret = sdf.parse(s);
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		return ret;
	}
}
