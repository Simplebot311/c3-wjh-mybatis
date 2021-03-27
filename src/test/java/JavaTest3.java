import java.util.HashMap;
import java.util.Scanner;

/**
 * @author yufeng1900
 * @create 2021-03-27 15:27
 */
public class JavaTest3 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        //读入，输入示例：
        //matrix = [1,2,2,3,3,4]
        String mat = scan.nextLine();
        mat = mat.replaceAll("[a-zA-Z =\\[\\]]","");
        String[] mats = mat.split(",");
        int[] nums = new int[mats.length];
        for (int i = 0; i < mats.length; i++) {
            nums[i] = Integer.valueOf(mats[i]);
        }


        System.out.println(getsum(nums));
    }

    public static int getsum(int nums[]){
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(100);
        int sum = 0;

        for (int i = 0; i < 100; i++) {
            map.put(i,0);
        }
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i])!=nums[i] && map.get(nums[i])!=-1){
                map.remove(nums[i]);
                map.put(nums[i],nums[i]);
            }else{
                map.remove(nums[i]);
                map.put(nums[i],-1);
            }
        }

        for (int i = 0; i < 100; i++) {
            if(map.get(i)!=-1){
                sum += map.get(i);
            }
        }


        return sum;
    }
}
