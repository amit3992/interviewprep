package com.interviewprep.graph.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinKnightMoves {

    public static int minKnightMoves(int x, int y) {
        if (x == 0 && y == 0) return 0;
        // Work in positive quadrant due to symmetry
        x = Math.abs(x);
        y = Math.abs(y);

        // Directions a knight can move
        int[][] directions = {
                {1, 2}, {2, 1}, {-1, 2}, {-2, 1},
                {-1, -2}, {-2, -1}, {1, -2}, {2, -1}
        };

        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(0, 0, 0));
        Set<String> visited = new HashSet<>();

        visited.add("0,0");
        int steps = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            while(size-- > 0) {
                Coordinate current = queue.poll();

                int currentX = current.x;
                int currentY = current.y;
                int currentDist = current.dist;

                if (currentX == x && currentY == y) {
                    return steps;
                }

                for (int[] direction : directions) {
                    int newX = currentX + direction[0];
                    int newY = currentY + direction[1];
                    String key = newX + "," + newY;

                    if (newX >= -2 && newY >= -2 && !visited.contains(key)) {
                        queue.offer(new Coordinate(newX, newY, currentDist + 1));
                        visited.add(key);
                    }
                }
            }
            steps++;
        }
        return -1;

    }

    static class Coordinate {

        int x;
        int y;
        int dist;

        public Coordinate(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        System.out.println(minKnightMoves(5, 5));
        System.out.println(minKnightMoves(4, 4));

    }
}
