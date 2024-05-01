package europass.beans;

import java.util.List;

/**
 * Contains the entire resumé information.
 */
public record ResumeBean (
	/* Personal information. */
	PersonalInfoBean personalInfo,
	/* Professional experience. */
	List<WorkExperienceBean> workExperience,
	/* Certifications and training. */
	List<TrainingBean> trainings,
	/* User's languages. */
	List<LanguageBean> languages
) { }