package Practice;

import org.testng.annotations.Test;

public class DependsOnMehod 
{
	@Test
	  public void create()
	  {
		  //Assert.fail();----->modify method will be skipped   and output--->delete
		  System.out.println("create");
	  }
	  
	  @Test(dependsOnMethods = "create")
	  public void modify()
	  {
		  System.out.println("modify");
	  }
	  
	  @Test
	  public void delete()
	  {
		  System.out.println("delete");
	  }
}
