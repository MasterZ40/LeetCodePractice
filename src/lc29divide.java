/**
 * Created by bzhao on 8/17/2018.
 */
public class lc29divide {

    public static void main(String[] args){
        lc29divide sol = new lc29divide();
        System.out.println(sol.divide(Integer.MIN_VALUE, 2));
    }
    public int divide(int dividend, int divisor) {
        if(dividend == 0 || divisor== 0) return 0;
        if((dividend == Integer.MAX_VALUE || dividend == Integer.MIN_VALUE) && divisor==1) return dividend;
        if(dividend == Integer.MAX_VALUE && divisor==-1) return Integer.MIN_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;

        boolean positive = !((dividend > 0) ^ (divisor > 0));

        long dd = Math.abs((long)dividend);
        long ds = Math.abs((long)divisor);

        System.out.println(dd + " " + ds);

        int res = 0;
        while(dd >= ds){
            int k = 0;
            long temp = ds;
            while(temp <= dd){
                temp <<= 1;
                k++;
            }
            k--;
            res += 1<<k;
            dd -= ds * 1<<k;
        }

        return positive? res : res * -1;
    }
}
