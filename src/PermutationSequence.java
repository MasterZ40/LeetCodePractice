import java.util.ArrayList;

/**
 * Created by bzhao on 4/3/2018.
 */
public class PermutationSequence {
    public static void main (String[] args) {
        System.out.println(getPermutation(3, 4));
    }

    public static String getPermutation(int n, int k) {
        if(n == 1){
            return "1";
        }
        int[] fact = new int[20];
        fact[0] = 1;
        for(int i = 1; i < 20; i++){
            fact[i] = fact[i-1] * i;
        }

        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < n; i++){
            list.add(Integer.toString(i + 1));
        }
        String s = "";
        k = k -1;
        for(int i = n - 1; i >= 0 ; i --){
            if(k == 0) {
                for(String temp: list){
                    s += temp;
                }
                return s;
            }
            if(list.size() == 1){
                s += list.get(0);
                return s;
            }

            int divisor = fact[i];

            int position = k / divisor;
            String number = list.get(position);
            System.out.println(position + " " + number + " " +  divisor);
            s += number;
            list.remove(position);
            k -= divisor * (position);
            System.out.println("afterward k:" + k);
        }
        return s;
    }
}
