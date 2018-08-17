import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by bzhao on 7/7/2018.
 */
public class lc819MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        String delimiter = "[ ,.!?;']+";
        String[] words = paragraph.split(delimiter);

        HashSet<String> bannedSet = new HashSet<String>();
        for(String s: banned){
            bannedSet.add(s);
        }

        HashMap<String, Integer> hist = new HashMap<String, Integer>();
        for(String word: words){
            String wordLower = word.toLowerCase();

            if(bannedSet.contains(wordLower)){
                continue;
            }

            if(hist.containsKey(wordLower)){
                hist.put(wordLower, hist.get(wordLower) + 1);
            }
            else{
                hist.put(wordLower, 1);
            }
        }

        String result = "";
        int max = 0;
        for(Map.Entry<String, Integer> entry: hist.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }
}
