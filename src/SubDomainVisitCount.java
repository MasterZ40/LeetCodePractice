import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bzhao on 4/3/2018.
 */
public class SubDomainVisitCount {
    public static void main (String[] args) {
        String[] list = {"9001 discuss.leetcode.com"};
        System.out.println(subdomainVisits(list));

    }
    public static List<String> subdomainVisits(String[] cpdomains) {
        ArrayList<String> result = new ArrayList<String>();
        HashMap<String, Integer> keeper = new HashMap<String, Integer>();

        for(String pair: cpdomains){
            String[] list = pair.split(" ");
            int visits = Integer.parseInt(list[0]);

            String url = list[1];

            while(true){
                if(keeper.containsKey(url)){
                    keeper.put(url, keeper.get(url) + visits);
                }
                else {
                    keeper.put(url, visits);
                }
                int dotPos = url.indexOf('.');
                if(dotPos == -1) {
                    break;
                }
                url = url.substring(dotPos+1);
            }
        }

        for(Map.Entry<String, Integer> entry : keeper.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            result.add(Integer.toString(value) + " " + key);
        }

        return result;
    }
}
