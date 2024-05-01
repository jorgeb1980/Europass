import europass.beans.ResumeBean;
import europass.core.EuropassBuilder;
import europass.core.EuropassException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDefaultCV extends BaseTest {

	
	
	@Test
	public void testCV() {
		
		try {		
			ResumeBean info = new ResumeData().buildInfo();		
			new EuropassBuilder().buildCV(info, os);			
		}
		catch (EuropassException e) {
			e.printStackTrace();
			Assertions.fail();
		}
	}

	
}
