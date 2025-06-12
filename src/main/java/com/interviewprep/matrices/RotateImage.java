package com.interviewprep.matrices;

public class RotateImage {

    /*
    * Write a function to rotate an n x n 2D matrix representing an image by 90 degrees clockwise.
    * The rotation must be done in-place, meaning you should modify the input matrix directly without using an additional matrix for the operation.
    *
    *
    * Time Complexity: O(n2) where n is the number of rows in the matrix.
    * Space Complexity: O(1) since we are doing the rotation in-place.
    * */
    public void rotate(int[][] matrix) {
        // Transpose the matrix
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateImage.rotate(matrix);
    }
}
