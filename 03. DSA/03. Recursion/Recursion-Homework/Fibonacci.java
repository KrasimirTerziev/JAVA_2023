import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        long result = fibonacci(n);
        System.out.println(result);
    }
    public static long fibonacci(long n) {
        if (n == 0) {
            return 0;
        }else if(n == 1){
            return 1;
        }else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}