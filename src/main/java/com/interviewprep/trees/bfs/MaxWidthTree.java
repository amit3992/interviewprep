package com.interviewprep.trees.bfs;

import com.interviewprep.trees.BinaryTreeNode;


import java.util.*;

public class MaxWidthTree {

    static class Pair<K, V> {
        private K key;
        private V value;
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() { return key; }
        public V getValue() { return value; }
    }

    public static int maxWidthTree(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<Pair<BinaryTreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));

        int maxWidth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().getValue();
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair<BinaryTreeNode, Integer> curr = queue.poll();
                BinaryTreeNode node = curr.getKey();
                int index = curr.getValue() - minIndex;

                if (i == 0) {
                    first = index;
                }
                if (i == size - 1) {
                    last = index;
                }
                if (node.left != null) {
                    queue.add(new Pair<>(node.left, index * 2 ));
                }
                if (node.right != null) {
                    queue.add(new Pair<>(node.right, index * 2 + 1));
                }
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        return maxWidth;
    }




    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(3);
        root.right = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(2);
        root.right.left = new BinaryTreeNode(7);
        root.left.right.left = new BinaryTreeNode(8);


        BinaryTreeNode tree2 = new BinaryTreeNode(1);
        tree2.left = new BinaryTreeNode(2);
        tree2.right = new BinaryTreeNode(7);
        tree2.left.left = new BinaryTreeNode(1);
        tree2.left.left.left = new BinaryTreeNode(7);

        tree2.right.left = new BinaryTreeNode(6);
        tree2.right.left.right = new BinaryTreeNode(1);

        tree2.right.right = new BinaryTreeNode(9);
        tree2.right.right.left = new BinaryTreeNode(1);

        MaxWidthTree maxWidthTree = new MaxWidthTree();
        System.out.println(maxWidthTree.maxWidthTree(tree2));
    }
}
