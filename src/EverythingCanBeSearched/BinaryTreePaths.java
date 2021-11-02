package EverythingCanBeSearched;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder path = new StringBuilder();
        List<String> result = new ArrayList<>();
        DFS(path, root, result);
        return result;
    }

    public void DFS(StringBuilder path, TreeNode root, List<String> result) {
        int len = ("" + root.val).length();;
        if(path.length() == 0) path.append(root.val);
        else {
            path.append("->" + root.val);
            len += 2;
        }
        if(root.left == null && root.right == null) result.add(new String(path));
        else {
            if(root.left != null) DFS(path, root.left, result);
            if(root.right != null) DFS(path, root.right, result);
        }
        path.delete(path.length()-len, path.length());
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
       this.val = val;
       this.left = left;
       this.right = right;
    }
}
