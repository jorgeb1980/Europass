
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

import europass.beans.ResumeBean;
import europass.core.EuropassBuilder;
import europass.core.EuropassException;
	
public class TestEnglishCV extends BaseTest {
	@Test
	public void testCV() {
		
		try {		
			ResumeBean info = new ResumeData().buildInfo();		
			new EuropassBuilder(new Locale("en")).buildCV(info, os);			
		}
		catch (EuropassException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
