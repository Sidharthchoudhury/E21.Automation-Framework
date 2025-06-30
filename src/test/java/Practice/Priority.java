package Practice;

import org.testng.annotations.Test;

public class Priority 
{
	@Test(priority=3)
	  public void create()
	  {
		  System.out.println("create");
	  }
	  
	  @Test(priority=1)
	  public void modify()
	  {
		  System.out.println("modify");
	  }
	  
	  @Test(priority=2)
	  public void delete()
	  {
		  System.out.println("delete");
	  }
}
//default priority=0
