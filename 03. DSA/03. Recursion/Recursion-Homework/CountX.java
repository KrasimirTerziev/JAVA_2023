import java.util.Scanner;
public class CountX {
    public static int countX(String str) {
        if (str.length() == 0) {
            return 0;
        } else {
            if (str.charAt(0) == 'x') {
                return 1 + countX(str.substring(1));
            } else {
                return countX(str.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int count = countX(str);
        System.out.println(count);
    }
}