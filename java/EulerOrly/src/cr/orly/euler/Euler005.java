/*
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
*/

package cr.orly.euler;

public class Euler005
{
	public boolean isEvenlyDivisibleUpTo(long n, int upperLimit)
	{
		for (int divisor = 1; divisor <= upperLimit; divisor++)
		{
			long remainder = (n % divisor);
			if (remainder != 0)
			{
				return false;
			}
		}
		return true;
	}
	
	public long findSmallestDivisible(int upperLimit, int startWith)
	{
		for (long i=startWith; i<Long.MAX_VALUE; i++)
		{
			if (isEvenlyDivisibleUpTo(i, upperLimit))
			{
				return i;
			}
		}
		return Long.MIN_VALUE;
	}
	
	public static void main(String... args)
	{
		Euler005 e = new Euler005();
		long smallest = e.findSmallestDivisible(20, 2520*20);
		System.out.println("The smallest positive number that is evenly divisible by all of the numbers from 1 to 20 is " + smallest);
	}

}
