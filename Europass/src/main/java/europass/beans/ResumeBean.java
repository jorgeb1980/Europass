package europass.beans;

import java.util.LinkedList;
import java.util.List;

/**
 * Contains the entire resumé information.
 */
public class ResumeBean {
	
	//---------------------------------------------------
	// Bean properties
	
	/** Personal information. */
	private PersonalInfoBean personalInfo;
	/** Professsional experience. */
	private List<WorkExperienceBean> workExperience;
	/** Certifications and training. */
	private List<TrainingBean> trainings;
	/** User's languages. */
	private List<LanguageBean> languages;
	
	//---------------------------------------------------
	// Bean methods

	/**
	 * Creates an empty resumé.
	 */
	public ResumeBean() {
		trainings = new LinkedList<>();
		languages = new LinkedList<>();
		workExperience = new LinkedList<>();
	}
	
	/**
	 * Adds a specific training to the list.
	 * @param bean Training to add.
	 */
	public void addTraining(TrainingBean bean) {
		trainings.add(bean);
	}
	
	/**
	 * Adds a language skill to the list.
	 * @param language Language skill
	 */
	public void addLanguage(LanguageBean language) {
		languages.add(language);
	}
	
	/**
	 * Adds an experience item.
	 * @param bean Experience item.
	 */
	public void addExperience(WorkExperienceBean bean) {
		workExperience.add(bean);
	}
	
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
	public List<WorkExperienceBean> getProfessionalExperience() {
		return workExperience;
	}

	/**
	 * Returns the user's training and education.
	 * @return User's training and education.
	 */
	public List<TrainingBean> getTrainings() {
		return trainings;
	}

	/**
	 * Retuns the user's languages.
	 * @return User's languages.
	 */
	public List<LanguageBean> getLanguages() {
		return languages;
	}
}
