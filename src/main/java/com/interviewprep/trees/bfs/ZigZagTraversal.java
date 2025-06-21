package com.interviewprep.trees.bfs;

import com.interviewprep.trees.BinaryTreeNode;

import java.util.*;

public class ZigZagTraversal {

    public List<List<Integer>> zigZag(BinaryTreeNode root) {
        if( root == null ) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        Stack<Integer> stack = new Stack<>();
        boolean leftToRight = true;

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < levelSize; i++) {
                BinaryTreeNode current = queue.poll();
                level.add(current.val);
                if(current.left != null) {
                    queue.add(current.left);
                }
                if(current.right != null) {
                    queue.add(current.right);
                }
            }
            if (!leftToRight) {

                for (int i : level) {
                    stack.push(i);
                }

                level.clear();

                while(!stack.isEmpty()) {
                    level.add(stack.pop());
                }
            }

            result.add(level);
            leftToRight = !leftToRight;
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

        ZigZagTraversal zigZagTraversal = new ZigZagTraversal();
        List<List<Integer>> result = zigZagTraversal.zigZag(root);
        System.out.println(result);
    }
}
