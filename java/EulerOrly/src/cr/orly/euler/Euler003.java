/*
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
*/

package cr.orly.euler;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Euler003
{
	private Set<Integer> primeFactors = new HashSet<>();
	
	private void calcPrimes(long n, int prime)
	{
		if ((n <= 0) || (prime > n))
		{
			return;
		}
	
		if (isDivisible(n, prime))
		{
			primeFactors.add(prime);
			
			long quotient = n / prime;
			calcPrimes(quotient, prime);
		}
		else
		{
			calcPrimes(n, prime+1);
		}
	}

	private boolean isDivisible(long n, int prime)
	{
		long remainder = (n % prime);
		return (remainder == 0);
	}

	private void calcPrimes(long n)
	{
		primeFactors = new HashSet<>();
		calcPrimes(n, 2);
	}
	
	private int getMaxPrime(long n)
	{
		calcPrimes(n);
		return Collections.max(primeFactors);
	}
	
	public static void main(String[] args)
	{
		Euler003 e = new Euler003();
		int maxPrime = e.getMaxPrime(600851475143L);
		System.out.println("The largest prime factor of 600851475143 is " + maxPrime);
	}

}
