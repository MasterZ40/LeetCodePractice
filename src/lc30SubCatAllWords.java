import java.util.*;

/**
 * Created by bzhao on 4/18/2018.
 */
public class lc30SubCatAllWords {
    public static void main(String[] args){
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};

        System.out.println(findSubstring(s, words));
    }
    public static List<Integer> findSubstring(String s, String[] words) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        int[] appr = new int[s.length()];
        Arrays.fill(appr, -1);
        int wordLen = words[0].length();
        for(int i = 0; i < s.length() - wordLen; i++){
            for(int j = 0; j < words.length; j ++){
                if(s.substring(i, i + wordLen).equals(words[j])) {
                    appr[i] = j;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(appr));

        int i = 0;
        while(i < s.length() - wordLen * words.length){
            while(i < s.length() - wordLen * words.length && appr[i] == -1){
                i++;
            }
            HashSet<Integer> set = new HashSet<Integer>();
            for(int j = i; j < s.length(); j+= wordLen){
                if(appr[j] == -1){
                    break;
                }
                if(set.contains(appr[j])){
                    break;
                }
                set.add(appr[j]);
            }
            System.out.println("for i=" + i + " set size: " + set.size());
            if(set.size() == words.length){
                result.add(i);
            }
            i++;
        }

        return result;

    }
}
