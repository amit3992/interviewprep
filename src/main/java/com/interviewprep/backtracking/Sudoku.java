package com.interviewprep.backtracking;

public class Sudoku {

    public boolean isValiddSudoku(char[][] board) {
        // row wise
        for (int i = 0; i < board.length; i++) {
            int freq[] = new int[10];
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (freq[c - '0'] != 0) {
                    return false;
                }
                freq[c - '0']++;
            }
        }

        // column wise
        for (int j = 0; j < board[0].length; j++) {
            int freq[] = new int[10];
            for (int i = 0; i < board.length; i++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (freq[c - '0'] != 0) {
                    return false;
                }
                freq[c - '0']++;
            }
        }

        // 3x3
        for (int i = 0; i < board.length; i = i + 3) {
            for (int j = 0; j < board[i].length; j = j + 3) {
                int freq[] = new int[10];
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        char c = board[k][l];
                        if (c == '.') {
                            continue;
                        }
                        if (freq[c - '0'] != 0) {
                            return false;
                        }
                        freq[c - '0']++;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkCharFreq(char c, int freq[]) {
        if (freq[c - '0'] != 0) {
            return false;
        }
        freq[c - '0']++;
        return true;
    }

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        sudoku.isValiddSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        });
    }
}
