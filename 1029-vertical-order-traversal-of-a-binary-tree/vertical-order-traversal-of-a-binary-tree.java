import java.util.*;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> list = new ArrayList<>();
        
        // DFS to collect nodes
        dfs(root, 0, 0, list);
        
        // Sort by col, then row, then value
        Collections.sort(list, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; // col
            if (a[1] != b[1]) return a[1] - b[1]; // row
            return a[2] - b[2];                   // value
        });
        
        List<List<Integer>> result = new ArrayList<>();
        
        int prevCol = Integer.MIN_VALUE;
        List<Integer> column = new ArrayList<>();
        
        for (int[] node : list) {
            int col = node[0], val = node[2];
            
            if (col != prevCol) {
                if (prevCol != Integer.MIN_VALUE) {
                    result.add(column);
                }
                column = new ArrayList<>();
                prevCol = col;
            }
            
            column.add(val);
        }
        
        result.add(column);
        return result;
    }
    
    private void dfs(TreeNode node, int row, int col, List<int[]> list) {
        if (node == null) return;
        
        list.add(new int[]{col, row, node.val});
        
        dfs(node.left, row + 1, col - 1, list);
        dfs(node.right, row + 1, col + 1, list);
    }
}