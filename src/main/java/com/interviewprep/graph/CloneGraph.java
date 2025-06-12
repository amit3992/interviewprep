package com.interviewprep.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

    public Node cloneGraph(Node root) {
        if (root == null) {
            return root;
        }

        // Map to keep cloned nodes
        Map<Node, Node> nodeMap = new HashMap();
        nodeMap.put(root, new Node(root.val));

        // BFS queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node current = queue.poll();

            for(Node neighbor : current.getNeighbors()) {
                if (!nodeMap.containsKey(neighbor)) {
                    nodeMap.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                Node clonedCurrent = nodeMap.get(current);
                Node clonedNeighbor = nodeMap.get(neighbor);

                clonedCurrent.addNeighbor(clonedNeighbor);
            }
        }

        return nodeMap.get(root);

    }
}
