/**
 * Created by bzhao on 4/11/2018.
 */
import java.util.PriorityQueue;
import java.util.Collections;

public class lc295FindMedianfromDataStream {

    public static void main (String[] args) {
        lc295FindMedianfromDataStream obj = new lc295FindMedianfromDataStream();
        obj.addNum(1);
        obj.addNum(2);
        obj.addNum(3);
        double m = obj.findMedian();
        System.out.println(m);
        return;
    }

    int size;
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    //min value always equal or +1 to maxVals;

    /** initialize your data structure here. */
    public lc295FindMedianfromDataStream() {
        size = 0;
        max = new PriorityQueue<Integer>(10);
        min = new PriorityQueue<Integer>(10, Collections.reverseOrder());
    }

    public void addNum(int num) {
        if(size == 0){
            min.add(num);
            size ++;
            return;
        }

        if(num <= findMedian()){
            min.add(num);
        }
        else{
            max.add(num);
        }
        size ++;
        if(max.size() > min.size()){
            //balancing
            min.add(max.poll());
        }
        if(min.size() > max.size() + 1){
            //reverse balancing
            max.add(min.poll());
        }
    }

    public Double findMedian() {
        if(size == 0){
            return null;
        }

        System.out.println(min.peek());
        System.out.println(max.peek());

        if(size%2 == 0){
            return (min.peek() + max.peek()) / 2.0;
        }
        else{
            return min.peek() + 0.0;
        }
    }
}
