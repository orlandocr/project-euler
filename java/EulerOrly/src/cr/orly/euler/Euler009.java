/*
Special Pythagorean triplet
Problem 9
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a^2 + b^2 = c^2
For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
*/

package cr.orly.euler;

public class Euler009
{

    private boolean isPitagoreanTriplet(int a, int b, int c)
    {
        int aa_plus_bb = (a*a) + (b*b);
        int cc = c*c;
        
        return (aa_plus_bb == cc);
    }
    
    private boolean sumThousand(int a, int b, int c)
    {
        int total = a+b+c;
        return (1000 == total);
    }
    
    private boolean isSolution(int a, int b, int c)
    {
        return (sumThousand(a, b, c) && isPitagoreanTriplet(a, b, c));
    }
    
    private void solutionFound(int a, int b, int c)
    {
        int mult = a*b*c;
        System.out.println("The product abc of the Pythagorean triplet for which a + b + c = 1000 is " + mult);
        System.out.println("(" + a + "," + b + "," + c + ")");
        System.exit(0);
    }

    private void findPitagoreanTriplet(int upperLimit)
    {
        for (int a = 0; a < upperLimit; a++)
        {
            for (int b = a+1; b < upperLimit; b++)
            {
                for (int c = b+1; c < upperLimit; c++)
                {
                    if (isSolution(a, b, c))
                    {
                        solutionFound(a, b, c);
                    }
                }
            }
        }

        System.err.println("Solution not found with an upper limit of " + upperLimit);
    }

    public static void main(String... args)
    {
        Euler009 e = new Euler009();
        e.findPitagoreanTriplet(1000);
    }

}
