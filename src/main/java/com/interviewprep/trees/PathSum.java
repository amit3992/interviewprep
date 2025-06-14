package com.interviewprep.trees;

import java.util.List;
import java.util.ArrayList;

public class PathSum {

    public boolean hasPathForSum(BinaryTreeNode root, int sum) {
        if(root == null) return false;
        if(root.val == sum && root.left == null && root.right == null) return true;
        return hasPathForSum(root.left, sum - root.val) || hasPathForSum(root.right, sum - root.val);
    }

    public List<List<Integer>> pathSum(BinaryTreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(root, targetSum, current, result);
        return result;
    }

    public void backtrack(BinaryTreeNode node, int remainingSum, List<Integer> current, List<List<Integer>> result) {
        if (node == null) return;

        current.add(node.val);

        if (node.left == null && node.right == null && node.val == remainingSum) {
            result.add(new ArrayList<>(current));
        }
        backtrack(node.left, remainingSum - node.val, current, result);
        backtrack(node.right, remainingSum - node.val, current, result);
    }

    public static void main(String[] args) {
        PathSum pathSum = new PathSum();
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.left = new BinaryTreeNode(4);
        root.right = new BinaryTreeNode(8);
        root.left.left = new BinaryTreeNode(11);
        root.right.left = new BinaryTreeNode(13);
        root.right.right = new BinaryTreeNode(4);
        root.left.left.left = new BinaryTreeNode(7);
        root.left.left.right = new BinaryTreeNode(2);
        root.right.right.left = new BinaryTreeNode(5);
        root.right.right.right = new BinaryTreeNode(1);


        System.out.println(pathSum.hasPathForSum(root, 22));


    }
}
