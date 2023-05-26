import java.util.Scanner;
public class ArrayWith6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] arr = input.split(",");
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            nums[i] = Integer.parseInt(arr[i]);
        }

        int index = 0;
        boolean contain6 = checkArr(nums, index);
        if(nums.length == 0){
            contain6 = false;
        }else{
            contain6 = checkArr(nums, index);
        }
        System.out.println(contain6);
    }
    public static boolean checkArr(int[] nums, int index){
        if(index >= nums.length){
            return false;
        }else if(nums[index] == 6){
            return true;
        }else{
            return checkArr(nums, index + 1);
        }
    }
}
