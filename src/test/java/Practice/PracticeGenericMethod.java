package Practice;

public class PracticeGenericMethod 
{
	public static void main(String[] args)
	{
		int sum=add(20,10); 
		System.out.println(sum);
		System.out.println(add(30,sum));

		int sub=subtraction(50,30);
		System.out.println(sub);

		int mul=multiplication(10,20);
		System.out.println(mul);

		int div=division(15,5);
		System.out.println(div);

	}
	//addition
	public static int add(int a,int b)
	{
		int c=a+b;
		return c;
	}
	//subtraction
	public static int subtraction(int y,int z) 
	{
		int x=y-z;
		return x;

	}
	//multiplication
	public static int multiplication(int d,int e) 
	{
		int f=d*e;
		return f;

	}
	//division
	public static int division(int g,int h) 
	{
		int i=g/h;
		return i;

	}
} 
