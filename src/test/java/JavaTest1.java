import java.util.Scanner;
import java.util.Stack;

/**
 * @author yufeng1900
 * @create 2021-03-27 14:17
 */
public class JavaTest1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //读入，输入示例：
        //nums1 = [4,1,2], nums2 = [1,3,4,2]
        String mat = scan.nextLine();
        //提取数据
        mat = mat.replaceAll("[a-zA-Z =]","");
        mat = mat.replaceAll("1\\[","");
        mat = mat.replaceAll("\\]","");

        String[] mats = mat.split(",2\\[");

//        System.out.println(mat);
//        System.out.println(mats[0]);
//        System.out.println(mats[1]);

        String[] mats1 = mats[0].split(",");
        String[] mats2 = mats[1].split(",");

        int[] nums1 = new int[mats1.length];
        int[] nums2 = new int[mats2.length];

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = Integer.valueOf(mats1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = Integer.valueOf(mats2[i]);
        }

        Stack<Integer> numStack = new Stack<Integer>();

        int j = 0;
        for (int i = 0; i < nums2.length; i++) {
            j = i;
            while(j < nums2.length && nums2[j]<=nums2[i]) j++;
            if (j<nums2.length){
                numStack.push(nums2[j]);
            }else{
                numStack.push(-1);
            }
        }

        int[] ans = new int[nums2.length];
        for (int i = ans.length-1; i >= 0; i--) {
            ans[i] = numStack.peek();
            numStack.pop();
        }

        for (int i = 0; i < nums1.length; i++) {
            j=0;
            while(nums1[i]!=nums2[j]) j++;
            nums1[i] = ans[j];
        }

        for (int i = 0; i < nums1.length; i++) {

            System.out.print(nums1[i]+",");
        }

    }
}
