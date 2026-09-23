class Solution {

    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        // Perfect binary tree
        if (leftHeight == rightHeight) {
            return (int)Math.pow(2, leftHeight) - 1;
        }

        // Not perfect
        return 1 + countNodes(root.left) + countNodes(root.right);
    }


    int getLeftHeight(TreeNode root) {

        int height = 0;

        while (root != null) {
            height++;
            root = root.left;
        }

        return height;
    }


    int getRightHeight(TreeNode root) {

        int height = 0;

        while (root != null) {
            height++;
            root = root.right;
        }

        return height;
    }
}