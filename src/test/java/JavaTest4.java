import java.util.Scanner;

/**
 * @author yufeng1900
 * @create 2021-03-27 15:59
 */
public class JavaTest4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入k：");
        int k = scan.nextInt();
        String str = scan.nextLine();
        System.out.println("请输入数组（ 如：matrix = [1,3,-1,-3,5,3,6,7] ）：");

        String mat = scan.nextLine();
        mat = mat.replaceAll("[a-zA-Z =\\[\\]]","");
        String[] mats = mat.split(",");
        int[] nums = new int[mats.length];
        for (int i = 0; i < mats.length; i++) {
            nums[i] = Integer.valueOf(mats[i]);
        }


        int before = 0;
        int after = 0;
        int max = 0;
        for (; before <= nums.length; before++) {
            if(before-after == k){
                max=nums[after];
                for (int i = 1; i < k; i++) {
                    max = (max>nums[after+i])?max:nums[after+i];
                }
                System.out.println(max);
                after++;
            }
        }

    }
}
