package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice
{
	@Test(dataProvider="customerInfo")
	public void createCustomer(String name,int id)
	{
		//run multiple times with different data
		//multiple customer in single execution
		System.out.println("the customer name is--->"+name);
		System.out.println("the customer id is--->"+id);

	}

	@DataProvider(name="customerInfo")
	public Object[][] getData()           //row and columns
	{
		Object[][] data=new Object[4][2];  //4 set of data and each set has 2 input

		//first data
		data[0][0]="Alex";
		data[0][1]=10;

		//second data
		data[1][0]="Blake";
		data[1][1]=20;

		//third data
		data[2][0]="Steve";
		data[2][1]=30;

		// fourth data
		data[3][0]="Ford";
		data[3][1]=40;

		return data;

	}
}
