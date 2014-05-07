/*
Double-base palindromes
Problem 36
The decimal number, 585 = 1001001001(binary), is palindromic in both bases.

Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

(Please note that the palindromic number, in either base, may not include leading zeros.)
*/

package cr.orly.euler;

public class Euler036
{

    private boolean isPalindrome(String value)
    {
        int size = value.length();
        char[] chars = value.toCharArray();
        for(int i=0; i<(size/2); i++)
        {
            char charAtBegin = chars[i];
            char charAtEnd = chars[size-1-i];
            if (charAtBegin != charAtEnd)
            {
                return false;
            }
        }

        return true;
    }
    
    private boolean isPalindrome(int n) {
        return isPalindrome(""+n);
    }

    private String toBinary(int numberInBaseTen)
    {
        //Post-mortem:
        //return Integer.toBinaryString(numberInBaseTen);
        assert(numberInBaseTen>=0): "toBinary() needs a positive number, got " + numberInBaseTen;
        
        StringBuilder s = new StringBuilder();
        int n = numberInBaseTen;

        do
        {
            int bit = n % 2;
            s.append(bit);
            n = n/2; //SHR
        }
        while(n>1);

        if (n==1)
        {
            s.append(1);
        }

        String numberInBaseTwo = s.reverse().toString();
        return numberInBaseTwo;
    }
    
    private boolean isDoubleBasePalindrome(int n)
    {
        return isPalindrome(n) && isPalindrome(toBinary(n));
    }

    private long findTotalUnder(int max)
    {
        long total = 0;
        for (int i=1; i<max-1; i++)
        {
            if (isDoubleBasePalindrome(i))
            {
                total+=i;
                //System.out.println(i + " " + toBinary(i));
            }
        }
        return total;
    }
    
    public static void main(String... args)
    {
        Euler036 e = new Euler036();
        long total = e.findTotalUnder(1000000);
        System.out.println("Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2 is " + total);
        /*for (int i=0; i<101; i++)
        {
            System.out.println(i + " " + e.toBinary(i));
        }*/
    }

}
