/**
 * 
 */
package europass.beans;

import java.util.Date;

/**
 * Education or training item.  
 */
public class TrainingBean implements Comparable<TrainingBean> {

	//------------------------------------------------------------------
	// Bean properties
	
	/** Education start date. */
	private Date start;
	/** Education end date. */
	private Date end;
	/** Title earned. */
	private String title;
	/** Where the training took place. */
	private String educationPlace;
	/** Description. */
	private String description;
	
	//------------------------------------------------------------------
	// Bean methods
	
	/**
	 * Returns the training start date.
	 * @return The training start date.
	 */
	public Date getStartDate() {
		return start;
	}
	
	/**
	 * Sets the training start date.
	 * @param startDate The training start date.
	 */
	public void setStartDate(Date startDate) {
		this.start = startDate;
	}
	
	/**
	 * Returns the training end date.
	 * @return The training end date.
	 */
	public Date getEndDate() {
		return end;
	}
	
	/**
	 * Sets the training end date.
	 * @param endDate The training end date.
	 */
	public void setEndDate(Date endDate) {
		this.end = endDate;
	}
	
	/**
	 * Returns the title earned.
	 * @return The title earned.
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the title earned.
	 * @param title The title earned.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Returns where the training took place.
	 * @return Where the training took place.
	 */
	public String getEducationPlace() {
		return educationPlace;
	}
	
	/**
	 * Sets where the training took place.
	 * @param educationPlace Where the training took place.
	 */
	public void setEducationPlace(String educationPlace) {
		this.educationPlace = educationPlace;
	}
	
	/**
	 * Returns the training description.
	 * @return The training description.
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the training description.
	 * @param description The training description.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Builds a training item with its full information.
	 * @param startDate Training start date.
	 * @param endDate Training end date.
	 * @param title Title earned.
	 * @param formationPlace Where the training took place.
	 * @param description Description of the training.
	 */
	public TrainingBean(String formationPlace, Date startDate, Date endDate, String title, 
			String description) {
		super();
		this.start = startDate;
		this.end = endDate;
		this.title = title;
		this.educationPlace = formationPlace;
		this.description = description;
	}
	
	@Override
	public int compareTo(TrainingBean o) {
		// Ascending order on start date
		return o.getStartDate().compareTo(this.getStartDate());
	}
}
