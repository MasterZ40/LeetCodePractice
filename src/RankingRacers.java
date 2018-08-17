import java.util.*;

/**
 * Created by bzhao on 7/5/2018.
 *
 * given racing data of racers, containing id of racer, start time and finish time.
 * sort racers by the number of people it covers,
 * who starts later than the current racer and finished earlier than the current racer.
 */
public class RankingRacers {

    public static void main(String[] args) {
        RankingRacers rr = new RankingRacers();
        ArrayList<RacerData> data = new ArrayList<RacerData>();

        //rr.rank(data, data.size());

        int[][] adjMatrix = {
                {0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}

        };

        int[] result = rr.topoSort(adjMatrix, 6);
        System.out.println(Arrays.toString(result));
    }

    public void rank(List<RacerData> data, int num) {
        HashMap<Integer, List<Integer>> rankingMap = new HashMap<Integer, List<Integer>>();
        int[][] adj = new int[num][num];
        for(int i = 0; i < num; i ++){
            RacerData racer1 = data.get(i);
            for(int j = i + 1; j < num; j ++){

                RacerData racer2 = data.get(j);

                if(racer1.covers(racer2)){
                    adj[i][j] = 1;
                }
                else if(racer2.covers(racer1)){
                    adj[j][i] = 1;
                }

            }
        }
        int[] score = topoSort(adj, num);
    }

    public int[] topoSort(int[][] covergraph, int num){
        //calculate size of each sub tree
        HashSet<Integer> covered = new HashSet<Integer>();
        int[] score = new int[num];
        for(int i = 0; i < num; i++){
            if(!covered.contains(i)){
                recurScore(i, covergraph, num, score, covered);
            }
        }

        return score;
    }

    public void recurScore(int target, int[][] covergraph, int num, int[] score, HashSet<Integer> covered){
        System.out.println("scorign target: " + target);
        covered.add(target);
        int count = 0;
        for(int i = 0; i < num; i++){
            if(covergraph[target][i] == 1 && !covered.contains(i)){
                recurScore(i, covergraph, num, score, covered);
                count += score[i] + 1;
            }
        }
        score[target] = count;
    }
}

class RacerData {
    public int id;
    public long start;
    public long end;

    public RacerData(int i, int s, int e){
        id = i;
        start = s;
        end = e;
    }

    public boolean covers(RacerData other){
        if(this.id == other.id){
            return false;
        }
        return this.start < other.start && this.end > other.end;
    }
}