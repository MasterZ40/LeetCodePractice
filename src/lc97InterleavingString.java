/**
 * Created by bzhao on 4/11/2018.
 */
public class lc97InterleavingString {

    public static void main(String[] args){
        /*String s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
        String s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
        String s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
*/

        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));
    }
    public static boolean isInterleave(String s1, String s2, String s3){
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] opt = new int[len1+1][len2+1];

        for(int i = 0 ; i <= len1; i ++) {
            for(int j = 0; j <= len2; j++) {
                if(i == 0 && j ==0){
                    opt[i][j] = 1;
                    continue;
                }
                //compare s1[i-1] s2[j-1] to s3[i+j-1]

                if(i == 0){
                    if(s2.charAt(j-1) == s3.charAt(i+j-1) && opt[i][j-1] == 1){
                        opt[i][j] = 1;
                    }
                    else {
                        opt[i][j] = 0;
                    }
                    continue;
                }
                if(j == 0){
                    if(s1.charAt(i-1) == s3.charAt(i+j-1) && opt[i-1][j] == 1){
                        opt[i][j] = 1;
                    }
                    else {
                        opt[i][j] = 0;
                    }
                    continue;
                }

                if((s1.charAt(i-1) == s3.charAt(i+j-1) && opt[i-1][j] == 1)
                    || (s2.charAt(j-1) == s3.charAt(i+j-1) && opt[i][j-1] == 1)){
                    opt[i][j] = 1;
                }
                else{
                    opt[i][j] = 0;
                }



            }
        }

        for(int i = 0 ; i <= len1; i ++) {
            for(int j = 0; j <= len2; j++) {
                System.out.print(opt[i][j] + ", ");
            }
            System.out.println();
        }

        return opt[len1][len2] == 1;
    }


    /*public static boolean isInterleave(String s1, String s2, String s3) {

        return search(s1, s2, s3, true) || search(s1, s2, s3, false);

    }
    public static boolean search(String s1, String s2, String s3, boolean matchOne){
        System.out.println(s3);

        if(matchOne){
            //match s1 with s3;
            if(s1.equals(s3)) {
                return s2.equals("");
            }
            String commonPrefix = calcCP(s1, s3);
            if(commonPrefix.equals("")){
                return false;
            }
            int len = commonPrefix.length();
            for(int i = 1; i <= len; i++){
                //System.out.println(i);
                if(search(s1.substring(i), s2, s3.substring(i), false)){
                    return true;
                }
            }
            return false;
        }
        else {
            //match s2 with s3;
            if(s2.equals(s3)) {
                return s1.equals("");
            }
            String commonPrefix = calcCP(s2, s3);
            if(commonPrefix.equals("")){
                return false;
            }
            int len = commonPrefix.length();
            for(int i = 1; i <= len; i++){
                //System.out.println(i);
                if(search(s1, s2.substring(i), s3.substring(i), true)){
                    return true;
                }
            }
            return false;
        }
    }

    private static String calcCP(String a, String b){
        if(a.equals("") || b.equals("")){
            return "";
        }
        int i = 0;
        while(i < a.length() && a.charAt(i) == b.charAt(i)){
            i++;
        }
        return a.substring(0, i);
    }*/
}
