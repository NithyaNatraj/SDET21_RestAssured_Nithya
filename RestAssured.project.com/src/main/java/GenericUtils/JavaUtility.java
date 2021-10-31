package GenericUtils;

import java.util.Random;

/**
 * This class has generic methods related java library
 * @author N.Nithya Devi
 */

public class JavaUtility {
	
	
	/**
	 * Return the random number to the caller
	 * @return
	 */

	public int getRandomNumber() {
		Random ran = new Random();
		int random = ran.nextInt(100);
		return random;
		
		
	}
}
