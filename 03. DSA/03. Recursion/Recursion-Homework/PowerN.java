import java.util.Scanner;

public class PowerN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int base = scanner.nextInt();
        int n = scanner.nextInt();

        int result = powerN(base, n);
        System.out.println(result);
    }
    public static int powerN(int base, int n) {
        if (n == 0) {
            return 1;
        } else {
            return base * powerN(base, n - 1);
        }
    }
}


