import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.FileOutputStream;

public abstract class BaseTest {
	protected File file = null;
	protected FileOutputStream os = null; 
	
	@BeforeEach
	public void init() {
		try {
			file = File.createTempFile("eurocv", ".pdf");
			os = new FileOutputStream(file);			
			System.out.println("Writing results to " + file.getCanonicalPath());
		}
		catch(Exception e) {
			e.printStackTrace();
			Assertions.fail();
		}
	}
	
	@AfterEach
	public void end() {
		try {
			os.close();
			// clean results
			file.delete();
		}
		catch(Exception e) {
			e.printStackTrace();
			Assertions.fail();
		}
	}
}
