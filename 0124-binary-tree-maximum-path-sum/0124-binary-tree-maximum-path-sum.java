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
    public int hsum(TreeNode root)
    {
        if(root==null)
        {
            return Integer.MIN_VALUE;
        }
        int lsum=Math.max(0,hsum(root.left));
        int rsum=Math.max(0,hsum(root.right));
        return Math.max(lsum,rsum)+root.val;
    }
    public int maxPathSum(TreeNode root) {
        if(root==null)
        {
            return Integer.MIN_VALUE;
        }
        int Leftsum=maxPathSum(root.left);
        int rightsum=maxPathSum(root.right);
        int lefth=hsum(root.left);
        int righth=hsum(root.right);
        int selfsum=Math.max(0,lefth)+Math.max(0,righth)+root.val;
        return Math.max(selfsum,Math.max(Leftsum,rightsum));
    }
}