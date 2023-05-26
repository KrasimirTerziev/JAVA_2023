import java.util.Scanner;

public class ChangePi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        String result = replacePi(str);
        System.out.println(result);
    }

    public static String replacePi(String str) {
        if (str.length() < 2) {
            return str;
        } else {
            if (str.substring(0, 2).equals("pi")) {
                return "3.14" + replacePi(str.substring(2));
            } else {
                return str.charAt(0) + replacePi(str.substring(1));
            }
        }
    }
}