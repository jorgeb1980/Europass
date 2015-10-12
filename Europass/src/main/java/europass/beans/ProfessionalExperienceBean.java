package europass.beans;

import java.util.LinkedList;
import java.util.List;

/**
 * Information about the full professional experience of a user.  
 * 
 */
public class ProfessionalExperienceBean {

	//--------------------------------------------------------
	// Bean properties
	
	/** List of experience items. */
	private List<ExperienceBean> experiences;
	
	//--------------------------------------------------------
	// Bean methods
	
	/** Empty constructor. */
	public ProfessionalExperienceBean() {
		experiences = new LinkedList<ExperienceBean>();
	}

	/**
	 * Returns the list of experience items of this bean.
	 * @return Professional experience items.
	 */
	public List<ExperienceBean> getExperiences() {
		List<ExperienceBean> defensiveCopy = new LinkedList<>();
		defensiveCopy.addAll(experiences);
		return defensiveCopy;		
	}

	/**
	 * Adds an experience item.
	 * @param bean Experience item.
	 */
	public void addExperience(ExperienceBean bean) {
		experiences.add(bean);
	}
	
}
