import java.util.ArrayList;

/**
 * Created by bzhao on 4/4/2018.
 */
public class lc809ExpressiveWords {
    public static void main(String[] args ){
        lc809ExpressiveWords ep = new lc809ExpressiveWords();
        String[] words = {"hello", "hi", "helo"};
        System.out.println(ep.expressiveWords("heeellooo", words));
    }

    public int expressiveWords(String S, String[] words) {
        int index = 0;
        ArrayList<Tuple<Character, Integer>> keeper = new ArrayList<Tuple<Character, Integer>>();
        while(index < S.length()){
            char c = S.charAt(index);
            int count = 0;
            while(index < S.length() && S.charAt(index) == c){
                index ++;
                count++;
            }
            System.out.println(c + " " + count);
            keeper.add(new Tuple<Character, Integer>(c, count));
        }


        int result = 0;
        for(String word: words) {
            if(canStretch(word, keeper)){
                result ++;
            }
        }
        return result;
    }
    public boolean canStretch(String input, ArrayList<Tuple<Character, Integer>> keeper){
        int index = 0;
        int indexk = 0;
        while(index < input.length() && indexk < keeper.size()){
            char c = input.charAt(index);
            int count = 0;
            while(index < input.length() && input.charAt(index) == c){
                index ++;
                count++;
            }
            Tuple<Character, Integer> pair = keeper.get(indexk);
            if(pair.x != c){
                return false;
            }
            if(pair.y < count){
                return false;
            }
            if(pair.y > count) {
                if(pair.y < 3){
                    return false;
                }
            }
            indexk ++;
        }
        return index == input.length() && indexk == keeper.size();
    }
    public class Tuple<X, Y> {
        public final X x;
        public final Y y;
        public Tuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}

