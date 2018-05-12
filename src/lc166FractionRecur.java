import java.util.HashMap;

/**
 * Created by bzhao on 5/6/2018.
 */
public class lc166FractionRecur {
    public static void main(String[] args) {
        lc166FractionRecur sol = new lc166FractionRecur();
        System.out.println(sol.fractionToDecimal(1, 214748364));
    }

    public String fractionToDecimal(int num, int den) {
        long numerator = num;
        long denominator = den;

        if( numerator == 0 || denominator == 0){
            return "0";
        }


        String s = "";
        if(denominator < 0){
            denominator *= -1;
            numerator *= -1;
        }
        if( numerator < 0) {
            numerator *= -1;
            s += "-";
        }


        if(numerator > denominator) {
            long integral =  (numerator / denominator);
            int remain =(int) ( numerator % denominator);
            s += Long.toString(integral);
            if(remain == 0){
                return s;
            }

            numerator = remain;
        }
        else {
            s += "0";
        }

        s += ".";

        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        String frac = "";
        int index = 0;
        //numerator is smaller than dem, and we are now behind decimal point
        while(true){


            //devide
            numerator *= 10;
            if(map.containsKey(numerator)){
                //we have a loop!

                int start = map.get(numerator);
                frac = frac.substring(0, start) + "(" + frac.substring(start, frac.length());
                frac += ")";
                break;
            }
            map.put( numerator, index );
            long integral =  (numerator / denominator);
            int remain = (int) ( numerator % denominator);


            //System.out.println(numerator + " " + index);
            frac += Long.toString(integral);
            if(remain == 0){
                break;
            }
            if(numerator > denominator){
                numerator = remain;
            }

            index ++;
        }


        return s + frac;

    }
}
