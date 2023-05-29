package tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class LargestSurface {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] size = input.split(" ");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        int[][] matrix = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                String inputElement = scanner.next();
                int element = Integer.parseInt(inputElement);
                matrix[i][j] = element;
            }
        }
        int maxSize = findLargestSequence(matrix);
        System.out.println(maxSize);
    }
    public static int findLargestSequence(int[][] matrix){
//        int maxCount = 0;
//        int element = -1;
//
//        Map<Integer, Integer> countMap = new HashMap<>();
//
//        for(int i = 0; i < matrix.length; i++){
//            for(int j = 0; j < matrix[i].length; j++){
//                int currElement = matrix[i][j];
//                int count = countMap.getOrDefault(currElement, 0)+1;
//
//                if(count > maxCount){
//                    maxCount = count;
//                    element = currElement;
//                }
//                countMap.put(currElement, count);
//            }
//        }
//        return maxCount;

        int maxSequences = 0;
        int rows = matrix.length;
        int columns = matrix[0].length; // matrix[row].length

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < columns; col++){
                int currElement = matrix[row][col];
                int currSequence = 1;

//                1 3 2 2 2 4
//                3 3 3 2 4 4
//                4 3 1 2 3 3
//                4 3 1 3 3 1
//                4 3 3 3 1 1

                //сравняваме клетките, които са разположени от лява/дясно и отгоре/долу
                if((row - 1 >= 0) && matrix[row - 1][col] == currElement){
                    currSequence++;
                }
                if((row + 1 < rows) && matrix[row + 1][col] == currElement){
                    currSequence++;
                }
                if((col - 1 >= 0) && matrix[row][col - 1] == currElement){
                    currSequence++;
                }
                if((col + 1 < columns) && matrix[row][col + 1] == currElement){
                    currSequence++;
                }
                if(currSequence > maxSequences){
                    maxSequences = currSequence;
                }
            }
        }
        return maxSequences;
    }
}
