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
    List<Integer> fnl=new ArrayList<>();
    public void helper(TreeNode root)
    {
        List<Integer> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null)
        {
            return;
        }
        q.add(root);
        q.add(null);
        while(!q.isEmpty())
        {
            TreeNode curr=q.remove();
            if(curr==null)
            {
                fnl.add(ans.get(ans.size() - 1));
                if(q.isEmpty())
                {
                    break;
                }
                else
                {
                    q.add(null);
                }
            }
            else
            {
                ans.add(curr.val);
                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }

            }
        }
        return;
    }
    public List<Integer> rightSideView(TreeNode root) {
        helper(root);
        return fnl;
    }
}