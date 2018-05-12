import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by bzhao on 3/22/2018.
 * Given a positive integer n, find the number of non-negative integers less than or equal to n, whose binary representations do NOT contain consecutive ones.
 *
 * Example 1:
 * Input: 5
 * Output: 5
 * Explanation:
 * Here are the non-negative integers <= 5 with their corresponding binary representations:
 * 0 : 0
 * 1 : 1
 * 2 : 10
 * 3 : 11
 * 4 : 100
 * 5 : 101
 * Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule.
 *
 */
public class lc600
{
    public static void main (String[] args) {

        System.out.println(findIntegers(1));
    }

    public static int recur(ArrayList<Integer> bits) {
        int len = bits.size();
        int[] result = new int[len];
        result[0] = bits.get(0) ==1? 2:1;
        result[1] = bits.get(1) ==1? result[0] + 1:result[0];
        for(int i = 1; i < len; i++){
            if(bits.get(i) == 1) {
                result[i] = result[i-1] + result[i-2];
            }
            else {
                //0
                result[i] = result[i-1];
            }
        }
        return result[len-1];
    }

    public static int fab(int n) {
        if(n ==1) {
            return 2;
        }
        if(n == 0) {
            return 1;
        }
        //all 1 string length n, return all possible takes
        return fab(n-1) + fab(n-2);
    }

    public static int findNonConsecutiveOne(ArrayList<Integer> bits) {
        int result = 0;
        int len = bits.size();
        if(len == 0){
            return 0;
        }
        int prevbit = 0;
        for(int i = 0; i < len; i++) {
            if(bits.get(i) == 1) {
                //smaller bits can be anything as long as no 11
                result += fab(len - i - 1);
                //this bit needs to be 1 moving forward
                if(prevbit == 1){
                    return result;
                }
                prevbit = 1;
            }
            else {
                prevbit = 0;
            }
        }



        return result + 1;
    }

    public static int findIntegers(int num){
        ArrayList<Integer> bits= new ArrayList<Integer>();
        while(num != 0){
            bits.add(num & 1);
            num >>= 1;
        }
        Collections.reverse(bits);
        return recur(bits);
    }
}
