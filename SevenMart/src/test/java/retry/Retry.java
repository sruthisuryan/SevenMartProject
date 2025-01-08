package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
///for reexecute testcases and applied in testcases
public class Retry implements IRetryAnalyzer {
	int counter = 0;
	int retryLimit = 2;

	public boolean retry(ITestResult result) {

		if (counter < retryLimit) {
			counter++;
			return true;
		}
		return false;
	}

}
