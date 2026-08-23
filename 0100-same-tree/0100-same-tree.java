class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        String hash1 = computeTreeHash(p);
        String hash2 = computeTreeHash(q);
        return hash1.equals(hash2);
    }
    
    private String computeTreeHash(TreeNode node) {
        if (node == null) {
            return "null";
        }
        String leftHash = computeTreeHash(node.left);
        String rightHash = computeTreeHash(node.right);
        return "(" + node.val + leftHash + rightHash + ")";
    }
}