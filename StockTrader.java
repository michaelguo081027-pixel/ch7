import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class StockTrader {
	//Part 1 codes
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("tiny.txt"));
        String symbol = in.next();
        int n = in.nextInt();

		int[] years = new int[n];
		int[] months = new int[n];
		double[] prices = new double[n];
		
        loadData(in, years, months, prices);
        printData(years, months, prices);
        System.out.println(symbol+" lowest: $"+prices[indexOfLowest(prices)]+
							" in "+monthName(months[indexOfLowest(prices)])+
							" "+years[indexOfLowest(prices)]);
		System.out.println(symbol+" highest: $"+prices[indexOfHighest(prices)]+
							" in "+monthName(months[indexOfHighest(prices)])+
							" "+years[indexOfHighest(prices)]);
    }
    
    public static void loadData(Scanner in, int[] years, int[] months, double[] prices){
		for(int i=0; i<years.length; i++){
			years[i] = in.nextInt();
			months[i] = in.nextInt();
			prices[i] = in.nextDouble();
		}
	}
	
	public static String monthName(int month){
		String[] mon = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", 
						"Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		return mon[month-1];
	}
	
	public static void printData(int[] years, int[] months, double[] prices){
		for(int i=0; i<years.length; i++){
			System.out.println(monthName(months[i])+" "+years[i]+": $"+prices[i]);
		}
	}
	
	/**
	 * Part 2 codes, recording, and question answers.
	 * 
	 * Recording:
	 * File Lowest price When Highest price When
	 * tiny.txt $30.00 Mar 2020 $70.00 Jul 2020
	 * rising.txt $20.0 Jan 2010 $48.14 Dec 2014
	 * falling.txt $30.36 Dec 2014 $100.0 Jan 2010
	 * zigzag.txt $35.0 Jul 2010 $65.0 Mar 2010
	 * aapl_2000_2010.txt $7.07 Mar 2003 $223.02 Mar 2010
	 * amzn_2000_2010.txt $5.97 Sep 2001 $135.91 Nov 2009
	 * msft_2000_2010.txt $15.81 Feb 2009 $43.22 Mar 2000
	 * ibm_2000_2010.txt $53.01 Sep 2002 $130.32 Dec 2000
	 * goog_2004_2010.txt $102.37 Aug 2004 $707.0 Oct 2007
	 * sbux_2007_2016.txt $4.09 Nov 2008 $62.16 Oct 2015
	 * sp500_1925_1945.txt $4.77 Jun 1932 $31.3 Sep 1929
	 * sp500_1990_2025.txt $307.12 Oct 1990 $6853.03 Dec 2025
	 * 
	 * Questions:
	 * 
	 * 1.It means the person lost approximately 63.42% of the money he 
	 *   put in from 2000 to 2010.
	 * 
	 * 2.The timing makes sense. Since Starbucks experienced financial 
	 *   crisis in 2008, it makes sense to have its lowest price in
	 *   November 2008. Similarly, since the Great Depression took place
	 *   in 1930s, it is resonable to have the lowest price in June 1932.
	 */
	
	public static int indexOfLowest(double[] prices){
		int low = 0;
		for(int i=0; i<prices.length; i++){
			if(prices[low]>prices[i]){
				low=i;
			}
		}
		return low;
	}
	
	public static int indexOfHighest(double[] prices){
		int high = 0;
		for(int i=0; i<prices.length; i++){
			if(prices[high]<prices[i]){
				high=i;
			}
		}
		return high;
	}
}
