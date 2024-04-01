import java.util.Scanner;

public class Hiking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] elevations = new int[input.length];
        for (int i = 0; i < elevations.length; i++) {
            elevations[i] = Integer.parseInt(input[i]);
        }

        int maxClimb = 0;
        int currentClimbUp = 0;
        int currentClimbDown = 0;
        for (int i = 1; i < elevations.length; i++) {
            if (elevations[i] > elevations[i - 1]) {
                currentClimbUp += elevations[i] - elevations[i - 1];
                currentClimbDown = 0;
            } else {
                currentClimbDown += elevations[i - 1] - elevations[i];
                currentClimbUp = 0;
            }
            maxClimb = Math.max(maxClimb, Math.max(currentClimbUp, currentClimbDown));
        }

        System.out.println(maxClimb);
    }
}