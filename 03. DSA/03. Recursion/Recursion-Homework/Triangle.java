import java.util.Scanner;
public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int output = triangle(num);
        System.out.println(output);
    }
    public static int triangle(int n){
        if(n == 0){
            return 0;
        }else{
            return n + triangle(n - 1);
        }
    }
}
