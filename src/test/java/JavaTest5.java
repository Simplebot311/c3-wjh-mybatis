import java.util.Scanner;

/**
 * @author yufeng1900
 * @create 2021-03-27 16:22
 */
public class JavaTest5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //读入，输入示例：
        //[1,2,2,3,3,4,1,1,1,1,2,1,1]
        String mat = scan.nextLine();
        mat = mat.replaceAll("[a-zA-Z =\\[\\]]","");
        String[] mats = mat.split(",");
        int[] nums = new int[mats.length];
        for (int i = 0; i < mats.length; i++) {
            nums[i] = Integer.valueOf(mats[i]);
        }

        int kmax = 0;
        int before = 0;
        int after = 0;
        for (; before < nums.length; before++) {
            if(nums[before] == 1){

            }else{
                kmax = (kmax>before-after)?kmax:(before-after);
                after = before+1;
            }
        }

        System.out.println(kmax);
    }
}
