package europass.beans;

/**
 * Contains the entire resumé information.
 */
public class ResumeBean {
	
	//---------------------------------------------------
	// Bean properties
	
	/** Personal information. */
	private PersonalInfoBean personalInfo;
	/** Professsional experience. */
	private ProfessionalExperienceBean expProfesional;
	/** Certifications and training. */
	private EducationBean education;
	/** User's languages. */
	private LanguagesBean languages;
	
	//---------------------------------------------------
	// Bean methods

	/**
	 * Returns the user's personal information.
	 * @return User's personal information.
	 */
	public PersonalInfoBean getPersonalInfo() {
		return personalInfo;
	}

	/**
	 * Sets the user's personal information.
	 * @param personalInfo User's personal information.
	 */
	public void setInfoPersonal(PersonalInfoBean personalInfo) {
		this.personalInfo = personalInfo;
	}

	/**
	 * Returns the user's professional experience.
	 * @return User's professional experience.
	 */
	public ProfessionalExperienceBean getProfessionalExperience() {
		return expProfesional;
	}

	/**
	 * Sets the user's professional experience.
	 * @param professionalExp User's professional experience
	 */
	public void setProfessionalExperience(ProfessionalExperienceBean professionalExp) {
		this.expProfesional = professionalExp;
	}

	/**
	 * Returns the user's training and education.
	 * @return User's training and education.
	 */
	public EducationBean getEducation() {
		return education;
	}

	/**
	 * Sets the user's training and education.
	 * @param education User's training and education.
	 */
	public void setEducacionFormacion(EducationBean education) {
		this.education = education;
	}

	/**
	 * Retuns the user's languages.
	 * @return User's languages.
	 */
	public LanguagesBean getLanguages() {
		return languages;
	}

	/**
	 * Sets the user's languages.
	 * @param languages User's languages.
	 */
	public void setLanguages(LanguagesBean languages) {
		this.languages = languages;
	}	
}
