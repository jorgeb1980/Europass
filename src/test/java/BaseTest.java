import java.io.File;
import java.io.FileOutputStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

public abstract class BaseTest {
	protected File file = null;
	protected FileOutputStream os = null; 
	
	@Before
	public void init() {
		try {
			file = File.createTempFile("eurocv", ".pdf");
			os = new FileOutputStream(file);			
			System.out.println("Writing results to " + file.getCanonicalPath());
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@After
	public void end() {
		try {
			os.close();
			// clean results
			file.delete();
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
