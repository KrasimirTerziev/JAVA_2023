import java.util.Scanner;

public class Jumps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfElements = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        int[] elements = new int[numberOfElements];
        int biggestNumber = 0;

        for (int i = 0; i < numberOfElements; i++) {
            elements[i] = Integer.parseInt(input[i]);
            if (biggestNumber < elements[i]){
                biggestNumber = elements[i];
            }

        }

        int[] jumpCounts = new int[numberOfElements];
        int maxJumps =0;


        for (int i = 0; i < elements.length; i++) {
            int jumps = 0;
            int currentElement = elements[i];

            for (int j = i +1; j < elements.length ; j++) {
                int checkElement =  elements[j];
                if (currentElement < checkElement){
                    jumps++;
                    currentElement = elements[j];

                    if (currentElement == biggestNumber){
                        break;
                    }
                }
            }
            if (jumps > maxJumps){
                maxJumps = jumps;
            }
            jumpCounts[i] = jumps;


        }
        System.out.println(maxJumps);
        for (int i = 0; i < numberOfElements; i++) {
            System.out.printf("%d " ,jumpCounts[i]);
        }

    }
}