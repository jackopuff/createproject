package planner.controller;
import java.util.Scanner;

public class PlannerController
{
	
	private Scanner input;
	public PlannerController()
	{
		input = new Scanner(System.in);
	}
	
public void start() 
{
System.out.println("Please Enter a Month(1-12):");
int userInput = input.nextInt(); //getting an integer

System.out.println("Please Enter a Year:");

int year = input.nextInt();

//Created Boolean for leap year

boolean leapYear;

//leap year rule for every 4th year

if(year %4 == 0) {

leapYear = true;

}

else {

leapYear = false;

}

//leap year rule for every 100th year but not the 400th

if(year %100 == 0) {

if(year %400 != 0) {

leapYear = false;

}

}

//Months of the year and their corresponding day amounts(Arrays.

String[] month ={

"monthZero", "January", "February", "March", "April", "May", "June", "July", "August",

"September", "October", "November", "December"

};

//Calculates number of days since 1584

int numYears = year-1584; //number of years since 1584

int yearDays = numYears*365;

//int numleapYears = 1+((int)(numYears/4)); //calculates number of leap years since 1584

int leapDays = numYears/4;

leapDays -= (int)(numYears/100);

leapDays += (int)(numYears/400);

/*int z = 2; //calculations were 3 days off

if (leapYear = true) //if leapYear, add 1 to the amount of days in a year

z++;

if(year >= 2000)

numleapYears +=1;

numleapYears -= (int)(year/1000)-1;

*/

//numYear algorithm calculates the starting day of the year

//int array for amount of days in a year, not including February leapYears

int[] numDays ={

(yearDays+leapDays+1)%7, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31

};

if(leapYear)

numDays[0] = (yearDays+leapDays)%7;

//LEAP YEAR if statement to extend February days to 29 if leapYear = true

if (year % 100 == 0) {

//if a year is divisible by 100 but not 400 it is not a leap year

if (year % 400 == 0) {

numDays[2] = 29;

}

} else if (year % 4 == 0) {

numDays[2] = 29;

}

//making it so numbers will not exceed Saturday place holder

int startMonth = 0;

for(int i=0; i <userInput; i++) {

startMonth += numDays[i];

startMonth = startMonth%7;

}

/****************************************************************************************************

* Format and Spacing for the output/Calendar

*

******************************************************************************************************/

//prints out month and year as well as days of week

System.out.println(month[userInput] + " " + year +"\n\nS M T W T F S");

//for statement formating for when first day is not a Sunday

for(int i = 0; i < startMonth; i++)
{

System.out.print(" ");
}


//for statement that allows for the formating of the days

for (int i=1; i <=numDays[userInput]; i++)
{
System.out.print(i+" ");

//this adds an extra space if the number is 1-9

if(i<10)
{
System.out.print(" ");
}
//if statement for creating a new line every 7 days

if ((i+startMonth)%7 == 0)
{
System.out.print("\n");
}
}

//following line prints the month and days in the month

}
}