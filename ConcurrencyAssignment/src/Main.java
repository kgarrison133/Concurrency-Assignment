
public class Main {
	public static synchronized void sumArray() {
		int[] nums = new int[200000000];
		int min = 1;
		int max = 10;
		int num = 0;
		int sum = 0;
		for(int i=0 ; i<nums.length;i++) {
			num = (int)(Math.random()*(max-min+1)+min);
			nums[i] = num;
		}
		
		for(int item: nums) {
			sum += item;
		}
		System.out.println("Sum is: " + sum);
	}


	public static void main(String[] args) {

		Thread t1 = new Thread (new Runnable() {
			@Override
			public void run() {
				sumArray();
			}
		});
		
		Thread t2 = new Thread (new Runnable() {
			@Override
			public void run() {
				sumArray();
			}
		});
		
		long startTime = System.nanoTime(); 
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		}catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		long endTime = System.nanoTime(); 

		System.out.println("Time took: " + (endTime - startTime));
		


	}

}
