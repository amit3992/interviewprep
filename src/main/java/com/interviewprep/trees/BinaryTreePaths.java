package com.interviewprep.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(BinaryTreeNode root) {
        if(root == null) return null;
        List<String> result = new ArrayList<>();
        String path = "";

        dfs(root, path, result);
        return result;
    }

    public void dfs(BinaryTreeNode node, String path, List<String> result) {
        if(node  == null)
            return;

        // Build path
        path += node.val;

        if(node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        path += "->";
        dfs(node.left, path, result);
        dfs(node.right, path, result);
    }


    public static void main(String[] args) {
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(7);

        System.out.println(binaryTreePaths.binaryTreePaths(root));
    }
}
