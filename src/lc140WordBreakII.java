import java.util.*;

/**
 * Created by bzhao on 8/14/2018.
 */
public class lc140WordBreakII {
    public static void main(String[] args){
        lc140WordBreakII sol = new lc140WordBreakII();
        String[] inputDict = {"a","aa","aaa"};
        String target = "aaaaaaaaaaaaaaaaaaaaaaa";
        //String[] inputDict = {"apple", "pen", "applepen", "pine", "pineapple"};
        //String target = "pineapplepenapple";
        System.out.println(sol.wordBreak(target, (Arrays.asList(inputDict))));
    }

    public List<String> wordBreak(String s, List<String> wordDict){

        int len = s.length();
        HashMap<Integer, List<List<Integer>>> map = new HashMap<Integer, List<List<Integer>>>();
        List<List<Integer>> starter = new ArrayList<List<Integer>>();
        List<Integer> starter2 = new ArrayList<Integer>();
        starter2.add(0);
        starter.add(starter2);

        HashMap<Integer, List<Integer>> lookUp = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < len; i++){
            System.out.println(i);
            String cur = s.substring(i);
            for(int j = 0; j < wordDict.size(); j++){
                String word = wordDict.get(j);
                if(cur.startsWith(word)){
                    List<Integer> target;
                    int targetIndex = i + word.length();
                    if(lookUp.containsKey(targetIndex)){
                        target = lookUp.get(targetIndex);
                    }
                    else{
                        target = new ArrayList<Integer>();
                    }
                    target.add(j);
                    lookUp.put(targetIndex, target);
                }
            }
        }

        if(lookUp.containsKey(len)){
            //possible
            return constructResult(lookUp, len, wordDict);
        }
        return new ArrayList<String>();
    }

    public ArrayList<String> constructResult(HashMap<Integer, List<Integer>> lookUp, int target, List<String> wordDict){
        System.out.println(target);
        ArrayList<String> result = new ArrayList<String>();

        if(target == 0){
            result.add("");
            return result;
        }
        if(!lookUp.containsKey(target)){
            return result;
        }
        List<Integer> temp = lookUp.get(target);
        for(int item: temp){
            List<String> tempResult = (constructResult(lookUp, target - wordDict.get(item).length(), wordDict));
            for(String s: tempResult){
                s += " " + wordDict.get(item);
                //System.out.println(s);
                result.add(s.trim());
            }
        }
        return result;
    }

//    public List<String> wordBreak(String s, Set<String> dict) {
//        int len = s.length();
//        boolean[] opt = new boolean[len+1];
//        opt[0] = true;
//        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
//        ArrayList<String> zero = new ArrayList<String>();
//        zero.add("");
//        map.put(0, zero);
//
//        for(int i = 1; i < len+1; i++) {
//            for(int j = 0; j < i; j++) {
//
//                if(opt[j] == true && dict.contains(s.substring(j, i))) {
//                    opt[i] = true;
//                }
//
//            }
//        }
//        if(opt[len]) {
//
//            for(int i = 1; i < len+1; i++) {
//                ArrayList<String> tmpi = new ArrayList<String>();
//                for(int j = 0; j < i; j++) {
//
//                    if(opt[j] == true && dict.contains(s.substring(j, i))) {
//
//                        ArrayList<String> posj = map.get(j);
//                        for(String str: posj) {
//                            String copystr = "";
//                            if(i == len ) {
//                                copystr = str + s.substring(j, i);
//                            }
//                            else {
//                                copystr = str + s.substring(j, i) + " ";
//                            }
//                            tmpi.add(copystr);
//                        }
//                        opt[i] = true;
//                    }
//
//
//
//                }
//                map.put(i, tmpi);
//            }
//
//            return map.get(len);
//
//        }
//
//        else {
//            return new ArrayList<String>();
//        }
//
//    }
}
