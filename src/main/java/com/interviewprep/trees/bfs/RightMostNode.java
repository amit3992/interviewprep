package com.interviewprep.trees.bfs;


import com.interviewprep.trees.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightMostNode {

    public List<Integer> rightMost(BinaryTreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                BinaryTreeNode current = queue.poll();

                // Check if it is the rightmost node
                if (i == size - 1) {
                    result.add(current.val);
                }

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return result;
    }

    public List<Integer> leftMost(BinaryTreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                BinaryTreeNode current = queue.poll();

                // Check if it is the rightmost node
                if (i == 0) {
                    result.add(current.val);
                }

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {

        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(3);
        root.right = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(2);
        root.right.left = new BinaryTreeNode(7);
        root.left.right.left = new BinaryTreeNode(8);

        RightMostNode rightMostNode = new RightMostNode();
        List<Integer> rightMost = rightMostNode.rightMost(root);
        System.out.println(rightMost);

        List<Integer> leftMost = rightMostNode.leftMost(root);
        System.out.println(leftMost);
    }
}
