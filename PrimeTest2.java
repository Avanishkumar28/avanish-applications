package av.java8;

import java.util.stream.IntStream;

public class PrimeTest2 {
	

	public static boolean isPrime(int number) {
		return number>1 && 
				IntStream.range(2, number)
					.noneMatch(i -> number%i == 0);
	}

	public static void main(String[] args) {
		for(int num=1; num<=10; num++) {
			System.out.printf("%d Is prime number ? %b \n",num, isPrime(num));
		}

	}

}
