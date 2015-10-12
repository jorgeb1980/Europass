package europass.beans;

import java.util.Date;

/**
 * Professional experience item.  
 */
public class ExperienceBean implements Comparable<ExperienceBean> {

	//--------------------------------------------------------
	// Bean properties
	
	/** Company. */
	private String company;
	/** Start date. */
	private Date start;
	/** End date. */
	private Date end;
	/** Job title. */
	private String title;
	/** Description. */
	private String description;
	
	//--------------------------------------------------------
	// Bean methods
	
	/**
	 * Returns the company name.
	 * @return Company name.
	 */
	public String getCompany() {
		return company;
	}
	
	/**
	 * Sets the company name.
	 * @param company Company name.
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	
	/**
	 * Returns the experience start date.
	 * @return Experience start date.
	 */
	public Date getStartDate() {
		return start;
	}
	
	/**
	 * Sets the experience start date.
	 * @param startDate Experience start date.
	 */
	public void setStartDate(Date startDate) {
		this.start = startDate;
	}
	
	/**
	 * Returns the experience start date.
	 * @return Experience end date.
	 */
	public Date getEndDate() {
		return end;
	}
	
	/**
	 * Sets the wxperience start date.
	 * @param endDate Experience start date.
	 */
	public void setEndDate(Date endDate) {
		this.end = endDate;
	}
	
	/**
	 * Returns the job title.
	 * @return The job title.
	 */
	public String getJobTitle() {
		return title;
	}
	
	/**
	 * Sets the job title.
	 * @param jobTitle The job title.
	 */
	public void setJobTitle(String jobTitle) {
		this.title = jobTitle;
	}
	
	/**
	 * Returns the job description.
	 * @return Job description.
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the job description.
	 * @param description Job description.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Builds an experience item with its full information.
	 * @param company Company name.
	 * @param startDate Experience start date.
	 * @param endDate Experience end date.
	 * @param jobTitle Job title.
	 * @param description Job experience description.
	 */
	public ExperienceBean(String company, Date startDate, Date endDate,
			String jobTitle, String description) {
		super();
		this.company = company;
		this.start = startDate;
		this.end = endDate;
		this.title = jobTitle;
		this.description = description;
	}
	
	@Override
	public int compareTo(ExperienceBean o) {
		// Ascending start date order
		return o.getStartDate().compareTo(this.getStartDate());
	}
}
