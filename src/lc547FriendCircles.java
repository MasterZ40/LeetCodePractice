import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by bzhao on 5/6/2018.
 */
public class lc547FriendCircles {
    public static void main(String[] args) {
        lc547FriendCircles solution = new lc547FriendCircles();
        int[][] M =  new int[][]{
                { 1, 1, 0 },
                { 1, 1, 0 },
                { 0, 0, 1 },

        };
        System.out.println(solution.findCircleNum(M));
    }

    public int findCircleNum(int[][] M) {
        int n = M.length;

        int result = 0;
        int[] covered = new int[n];
        Arrays.fill(covered, 0);

        for(int i = 0; i < n; i ++){
            for(int j = i; j < n; j++){
                if(M[i][j] == 1 && covered[i] == 0){
                    result ++;
                    //bfs search from i j;
                    HashSet<Integer> set = new HashSet<Integer>();
                    set.add(i);
                    bfs(set, i, M);
                    for(Integer x: set){
                        covered[x] = 1;
                    }
                }
            }
        }
        return result;
    }

    public void bfs(HashSet<Integer> set, int root, int[][] M){
        for(int i = 0; i < M.length; i++){
            if(M[root][i] == 1 && !set.contains(i)){
                set.add(i);
                bfs(set, i, M);
            }
        }
    }
}
