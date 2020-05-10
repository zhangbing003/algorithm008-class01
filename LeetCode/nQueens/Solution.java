package nQueens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    private int[] cols;
    private int[] masters;
    private int[] slaves;
    private int[] queens;
    private int n;
    private String board;
    private List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        if (n > 0){
            cols = new int[n];
            masters = new int[2*n];
            slaves = new int[4*n];
            queens = new int[n];
            this.n = n;
            board = String.join("", Collections.nCopies(n, "."));
            backTrack(0);
        }
        return res;
    }

    private void backTrack(int row) {
        for (int col = 0; col < n; col++){
            if (isNotUnderAttact(row, col)){
                placeQueen(row, col);

                if (row + 1 == n){
                    addSolution();
                } else {
                    backTrack(row+1);
                }

                removeQueen(row, col);
            }
        }
    }

    private void removeQueen(int row, int col) {
        cols[col] = 0;
        masters[row+col] = 0;
        slaves[row-col+2*n] = 0;
        queens[row] = 0;
    }

    private void addSolution() {
        List<String> list = new ArrayList<>();
        for (int col : queens){
            list.add(new StringBuilder(board).replace(col, col+1, "Q").toString());
        }
        res.add(list);
    }

    private void placeQueen(int row, int col) {
        cols[col] = 1;
        masters[row+col] = 1;
        slaves[row-col+2*n] = 1;
        queens[row] = col;
    }

    private boolean isNotUnderAttact(int row, int col) {
        return cols[col] + masters[row+col] + slaves[row-col+2*n] == 0;
    }
}
