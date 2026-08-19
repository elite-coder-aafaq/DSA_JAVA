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
    List<List<Integer>> fnl =new ArrayList<>();
    public void lvlOrder(TreeNode root)
    {
        Queue<TreeNode> q= new LinkedList<>();
        if(root==null)
            return;
        q.add(root);
        q.add(null);
        List<Integer> ans =new ArrayList<>();
        while(!q.isEmpty())
        {
            TreeNode curr= new TreeNode();
            curr=q.remove();
            if(curr==null)
            {
                fnl.add(ans);
                ans = new ArrayList<>();
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
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        lvlOrder(root);
        return fnl;
    }
}