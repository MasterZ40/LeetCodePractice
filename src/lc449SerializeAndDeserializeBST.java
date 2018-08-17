import com.sun.org.apache.bcel.internal.classfile.Code;

/**
 * Created by bzhao on 8/17/2018.
 */
public class lc449SerializeAndDeserializeBST {

    public static void main(String[] args){
        TreeNode n = new TreeNode(2);
        n.left = new TreeNode(1);
        n.right = new TreeNode(3);

        Codec c = new Codec();
        String s = c.serialize(n);
        System.out.println(s);

        c.deserialize(s);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(Integer.toString(root.val));
        sb.append(",");
        sb.append(serialize(root.left));
        sb.append(",");
        sb.append(serialize(root.right));
        sb.append("}");

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        if(data.equals("{}"))
            return null;

        int valEnd = data.indexOf(',');
        String valString = data.substring(1, valEnd);
        TreeNode root = new TreeNode( Integer.parseInt(valString));

        valEnd ++;
        int level = 0;
        int leftEnd = valEnd;
        for(int i = valEnd; i < data.length() - 1; i++){
            if(data.charAt(i) == '{'){
                level ++;
                continue;
            }
            if(data.charAt(i) == '}'){
                level --;
                if(level == 0){
                    leftEnd = i;
                    break;
                }
            }
        }

        root.left = deserialize(data.substring(valEnd, leftEnd + 1));
        leftEnd += 2; //"},"
        root.right = deserialize(data.substring(leftEnd, data.length() - 1));

        return root;
    }
}
