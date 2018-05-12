import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by bzhao on 3/12/2018.
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 *
 *
 Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstrWithoutRepeatChar {
    public static void main (String[] args) {
        ArrayList<String> testCases = new ArrayList();
        testCases.add("abcabcbb");
        testCases.add("bbbbb");
        testCases.add("pwwkew");
        testCases.add("fthdsgertyuyjdfdrett");
        for(String testString: testCases){
            int res = lengthOfLongestSubstring(testString);
            System.out.println("For input: " + testString + ", the length of the desired substring is " + res);
        }
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) {
            return 0;
        }
        int head = 0;
        int len = s.length();
        int tail = 1;
        int currentMax = 0;
        HashSet<Character> set = new HashSet<Character>();
        set.add(s.charAt(head));
        while(head < len && tail < len ) {
            while(tail < len && !set.contains(s.charAt(tail))) {
                set.add(s.charAt(tail));
                tail ++;
            }
            if(tail - head > currentMax) {
                currentMax = tail - head;
            }
            //Done with substr starting with s[head]
            set.remove(s.charAt(head));
            head ++;
            if(tail == head) {
                set.add(s.charAt(head));
                tail = head + 1;
            }
        }
        return currentMax;
    }
}
