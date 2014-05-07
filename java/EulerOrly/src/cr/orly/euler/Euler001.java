/*
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.
*/

package cr.orly.euler;

public class Euler001
{

	private int sumAllMultiplesOf3Or5Under(int upperLimit)
	{
		int total = 0;
		for(int i=0; i<upperLimit; i++)
		{
			if (isMultipleOf3(i) || isMultipleOf5(i))
			{
				total += i;
			}
		}
		return total;
	}

	private boolean isMultipleOf(int check, int isMultipleOfThis)
	{
		int quotient = (check % isMultipleOfThis);
		return (quotient == 0);
	}
	
	private boolean isMultipleOf3(int check)
	{
		return isMultipleOf(check, 3);
	}
	
	private boolean isMultipleOf5(int check)
	{
		return isMultipleOf(check, 5);
	}

	public static void main(String... args)
	{
		Euler001 e = new Euler001();
		int upperLimit = 1000;
		int sum = e.sumAllMultiplesOf3Or5Under(upperLimit);
		System.out.println("The sum of all the multiples of 3 or 5 below 1000 is: " + sum);
	}

}
