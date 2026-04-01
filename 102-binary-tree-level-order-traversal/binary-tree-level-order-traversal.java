









 
 





        
    
import java.util.*;

// Definition for a binary tree node
class TreeNode {
    int val;
        TreeNode left, right;

            TreeNode(int val) {
                    this.val = val;
                            left = right = null;
                                }
                                }

                                class Solution {
                                    public List<List<Integer>> levelOrder(TreeNode root) {
                                            List<List<Integer>> result = new ArrayList<>();

                                                    if (root == null) return result;

                                                            Queue<TreeNode> queue = new LinkedList<>();
                                                                    queue.offer(root);

                                                                            while (!queue.isEmpty()) {
                                                                                        int size = queue.size(); // number of nodes at current level
                                                                                                    List<Integer> level = new ArrayList<>();

                                                                                                                for (int i = 0; i < size; i++) {
                                                                                                                                TreeNode node = queue.poll();
                                                                                                                                                level.add(node.val);

                                                                                                                                                                if (node.left != null) queue.offer(node.left);
                                                                                                                                                                                if (node.right != null) queue.offer(node.right);
                                                                                                                                                                                            }

                                                                                                                                                                                                        result.add(level);
                                                                                                                                                                                                                }

                                                                                                                                                                                                                        return result;
                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                // Main method for testing
                                                                                                                                                                                                                                    public static void main(String[] args) {
                                                                                                                                                                                                                                            Solution obj = new Solution();

                                                                                                                                                                                                                                                    TreeNode root = new TreeNode(3);
                                                                                                                                                                                                                                                            root.left = new TreeNode(9);
                                                                                                                                                                                                                                                                    root.right = new TreeNode(20);
                                                                                                                                                                                                                                                                            root.right.left = new TreeNode(15);
                                                                                                                                                                                                                                                                                    root.right.right = new TreeNode(7);

                                                                                                                                                                                                                                                                                            System.out.println(obj.levelOrder(root));
                                                                                                                                                                                                                                                                                                    // Output: [[3], [9, 20], [15, 7]]
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                        }