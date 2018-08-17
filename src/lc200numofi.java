/**
 * Created by bzhao on 8/16/2018.
 */
public class lc200numofi {
    public static void main(String[] args){
        lc200numofi sol = new lc200numofi();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };
        System.out.println(sol.numIslands(grid));
    }

    public char[][] m_grid;

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        m_grid = grid;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(m_grid[i][j] == '1'){
                    //this is an island
                    count ++;
                    mark(i, j);
                }
            }
        }
        return count;
    }

    public void mark(int x, int y){
        if(x < 0 || x >= m_grid.length) return;
        if(y < 0 || y >= m_grid[0].length) return;

        //starting form x, y
        //mark all bfs to 0
        if(m_grid[x][y] == '1'){
            m_grid[x][y] = '0';
            mark(x + 1, y);
            mark(x, y + 1);
            mark(x - 1, y);
            mark(x, y - 1);
        }

    }
}
