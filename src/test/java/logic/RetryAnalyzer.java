package logic;

import org.testng.ITestResult;


public class RetryAnalyzer implements org.testng.IRetryAnalyzer 
{
	private int counter = 0;
	private static int retryLimit = 3;
	
	@Override
	public boolean retry(ITestResult result)
	{
		if(counter < retryLimit)
		{
			counter++;
			return true;
		}
		return false;
	}

}
