/**
 * 
 */
package europass.beans;

import java.util.Date;

public record TrainingBean  (
	/* Education start date. */
	Date start,
	/* Education end date. */
	Date end,
	/* Title earned. */
	String title,
	/* Where the training took place. */
	String educationPlace,
	/* Description. */
	String description
) implements Comparable<TrainingBean> {
	@Override
	public int compareTo(TrainingBean o) {
		// Ascending order on start date
		return o.start.compareTo(this.start);
	}
}
