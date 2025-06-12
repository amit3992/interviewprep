package com.interviewprep.matrices;

public class SpiralMatrix {
    /*
    * Write a function to traverse an m x n matrix in spiral order and return all elements in a single list.
    * The traversal should start from the top left corner and proceed clockwise, spiraling inward until every element has been visited.
    * */
    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[m * n];
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        int index = 0;

        while (top <= bottom && left <= right) {
            // Top row
            for (int j = left; j <= right; j++) {
                result[index++] = matrix[top][j];
            }
            top++;

            // Right column
            for (int i = top; i <= bottom; i++) {
                result[index++] = matrix[i][right];
            }
            right--;

            // Bottom row
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result[index++] = matrix[bottom][j];
                }
                bottom--;
            }

            // Left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result[index++] = matrix[i][left];
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        spiralMatrix.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}
