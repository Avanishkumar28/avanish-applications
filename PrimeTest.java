package av.java8;

public class PrimeTest {
	
	public static boolean isPrime(int number) {
		boolean divisibleFlag = false;
		for(int i = 2; i<number; i++) {
			if(number%i ==0) {
				divisibleFlag = true;
				break;
			}
		}
		
		
		return number>1 && !divisibleFlag;
	}

	public static void main(String[] args) {
		for(int num=1; num<=10; num++) {
			System.out.println(num+" is prime number "+isPrime(num));
		}

	}

}
