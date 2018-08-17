import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by bzhao on 8/15/2018.
 */
public class lc801MinSwaps {

    public static void main(String[] args){
        lc801MinSwaps sol = new lc801MinSwaps();
        int[] A = {0,4,4,5,9};
        int[] B = {0,1,6,8,10};
        System.out.println(sol.minSwap(A, B));
    }

    public int minSwap(int[] A, int[] B) {
        int len = A.length;
        //for 0th element
        int swap = 1;
        int noswap = 0;
        for(int i = 1; i < len; i++){
            if(A[i] <= A[i-1] || B[i] <= B[i-1]) {
                //must be different than i-1
                int temp = swap;
                swap = noswap + 1;
                noswap = temp;
            }
            else if(B[i] <= A[i-1] || A[i] <= B[i-1]){
                //must keep same as i-1
                swap ++;
            }
            else{
                //doesn't matter
                int smaller = Math.min(swap, noswap);
                swap = smaller + 1;
                noswap = smaller;
            }
        }

        return Math.min(swap, noswap);
    }
}
