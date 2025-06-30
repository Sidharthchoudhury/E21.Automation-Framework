package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertPractice 
{
  @Test
//  public void sampleHard()
//  {
//	  System.out.println("step 1");
//	  System.out.println("step 2");
//	  System.out.println("step 3");
//	  
//	  Assert.assertEquals(0,1);
//	  
//	  System.out.println("step 4");
//	  System.out.println("step 5");

  public void sampleSoft()
  {
	  SoftAssert sa=new SoftAssert();
	  
	  System.out.println("step 1");
	  System.out.println("step 2");
	  System.out.println("step 3");
	  
	  sa.assertEquals(0,1);
	  
	  System.out.println("step 4");
	  System.out.println("step 5");
	  
	  sa.assertAll();
  }
}
