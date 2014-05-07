/*
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
*/

package cr.orly.euler;

public class Euler004
{

/*
a: size/2
b: (size-1) / 2;
c: (size/2) - 1;
String s1 = "hola";  //length = 4: 2, 1, 1
String s2 = "adios"; //length = 5: 2, 2, 1

String s3 = "1234554321";
String s4 = "12345654321";
length = 10; //4
length = 11; //4
*/

	public boolean isPalindrome(String param)
	{
		int size = param.length();
		int upperLimit = (size/2) - 1;
		for(int i=0; i<=upperLimit; i++)
		{
			char beginning = param.charAt(i);
			char ending = param.charAt(size-1-i);
			if (beginning != ending)
			{
				return false;
			}
		}
		return true;
	}
	
	public boolean isPalindrome(long param)
	{
		return isPalindrome(param+"");
	}
	
	public long getLargestPalindromeFromMultiplication(int lowerLimit, int upperLimit)
	{
		long largest = -1;
		for(int i=upperLimit; i>lowerLimit; i--)
		{
			for(int j=upperLimit; j>lowerLimit; j--)
			{
				long mult = i*j;
				if ((mult > largest) && isPalindrome(mult))
				{
					largest = mult;
					System.out.println(i + "*" + j + "=" + largest);
				}
			}
		}
		return largest;
	}
	
	public static void main(String... args)
	{
		Euler004 e = new Euler004();
		long largest = e.getLargestPalindromeFromMultiplication(100, 999);
		System.out.println("The largest palindrome made from the product of two 3-digit numbers is " + largest);
	}

}