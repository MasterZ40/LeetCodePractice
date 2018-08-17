/**
 * Created by bzhao on 7/6/2018.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class HorseStates
{
    public static void main(String[] args) {

    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days)
    {
        int num = states.length;
        int[] newStates = new int[num];
        if(num == 0){
            return new ArrayList<Integer>();
        }
        if(num == 1){
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }

        for(int i = 0; i < days; i++){
            for(int j = 0; j < num; j++){
                if(j == 0) {
                    newStates[j] = states[j + 1];
                }
                if(j == num-1){
                    newStates[j] = states[j - 1];
                }

                newStates[j] = states[j+1] == states[j-1]? 0:1;
            }

            states = newStates;
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i: states){
            result.add(i);
        }
        return result;
    }
    // METHOD SIGNATURE ENDS
}
