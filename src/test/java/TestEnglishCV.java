import europass.beans.ResumeBean;
import europass.core.EuropassBuilder;
import europass.core.EuropassException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class TestEnglishCV extends BaseTest {
	@Test
	public void testCV() {
		
		try {		
			ResumeBean info = new ResumeData().buildInfo();		
			new EuropassBuilder(new Locale("en")).buildCV(info, os);			
		}
		catch (EuropassException e) {
			e.printStackTrace();
			Assertions.fail();
		}
	}
}
