package europass.beans;

import java.util.LinkedList;
import java.util.List;

/**
 * Information on a particular training or education item.  
 */
public class EducationBean {

	//--------------------------------------------------
	// Bean properties
	
	/** Training received by the user. */
	private List<TrainingBean> trainings;

	
	//--------------------------------------------------
	// Bean methods
	
	/** Empty constructor. */
	public EducationBean() {
		trainings = new LinkedList<TrainingBean>();
	}
	
	/**
	 * Returns the trainings received by the user.
	 * @return User's trainings.
	 */
	public List<TrainingBean> getTrainings() {
		List<TrainingBean> defensiveCopy = new LinkedList<>();
		defensiveCopy.addAll(trainings);
		return defensiveCopy;
	}
	
	/**
	 * Adds a specific training to the list.
	 * @param bean Training to add.
	 */
	public void addTraining(TrainingBean bean) {
		trainings.add(bean);
	}
}
