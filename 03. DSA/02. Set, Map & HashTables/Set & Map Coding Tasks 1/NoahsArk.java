
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NoahsArk {
    public static void main(String[] args) {


        Scanner scanner = new Scanner((System.in));
        int num = Integer.parseInt(scanner.nextLine());

        String[] arr = new String[num];

        for (int i = 0; i < arr.length - 1; i++) {
            String species = scanner.nextLine();
            arr[i] = species;
        }
        Arrays.sort(arr);

        Map<String, Integer> animalCounts = new HashMap<>();

        for (int i = 0; i < arr.length; i++){
            String species = arr[i];
            animalCounts.put(species, animalCounts.getOrDefault(species, 0));

            if(i == arr.length - 1 || !arr[i].equals(arr[i + 1])){
                int count = animalCounts.get(species);
                String even = (count % 2 == 0) ? "Yes" : "No";
                System.out.println(species + " " + count + " " + even);
            }
        }

//        int curr = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] != arr[i + 1]) {
//                System.out.println(arr[i] + " 1 No");
//            }
//            while (arr[i].equals(arr[i + 1])) {
//                curr++;
//                if (curr % 2 == 0) {
//                    System.out.println(arr[i] + " " + curr + " Yes");
//                } else {
//                    System.out.println(arr[i] + " " + curr + " No");
//                }
//                i++;
//            }
//            curr = 0;
//        }


//    Scanner scanner = new Scanner(System.in);
//    int n = Integer.parseInt(scanner.nextLine());
//
//    Map<String, Integer> animalCounts = new HashMap<>();
//
//        for (int i = 0; i < n; i++) {
//        String species = scanner.nextLine();
//        animalCounts.put(species, animalCounts.getOrDefault(species, 0) + 1);
//    }
//        //TODO


    }
}
