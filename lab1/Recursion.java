public class Recursion {
 
	static int subsum(int n) {
		//Ex1. Complete the content of this method 
    int num = n;
		int sum = 0;

		while (num > 0) {
			sum += num * Math.pow(-1, num + 1);
			num--;

			subsum(num);
		}

		return sum;
	}
    
	static int sumDigit(int n) {
		//Ex2. Complete the content of this method 
		int num = n;
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num /= 10;
			sumDigit(num);
		}
        
    return sum;
  }

	public static int sumEven(int n) {
		// Ex3. Complete the content of this method
		int num = n;
    if (num <= 0) {
      return 0;
    } else {
      if (n % 2 == 0) {
        return n + sumEven(n - 2);
      } else {
        return sumEven(n - 1);
      }
    }
	}

    
	public static void main(String[] args) {
          
    // Test Uncomment these lines below to test your subsum code
		System.out.println("Calculating subsum(10):");
		System.out.println("Your answer is "+subsum(10));
    System.out.println("The correct answer is -5");
		System.out.println("-----------------------"); 

		// Uncomment these lines below to test your sumDigit code
		System.out.println("sumDigit(123456789)");
		System.out.println("Your answer is "+ sumDigit(123456789));
		System.out.println("The correct answer is 45");

		// Uncomment these lines below to test your sumEven code
		System.out.println("Calculating sumEven(10):");
		System.out.println("Your answer is " + sumEven(10));
		System.out.println("The correct answer is 30");
	}
}

    