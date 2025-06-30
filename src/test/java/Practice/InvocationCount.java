package Practice;

import org.testng.annotations.Test;

public class InvocationCount 
{
	@Test
	  public void create()
	  {
		  System.out.println("create");
	  }
	  
	  @Test
	  public void modify()
	  {
		  System.out.println("modify");
	  }
	  
	  @Test(priority=1,invocationCount=3) 
	 public void delete()
	  {
		  System.out.println("delete");
	  }
}
//default invocation count=1
