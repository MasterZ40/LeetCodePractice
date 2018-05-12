import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by bzhao on 4/5/2018.
 */
public class LRUCache {

    private TreeMap<Integer, Integer> invertedFrequencyMap;
    private HashMap<Integer, Integer> frequencyMap;
    private HashMap<Integer, Integer> valueMap;
    private int cap;
    private int size;


    public LRUCache(int capacity) {
        TreeMap<Integer, Integer> frequencyMap = new TreeMap<Integer, Integer>();
        valueMap = new HashMap<Integer, Integer>();
        cap = capacity;
        size = 0;
    }

    public int get(int key) {
        if(frequencyMap.containsValue(key)){
        }
        return valueMap.get(key);
    }

    public void put(int key, int value) {
        if(size == cap) {
            //full
        }
    }

}
