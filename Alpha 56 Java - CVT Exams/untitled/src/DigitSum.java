import java.util.Scanner;

public class DigitSum {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        int k = scanner.nextInt();

        while (s.length() > k){
            StringBuilder finalString = new StringBuilder();

            for(int i = 0; i < s.length(); i += k){
                String currentGroup = s.substring(i, Math.min(i + k, s.length()));
                int sum = 0;
                for(char c : currentGroup.toCharArray()){
                    sum += Character.getNumericValue(c);
                }
                finalString.append(sum);
            }
            s = finalString.toString();
        }
        System.out.print(s);
    }
}
