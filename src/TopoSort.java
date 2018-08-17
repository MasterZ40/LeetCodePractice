import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by bzhao on 7/7/2018.
 */
public class TopoSort {
    public static void main(String[] args) {
        Graph g= new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        TopoSort sorter = new TopoSort();
        sorter.topoSort(g);
    }



    public void topoSort(Graph g){
        int num = g.V;
        Stack<Integer> stack= new Stack();
        boolean[] visited = new boolean[num];
        Arrays.fill(visited, false);
        for(int i = 0; i < num; i++){
            if(!visited[i]){
                topoSortUtil(i, visited, g.adj, stack);
            }
        }

        while(!stack.isEmpty()){
            System.out.println(stack.pop() + ", ");
        }

    }

    public void topoSortUtil(int current, boolean[] visited, LinkedList<Integer>[] adj, Stack<Integer> stack){
        visited[current] = true;
        for(int i : adj[current]){
            if(!visited[i]){
                topoSortUtil(i, visited, adj, stack);
            }
        }
        stack.push(current);
    }
}

class Graph{
    public int V;
    public LinkedList<Integer> adj[];

    Graph(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++){
            adj[i] = new LinkedList<Integer>();
        }

    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }
}