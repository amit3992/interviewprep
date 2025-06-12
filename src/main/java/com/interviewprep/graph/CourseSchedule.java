package com.interviewprep.graph;

import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        // Initialize graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph and compute in-degrees
        for (int[] pre : prerequisites) {
            int course = pre[0], prereq = pre[1];
            graph.get(prereq).add(course);
            inDegree[course]++;
        }

        // Queue for nodes with in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        int finishedCourses = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            finishedCourses++;

            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) queue.offer(neighbor);
            }
        }

        return finishedCourses == numCourses;
    }

    public Integer[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> order = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        // Initialize graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph and compute in-degrees
        for (int[] pre : prerequisites) {
            int course = pre[0], prereq = pre[1];
            graph.get(prereq).add(course);
            inDegree[course]++;
        }

        // Queue for nodes with in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        // Topological sort
        while (!queue.isEmpty()) {
            int current = queue.poll();

            // Check if there is a cycle
            if (order.contains(current)) return new Integer[0];

            // Add current course to order
            order.add(current);

            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) queue.offer(neighbor);
            }
        }

        if (order.size() != numCourses) return new Integer[0];

        return order.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0}, {2, 1}, {3,1}, {2,3}};

        CourseSchedule courseSchedule = new CourseSchedule();
        System.out.println(courseSchedule.canFinish(numCourses, prerequisites));
        System.out.println(Arrays.toString(courseSchedule.findOrder(numCourses, prerequisites)));
    }
}
