import org.junit.Test;

import europass.beans.ResumeBean;
import europass.core.EuropassBuilder;
import europass.core.EuropassException;

public class TestDefaultCV extends BaseTest {

	
	
	@Test
	public void testCV() {
		
		try {		
			ResumeBean info = new ResumeData().buildInfo();		
			new EuropassBuilder().buildCV(info, os);			
		}
		catch (EuropassException e) {
			e.printStackTrace();
		}
	}

	
}
