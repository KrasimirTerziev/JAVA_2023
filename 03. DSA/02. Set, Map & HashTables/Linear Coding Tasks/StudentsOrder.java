import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;

public class StudentsOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int numberOfStudents = Integer.parseInt(input[0]);
        int numbersOfSwaps = Integer.parseInt(input[1]);

        String[] studentNames = scanner.nextLine().split(" ");
        LinkedList<String> names = new LinkedList<>(Arrays.asList(studentNames));


        for (int i = 0; i < numbersOfSwaps; i++) {
            String[] studentsToMove = scanner.nextLine().split(" ");
            String studentWhoMove = studentsToMove[0];
            String studentWhoStay = studentsToMove[1];
            int positionOne = names.indexOf(studentWhoMove);
            int positionTwo = names.indexOf(studentWhoStay);
            if (positionTwo - 1 != positionOne) {
                names.remove(studentWhoMove);
                int getIndexOfStudentWhoStay = names.indexOf(studentsToMove[1]);
                names.add(getIndexOfStudentWhoStay, studentWhoMove);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String name: names) {
            result.append(name);
            result.append(" ");
        }
        System.out.println(result);

    }
}