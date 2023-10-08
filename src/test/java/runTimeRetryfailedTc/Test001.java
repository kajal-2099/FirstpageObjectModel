package runTimeRetryfailedTc;

import java.io.File;

import org.testng.Assert;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class Test001{
	
	@Test
	public void Test1()
	{
		Assert.assertEquals(false, true);		
	}

	@Test
	public void Test2()
	{
		Assert.assertEquals(false, true);
	}
}
