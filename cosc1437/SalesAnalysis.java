import java.io.*;
import java.util.Scanner;

/**
   This program demonstrates a solution to the
   Sales Analysis programming challenge.
*/

public class SalesAnalysis
{
   public static void main(String[] args) throws IOException
   {
      String input;              // To hold a line from the file
      double total = 0.0;        // Accumulator for all weeks
      double average;            // Average weekly sales
      double weekSales;          // Total sales for a week
      double highestSales = 0.0; // Highest sales
      double lowestSales = 0.0;  // Lowest sales
      int highest = 0;           // Week # with highest sales
      int lowest = 0;            // Week # with lowest sales
      int weekNum = 0;           // The week number;

      // Open the SalesData.txt file.
      try (Scanner inputFile = new Scanner(new File("SalesData.txt")))
      {
         // Process the file contents.
         while (inputFile.hasNext())
         {
            // Read a line from the file.
            input = inputFile.nextLine();
   
            // Increment the week counter.
            weekNum++;
   
            // Get the total sales for the current week.
            weekSales = getWeeklySales(input);
   
            // Display the total sales for the current week.
            System.out.printf("Total sales for week %d: $%,.2f\n",
                              weekNum, weekSales);
   
            // Display the average for the current week.
            System.out.printf("Average daily sales for " +
                              "week %d: $%,.2f\n\n", weekNum,
                              (weekSales / 7.0));
   
            // Accumulate the weekly sales.
            total += weekSales;
   
            // Find the highest and lowest so far.
            if (weekNum == 1)
            {
               highest = 1;
               highestSales = weekSales;
               lowest = 1;
               lowestSales = weekSales;
            }
            else
            {
               if (weekSales > highestSales)
                  highest = weekNum;
               if (weekSales < lowestSales)
                  lowest = weekNum;
            }
         }
      }

      // Calculate the avereage weekly sales.
      average = total / weekNum;

      // Display the remaining results.
      System.out.printf("Total sales for all weeks: $%,.2f\n",
                        total);
      System.out.printf("Average weekly sales: $%,.2f\n\n",
                        average);
      System.out.printf("The highest sales were made during week %d.\n",
                        highest);
      System.out.printf("The lowest sales were made during week %d.\n",
                        lowest);
   }

   /**
      The getWeeklySales method accepts a string containing a
      list of sales for the week, with each day's sales
      separated by commas. It tokenizes the string, totals
      the numbers, and returns the total sales for the week.
      @param str The string containing the list of sales.
      @return The total of the sales.
   */

   public static double getWeeklySales(String str)
   {
      double total = 0.0;  // To hold the total.

      // Trim leading and trailing whitespace.
      str.trim();

      // Tokenize the string using the comma as a delimiter.
      String[] tokens = str.split(",");

      // Get the total.
      for (String s : tokens)
      {
         total += Double.parseDouble(s);
      }

      // Return the total.
      return total;
   }
}
