/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    int index = 0;
    public void serializehelper(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("N,");
            return;
        }
            sb.append(root.val).append(",");
            serializehelper(root.left,sb);
            serializehelper(root.right,sb);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializehelper(root,sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        index = 0;
        return deserializehelper(str);

    }
    public TreeNode deserializehelper(String[] str){
        if(str[index].equals("N")){
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(str[index]));
        index++;
        node.left = deserializehelper(str);
        node.right = deserializehelper(str);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));