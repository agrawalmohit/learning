package practice;

import java.util.Scanner;

public class FindPerfectSquare {

	public static void main(String[] args) {
		String endsWith_0 = "0";
		String endsWith_1 = "1,9";
		String endsWith_4 = "2,8";
		String endsWith_5 = "5";
		String endsWith_6 = "4,6";
		String endsWith_9 = "3,7";
		String count = "0";
		String num;
		try (Scanner sc = new Scanner(System.in)) {
			count = sc.nextLine();
			num = sc.nextLine();
		}
		System.out.println(num);
		/*
		 * int size = count+(count-1); String minValCand = ""; String maxValCand = "";
		 * 
		 * for(int i = 0; i<num.length; i++){ minValCand = minValCand+num[i]+"0";
		 * maxValCand = maxValCand+num[i]+"9"; }
		 * 
		 * System.out.println(minValCand); int minVal =
		 * Integer.parseInt(minValCand.substring(0,size)); int maxVal =
		 * Integer.parseInt(maxValCand.substring(0,size)); System.out.println(minVal);
		 * System.out.println(maxVal);
		 */
	}
}
