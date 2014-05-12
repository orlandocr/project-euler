/*
Counting Sundays
Problem 19
You are given the following information, but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
*/

package cr.orly.euler;

import java.util.Date;

@SuppressWarnings("deprecation") //Calendar's API is a bit harder to remember
public class Euler019
{

    private int getYear(Date d)
    {
        return 1900 + d.getYear();
    }
    
    private void setYear(int year, Date d)
    {
        d.setYear(year - 1900);
    }

    private Date getFirstDayOfYear(int year)
    {
        Date d = new Date();
        setYear(year, d);
        d.setMonth(0);
        d.setDate(1);
        d.setHours(1);
        d.setMinutes(1);
        return d;
    }

    private boolean isSunday(Date d)
    {
        return (0 == d.getDay());
    }

    private void addMonths(int numberOfMonths, Date d)
    {
        int currentNumberOfMonths = d.getMonth();
        d.setMonth(numberOfMonths + currentNumberOfMonths);
    }
    
    private int countSundaysOnFirstOfMonth(int yearIni, int yearEnd)
    {
        assert(yearIni <= yearEnd);
    
        int totalSundaysOnFirstOfMonth = 0;
        
        Date d = getFirstDayOfYear(yearIni);
        do
        {
            if (isSunday(d))
            {
                totalSundaysOnFirstOfMonth++;
            }
            addMonths(1, d);
        } while (getYear(d) <= yearEnd);
        
        return totalSundaysOnFirstOfMonth;
    }

    public static void main(String... args)
    {
        Euler019 e = new Euler019();
        int totalSundaysOnFirstOfMonth = e.countSundaysOnFirstOfMonth(1901, 2000);
        System.out.println("The number of Sundays that fell on the first of the month during the twentieth century is " + totalSundaysOnFirstOfMonth);
    }
    
}
