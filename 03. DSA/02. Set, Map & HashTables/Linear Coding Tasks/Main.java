import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        String[] arr = scanner.nextLine().split(" ");
        int[] numbers = new int[num];
        ArrayList<Integer> output = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            numbers[i] = Integer.parseInt(arr[i]);
        }

        for (int i = 0; i < num - 1; i++) {
            int current = 1;
            for (int j = i + 1; j < num; j++) {
                if (numbers[j] > numbers[j - 1]) {
                    current++;
                } else {
                    break;
                }
            }
            output.add(current);
        }


        int maxStep = 0;
        for (int step : output) {
            if (step > maxStep) {
                maxStep = step;
            }
        }

        System.out.println(maxStep);
        for (int step : output) {
            System.out.print(step + " ");
        }
    }
}