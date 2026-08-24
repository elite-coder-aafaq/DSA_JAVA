/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 import java.util.*;
class Solution {
    public boolean getpath(TreeNode root, int n, ArrayList<TreeNode> path)
    {
        if(root==null)
        {
            return false;
        }
        path.add(root);
        if(root.val==n)
        {
            return true;
        }
        boolean foundleft= getpath(root.left,n,path);
        boolean foundright= getpath(root.right,n,path);

        if(foundleft||foundright)
        {
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> p1=new ArrayList<>();
        ArrayList<TreeNode> p2=new ArrayList<>();

        int n1=p.val;
        int n2=q.val;

        getpath(root,n1,p1);
        getpath(root,n2,p2);
        int i;
        for(i=0;i<p1.size()&&i<p2.size();i++)
        {
            if(p1.get(i)!=p2.get(i))
            {
                break;
            }
        }
        return p1.get(i-1);

    }
}