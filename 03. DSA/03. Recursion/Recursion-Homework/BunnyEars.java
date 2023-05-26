import java.util.Scanner;

public class BunnyEars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int output = bunnyEars(num);
        System.out.println(output);
    }

    public static int bunnyEars(int ears) {
        if (ears == 0) {
            return 0;
        } else {
            return  2 + bunnyEars(ears - 1);
        }
    }
}
