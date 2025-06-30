package Practice;

import org.testng.annotations.Test;

public class EnableDisable 
{
	@Test
	  public void create()
	  {
		  System.out.println("create");
	  }
	  
	  @Test(enabled = false)
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
//default enable=true


