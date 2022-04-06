package ConcurrencyAssignment;

import java.util.Random;

public class MainArray {

	public static void main(String[] args) {

		Random numRandomGenerator = new Random();
		int[] parallelArray = new int[200000000]; // array of 200 million

		for (int i = 0; i < parallelArray.length; i++) {
			parallelArray[i] = numRandomGenerator.nextInt(10) + 1; // the number generator picks from the 200 million
			
		} long start = System.currentTimeMillis();

			System.out.println("Computing Concurrency Values... Please wait...\n");
			System.out.println("Calculation has been completed... Printing out values..\n");
			
			System.out.println("Generated Number: " + ParallelArraySum.sum(parallelArray));
			System.out.println("Sum with Thread: " + (System.currentTimeMillis() - start));  

			start = System.currentTimeMillis();

			System.out.println(" ");
			System.out.println("Generated Number: " + ParallelArraySum.parallelSum(parallelArray));
			System.out.println("Sum in Parallel: " + (System.currentTimeMillis() - start));
	}
}
