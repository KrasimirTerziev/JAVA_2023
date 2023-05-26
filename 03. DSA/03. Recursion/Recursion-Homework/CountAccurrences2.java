import java.util.Scanner;

public class CountAccurrences2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int output = count(num);
        System.out.println(output);
    }

    public static int count(int n) {
        if (n == 0) {
            return 0;
        } else if ((n % 10 == 8) && ((n / 10) % 10 == 8)) {
            return 2 + count(n / 10);
        } else if (n % 10 == 8) {
            return 1 + count(n / 10);
        } else {
            return count(n / 10);
        }
    }
}
