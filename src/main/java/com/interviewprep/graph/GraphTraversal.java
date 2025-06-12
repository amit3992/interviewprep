package com.interviewprep.graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversal {

    public void dfs(Node root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        for (Node neighbor : root.getNeighbors()) {
            dfs(neighbor);
        }
    }

    public void bfs(Node root) {
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.peek();
            queue.poll();
            System.out.print(node.val + " ");
            for (Node neighbor : node.getNeighbors()) {
                queue.add(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.addNeighbor(new Node(2));
        root.addNeighbor(new Node(3));
        root.addNeighbor(new Node(4));

        Node node2 = root.getNeighbors().get(0);
        node2.addNeighbor(new Node(5));
        node2.addNeighbor(new Node(6));

        Node node3 = root.getNeighbors().get(1);
        node3.addNeighbor(new Node(7));
        node3.addNeighbor(new Node(8));

        Node node4 = root.getNeighbors().get(2);
        node4.addNeighbor(new Node(9));
        node4.addNeighbor(new Node(10));

        // DFS
        GraphTraversal graphTraversal = new GraphTraversal();
        graphTraversal.dfs(root);

        // BFS
        graphTraversal.bfs(root);

    }
}
