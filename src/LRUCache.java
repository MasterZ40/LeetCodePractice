import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by bzhao on 4/5/2018.
 */
class LRUCache {

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    TreeMap<Integer, Integer> freq = new TreeMap<Integer, Integer>(); //frequency, key in map
    HashMap<Integer, Integer> iFreq = new HashMap<Integer, Integer>(); //key in map, frequency

    public LRUCache(int capacity) {

    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        int frequency = iFreq.get(key);


        return map.get(key);
    }

    public void put(int key, int value) {

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
