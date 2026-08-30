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
    class INFO
    {
        boolean isBST;
        int sum;
        int min;
        int max;

        public INFO(boolean isBST, int sum,int min,int max)
        {
            this.isBST=isBST;
            this.sum=sum;
            this.min=min;
            this.max=max;
        }
    }
    public int maxsum=0;

    public INFO largestBST(TreeNode root)
    {
        if(root==null)
        {
            return new INFO(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        INFO leftinfo=largestBST(root.left);
        INFO rightinfo=largestBST(root.right);
        int sum=leftinfo.sum+rightinfo.sum+root.val;
        int min=Math.min(root.val,Math.min(leftinfo.min,rightinfo.min));
        int max=Math.max(root.val,Math.max(leftinfo.max,rightinfo.max));

        if(root.val<=leftinfo.max||root.val>=rightinfo.min)
        {
            return new INFO(false,sum,min,max);
        }
        if(leftinfo.isBST&&rightinfo.isBST)
        {
            maxsum=Math.max(maxsum,sum);
            return new INFO(true,sum,min,max);
        }
        return new INFO(false,sum,min,max);
    }
    public int maxSumBST(TreeNode root) {
        INFO info=largestBST(root);
        return maxsum;
    }
}