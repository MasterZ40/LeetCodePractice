import java.util.ArrayList;

/**
 * Created by bzhao on 5/7/2018.
 */
public class lc236LCA {

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        one.left = new TreeNode(2);

        lc236LCA sol = new lc236LCA();
        TreeNode node = sol.lowestCommonAncestor(one, one, one.left);
        System.out.println(node.val);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    ArrayList<TreeNode> result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> cur = new ArrayList<TreeNode>();
        bfs(cur, root, p);

        ArrayList<TreeNode> result1 = result;

        result = null;
        cur.clear();

        bfs(cur, root, q);
        ArrayList<TreeNode> result2 = result;

        for(int i = 0; i < Math.min(result1.size(), result2.size()); i++){
            if(result1.get(i) != result2.get(i)){
                //i - 1 is the lca
                return result1.get(i - 1);
            }
        }

        return root;
    }

    public void bfs(ArrayList<TreeNode> path, TreeNode start, TreeNode target){
        if(result != null){
            return;
        }

        path.add(start);
        //System.out.println(start.val);
        if(start == target){
            result = path;
            return;
        }
        if(start.left != null){
            bfs(path, start.left, target);
        }
        if(start.right != null){
            bfs(path, start.right, target);
        }

    }
}
