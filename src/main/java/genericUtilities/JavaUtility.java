package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class consists of generic methods related to specific
 * @author sidharth 
 */
public class JavaUtility
{
	/**
	 * This method will capture the current system date and return it to caller
	 * @return Date
	 */
	public String getSystemDate()
	{
		Date d=new Date();
		SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String date=s.format(d);
		return date;

	}
}
