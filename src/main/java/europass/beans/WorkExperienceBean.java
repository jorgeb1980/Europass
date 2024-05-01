package europass.beans;

import java.util.Date;

/**
 * Professional experience item.  
 */
public record WorkExperienceBean (
	/* Company. */
	String company,
	/* Start date. */
	Date start,
	/* End date. */
	Date end,
	/* Job title. */
	String title,
	/* Description. */
	String description
) implements Comparable<WorkExperienceBean> {
	@Override
	public int compareTo(WorkExperienceBean o) {
		// Ascending start date order
		return o.start.compareTo(this.start);
	}
}
