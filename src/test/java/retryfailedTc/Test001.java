package retryfailedTc;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test001 {
	static int num=7;

	@Test(retryAnalyzer = retryfailedTc.MyRetryAnalyzer.class)
	public void Test1()
	{
		Assert.assertEquals(false, true);
	}

	@Test
	public void Test2()
	{
		Assert.assertEquals(false, true);
	}
	
	@Test(retryAnalyzer = retryfailedTc.MyRetryAnalyzer.class)
	public void Test3()
	{
		num--;
		Assert.assertTrue(num<4);//5<4 | 4<4 | 3<4
	}
}
