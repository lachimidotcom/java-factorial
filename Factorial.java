import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.LongStream;

public class Factorial {
    public static long calculateFactorialNormal(int n) {
        long result = 1;
        for (int i = n; i > 0; i--) {
            result *= i;
        }
        return result;
    }
	
	public static long calculateFactorialRecursive(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * calculateFactorialRecursive(n - 1);
    }

    public static BigInteger calculateFactorialBigInteger(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static long calculateFactorialStream(int n) {
        return LongStream.rangeClosed(1, n)
                .reduce(1, (a, b) -> a * b);
    }

    public static BigInteger calculateFactorialStreamBigInteger(BigInteger n) {
        return LongStream.rangeClosed(1, n.longValue())
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Number: ");
        int num = scanner.nextInt();

        // Using normal approach
        long factorialNormal = calculateFactorialNormal(num);
        System.out.println("Factorial (Normal): " + factorialNormal);
		
		// Using recursive approach
        long factorialRecursive = calculateFactorialRecursive(num);
        System.out.println("Factorial (Recursive): " + factorialRecursive);

        // Using BigInteger
        BigInteger factorialBigInteger = calculateFactorialBigInteger(num);
        System.out.println("Factorial (BigInteger): " + factorialBigInteger);

        // Using streams
        long factorialStream = calculateFactorialStream(num);
        System.out.println("Factorial (Streams): " + factorialStream);
		
		// Using streams BigInteger
		BigInteger factorialStreamBigInteger = calculateFactorialStreamBigInteger(BigInteger.valueOf(num));
        System.out.println("Factorial (Streams with BigInteger): " + factorialStreamBigInteger);

    }
}
