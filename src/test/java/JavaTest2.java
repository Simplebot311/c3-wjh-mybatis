import java.util.Scanner;
import java.util.Stack;

/**
 * @author yufeng1900
 * @create 2021-03-27 15:15
 */
public class JavaTest2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //读入，输入示例：
        //pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
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

        int[] pushed = new int[mats1.length];
        int[] popped = new int[mats2.length];

        for (int i = 0; i < pushed.length; i++) {
            pushed[i] = Integer.valueOf(mats1[i]);
        }

        for (int i = 0; i < popped.length; i++) {
            popped[i] = Integer.valueOf(mats2[i]);
        }

        System.out.println(Sequences(pushed, popped));

    }

    static public boolean Sequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.empty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.empty();
    }

}
