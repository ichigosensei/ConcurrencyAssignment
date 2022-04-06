package ConcurrencyAssignment;

class ParallelArraySum extends Thread { //class extends thread
	
	// creating the variables
	private int[] parallelArray;
	private int numOne, numTwo, parArrSum; 

public ParallelArraySum(int[] parallelArray, int numArray, int arrayNum) {
	
	this.parallelArray = parallelArray;
	this.numOne = numArray;
	this.numTwo = Math.min(arrayNum, parallelArray.length);

}

public int getArraySum() {

	return parArrSum;

}

	public void run() { // runs the getArraySum to get the values of the numbers in the array

		parArrSum = sum(parallelArray, numOne, numTwo);

}

public static int sum(int[] parallelArray) {

	return sum(parallelArray, 0, parallelArray.length);

}

public static int sum(int[] parallelArray, int numOne, int numTwo) {

	int allNum = 0;

	for (int i = numOne; i < numTwo; i++) {
		allNum += parallelArray[i];

	} return allNum;

}

public static int parallelSum(int[] parallelArray) {

	return parallelSum(parallelArray, Runtime.getRuntime().availableProcessors());

}

public static int parallelSum(int[] parallelArray, int singleThread) { //creating the thread

	int computeArray = (int) Math.ceil(parallelArray.length * 1.0 / singleThread);

	ParallelArraySum[] sumArrayThread = new ParallelArraySum[singleThread];
		for (int i = 0; i < singleThread; i++) {
			sumArrayThread[i] = new ParallelArraySum(parallelArray, i * computeArray, (i + 1) * computeArray);
			sumArrayThread[i].start();

		} 
			
			try {
				
				for (ParallelArraySum sumArray : sumArrayThread) {
					sumArray.join(); 
				}

			} catch (InterruptedException e) { 
				// throws interrupted exception
		}

			int allNum = 0;
			for (ParallelArraySum sumArray : sumArrayThread) {
				allNum += sumArray.getArraySum();

			}

				return allNum; // returns all the computed values

		}
}

