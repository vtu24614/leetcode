import java.util.*;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, "", result);
        return result;
    }

    private void dfs(TreeNode node, String path, List<String> result) {
        if (node == null) return;

        // Append current node value to path
        if (path.isEmpty()) {
            path = Integer.toString(node.val);
        } else {
            path += "->" + node.val;
        }

        // If leaf, add path to result
        if (node.left == null && node.right == null) {
            result.add(path);
        } else {
            // Recurse left and right
            dfs(node.left, path, result);
            dfs(node.right, path, result);
        }
    }
}