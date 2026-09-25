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
 import java.util.*;
class Solution {
    List<Integer> ans=new ArrayList<>();
    List<List<Integer>> fnl=new ArrayList<>();
    public void hasPathSum(TreeNode root, int targetSum,List<Integer> ans, List<List<Integer>> fnl) {

        if (root == null) {
            return ;
        }
        ans.add(root.val);
        // We reached a leaf
        if (root.left == null && root.right == null) {
            if(targetSum == root.val)
            {
                fnl.add(new ArrayList<>(ans));
            }
            else
            {
                // Backtrack
                ans.remove(ans.size() - 1);
                return;
            }
        }

        targetSum = targetSum - root.val;
        


        hasPathSum(root.left, targetSum,ans,fnl);
        hasPathSum(root.right, targetSum,ans,fnl);

        ans.remove(ans.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        hasPathSum(root,targetSum,ans,fnl);
        return fnl;
        
    }
}