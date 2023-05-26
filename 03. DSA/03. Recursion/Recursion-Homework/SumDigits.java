import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int output = digits(num);
        System.out.println(output);
    }

    public static int digits(int n) {
        if (n == 0) {
            return 0;
        } else {
            int lastDigit = n % 10;
            int currentDigits = n / 10;
            return lastDigit + digits(currentDigits);
        }
    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int number = scanner.nextInt();
//
//        int sum = 0;
//        int tempNumber = number;
//
//        while (tempNumber > 0) {
//            int digit = tempNumber % 10;
//            sum += digit;
//            tempNumber /= 10;
//        }
//
//        System.out.println(sum);
//    }
}
