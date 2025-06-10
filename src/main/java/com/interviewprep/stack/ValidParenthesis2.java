package com.interviewprep.stack;

import java.util.*;

public class ValidParenthesis2 {

    /*
    * Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.

      Return a list of unique strings that are valid with the minimum number of removals. You may return the answer in any order.



Example 1:

Input: s = "()())()"
Output: ["(())()","()()()"]
Example 2:

Input: s = "(a)())()"
Output: ["(a())()","(a)()()"]
Example 3:

Input: s = ")("
Output: [""]
    *
    * */
    public String[] removeInvalidParentheses(String s) {

        // BFS approach
        List<String> result = new ArrayList<>();
        if (s == null) {
            return result.toArray(new String[0]);
        }
        // Set to keep track of visited strings
        Set<String> visited = new HashSet<>();

        // Queue to perform BFS
        Queue<String> queue = new LinkedList<>();

        // Add the original string to the queue
        queue.add(s);

        // Add the original string to the visited set
        visited.add(s);
        // Flag to indicate if a valid string has been found
        boolean found = false;

        // Perform BFS
        while (!queue.isEmpty()) {

            // Remove the current string from the queue
            String curr = queue.poll();

            // Check if the current string is valid
            if (isValid(curr)) {
                // Add the current string to the result
                result.add(curr);
                found = true; // Found at this level
            }

            if (found) continue; // Skip next levels

            // Generate all possible strings by removing parentheses
            for (int i = 0; i < curr.length(); i++) {

                // Skip if the current character is not a parenthesis
                if (curr.charAt(i) != '(' && curr.charAt(i) != ')') continue;

                // Generate the next string by removing the current parenthesis
                String next = curr.substring(0, i) + curr.substring(i + 1);
                // Check if the next string has already been visited
                if (!visited.contains(next)) {
                    // Add the next string to the visited set
                    visited.add(next);
                    queue.add(next);
                }
            }
        }

        // Return the result
        return result.toArray(new String[0]);

    }

    private boolean isValid(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') count++;
            if (ch == ')') {
                if (count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        ValidParenthesis2 validParenthesis = new ValidParenthesis2();
        System.out.println(Arrays.toString(validParenthesis.removeInvalidParentheses("()())()")));

    }
}
