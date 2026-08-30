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
    List<Integer> arr=new ArrayList<>();
    public void inorder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left);
        arr.add(root.val);
        inorder(root.right);
    }
    public TreeNode CreateBST(List<Integer> arr,int st, int end)
    {
        if(st>end)
        {
            return null;
        }
        int mid=(st+end)/2;
        TreeNode root=new TreeNode(arr.get(mid));
        root.left=CreateBST(arr,st,mid-1);
        root.right=CreateBST(arr,mid+1,end);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        int start=0;
        int last=arr.size()-1;
        return CreateBST(arr,start,last);
    }
}