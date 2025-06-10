package com.interviewprep.trees;

public class TreeDiameter {

    private int diameter = 0;
    private int nAryDiameter = 0;

    public int diameterOfBinaryTree(BinaryTreeNode root) {
        depth(root);
        return diameter;
    }

    public int nAryDiameterOfBinaryTree(TreeNode root) {
        depth_DFS(root);
        return nAryDiameter;
    }

    private int depth_DFS(TreeNode node) {
        if (node == null) return 0;

        int firstMax = 0, secondMax = 0;

        for (TreeNode child : node.children) {
            int depth = depth_DFS(child);

            if (depth > firstMax) {
                secondMax = firstMax;
                firstMax = depth;
            } else if (depth > secondMax) {
                secondMax = depth;
            }
        }

        // Update diameter with best two child depths
        nAryDiameter = Math.max(nAryDiameter, firstMax + secondMax);

        // Return longest single path downward
        return firstMax + 1;
    }


    private int depth(BinaryTreeNode node) {
        if (node == null) return 0;

        int left = depth(node.left);
        int right = depth(node.right);

        diameter = Math.max(diameter, left + right); // Update diameter

        return Math.max(left, right) + 1; // Return height
    }

    public static void main(String[] args) {
        TreeDiameter treeDiameter = new TreeDiameter();
        System.out.println(treeDiameter.diameterOfBinaryTree(null));

        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(7);
        System.out.println(treeDiameter.diameterOfBinaryTree(root));
    }
}
