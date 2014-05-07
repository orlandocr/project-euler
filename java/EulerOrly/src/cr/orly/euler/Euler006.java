/*
The sum of the squares of the first ten natural numbers is,
1^2 + 2^2 + ... + 10^2 = 385

The square of the sum of the first ten natural numbers is,
(1 + 2 + ... + 10)^2 = 55^2 = 3025

Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025-385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
*/

package cr.orly.euler;

public class Euler006
{
	private long square(long n)
	{
		double d = Math.pow(n, 2);
		return (long)d;
	}

	private long sumSquaresUpTo(int upperLimit)
	{
		long result = 0;
		for(int i=0; i<=upperLimit; i++)
		{
			long square = square(i);
			result += square;
		}
		return result;
	}

	private long squareOfSumUpTo(int upperLimit)
	{
		long total = 0;
		for(int i=0; i<=upperLimit; i++)
		{
			total += i;
		}
		long square = square(total);
		return square;
	}
	
	private long difference(int upperLimit)
	{
		long sumSquares = sumSquaresUpTo(upperLimit);
		long squareOfSum = squareOfSumUpTo(upperLimit);
		long result = squareOfSum - sumSquares;
		return result;
	}
	
	public static void main(String... args)
	{
		Euler006 e = new Euler006();
		long diff = e.difference(100);
		System.out.println("The difference between the sum of the squares of the first one hundred natural numbers and the square of the sum is " + diff);
	}
	
}
