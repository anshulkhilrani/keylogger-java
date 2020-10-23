package keylogger;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LoggerTest {

	@Test
	void testLog() {
		Logger logger = new Logger("C:\\users\\anshul\\Downloads\\logs.txt");
		logger.log(KeyEvent.VK_ENTER);
		
	}

}
