// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.ArrayList;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class test1
{

    public static void main(String[] args){

    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<String> retrieveMostFrequentlyUsedWords(String literatureText,
                                                 List<String> wordsToExclude)
    {
        String delimiter = "[ ,.;'!?]+";
        String[] words = literatureText.split(delimiter);

        HashSet<String> excludes = new HashSet<String>();
        for(String s: wordsToExclude){
            excludes.add(s.toLowerCase());
        }
        HashMap<String, Integer> hist = new HashMap<String, Integer>();
        int maxFreq = 0;
        for(String word: words){
            String lower = word.toLowerCase();
            if(excludes.contains(lower)){
                continue;
            }

            if(hist.containsKey(lower)){
                int freq = hist.get(lower) + 1;
                hist.put(lower, freq);

                maxFreq = maxFreq > freq ? maxFreq: freq;
            }
            else{
                hist.put(lower, 1);
                maxFreq = maxFreq > 1 ? maxFreq: 1;
            }
        }

        ArrayList<String> result = new ArrayList<String>();
        for(Map.Entry<String, Integer> entry: hist.entrySet()){
            if(entry.getValue() == maxFreq){
                result.add(entry.getKey());
            }
        }

        return result;

    }
    // METHOD SIGNATURE ENDS
}