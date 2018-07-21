package learning.jaggedArray;

public class JaggedArray {

	public static void main(String[] args) {
		System.out.println("Jagged Array Tutorial");
		// declare a 2-D array of type int
		// providing size of row only
		int[][] jaggedArr = new int[3][];

		// initializing each row to have different number of columns

		jaggedArr[0] = new int[] { 1 };
		jaggedArr[1] = new int[] { 2, 3 };
		jaggedArr[2] = new int[] { 4, 5, 6, 7 };

		for (int i = 0; i < jaggedArr.length; i++) {
			System.out.print("Row "+i+" with "+jaggedArr[i].length+" columns --> ");
			for (int j = 0; j < jaggedArr[i].length; j++) {
				System.out.print(jaggedArr[i][j]+" ");
			}
			System.out.println();
		}

	}

}
