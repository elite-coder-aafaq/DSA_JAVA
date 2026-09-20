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
    class Pair {
        TreeNode node;
        long index;

        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();
        if(root==null)
        {
            return 0;
        }
        q.add(new Pair(root,0));
        int maxwidth=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            long first=q.peek().index;
            long last=first;
            for(int i=0;i<size;i++)
            {
                Pair current =q.poll();
                TreeNode curr = current.node;
                long index= current.index;
                last=index-first;
                if(curr.left!=null)
                {
                    q.add(new Pair(curr.left,2*index+1));
                } 
                if(curr.right!=null)
                {
                    q.add(new Pair(curr.right,2*index+2));
                }
            }
            int width=(int)last+1;
            maxwidth=Math.max(maxwidth,width);
        }
        return maxwidth;
    }
}