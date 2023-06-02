import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Variations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int z = scanner.nextInt();
        scanner.nextLine();
        String[] symbols = scanner.nextLine().split(" ");

        List<String> variations = generateVariations(symbols[0], symbols[1], z);
        Collections.sort(variations);

        for(String variation:variations){
            System.out.println(variation);
        }
     }
     private static List<String> generateVariations(String x, String y, int z){
        List<String> variations = new ArrayList<>();
        generateVariationsHelper(x, y, z, "", variations);
        return variations;
     }
     private static void generateVariationsHelper(String x, String y, int z, String current, List<String> variations){
        if(current.length() == z){
            variations.add(current);
            return;
        }
        generateVariationsHelper(x, y, z, current + y, variations);
         generateVariationsHelper(x, y, z, current + x, variations);
     }
}

