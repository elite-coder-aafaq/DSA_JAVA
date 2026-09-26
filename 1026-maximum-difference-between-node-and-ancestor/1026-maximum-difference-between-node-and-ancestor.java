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
    int max = Integer.MIN_VALUE;
    int min=Integer.MAX_VALUE;
    int dif=0;
    public void helper(TreeNode root,int min,int max)
    {
        if(root==null)
        {
            return;
        }
        max=Math.max(root.val,max);
        min=Math.min(root.val,min);
        helper(root.left,min,max);
        helper(root.right,min,max);
        dif=Math.max(dif,max-min);
    }
    public int maxAncestorDiff(TreeNode root) {
         helper(root,min,max);
         return dif;
        
    }
}