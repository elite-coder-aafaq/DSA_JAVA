/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int ans = Integer.MIN_VALUE;

    public int helper(TreeNode root) {

        if(root == null)
        {
            return 0;
        }

        int leftsum = helper(root.left);
        int rightsum = helper(root.right);

        int selfsum = Math.max(0, leftsum)
                    + Math.max(0, rightsum)
                    + root.val;

        ans = Math.max(ans, selfsum);

        return root.val + Math.max(Math.max(0, leftsum),
                                   Math.max(0, rightsum));
    }

    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }
}