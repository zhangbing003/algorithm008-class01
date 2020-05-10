class Solution {
    private int n;
    private int[] cols;
    private int[] slaves;
    private int[] masters;
    private int[] queens;
    private List<List<String>> res = new ArrayList<List<String>>();
    private String base = null;
    public List<List<String>> solveNQueens(int n) {
        if (n > 0){
            this.n = n;
            cols = new int[n];
            queens = new int[n];
            masters = new int[2*n];
            slaves = new int[4*n];
            base = String.join("", Collections.nCopies(n, "."));
            recurse(0);
        }
        return res;
    }

    private void recurse(int row){
        for (int col = 0; col < n; col++){
            if (isNotUnderAttact(row, col)){
                placeQueen(row, col);
                if ((row+1) == n)
                    addSolution();
                else {
                    recurse(row+1);
                }
                removeQueen(row, col);
            }
        }
    }

    private boolean isNotUnderAttact(int row, int col){
        return (cols[col] + masters[row+col] + slaves[row-col+2*n]) == 0;
    }

    private void placeQueen(int row, int col){
        cols[col] = 1;
        masters[row+col] = 1;
        slaves[row-col+2*n] = 1;
        queens[row] = col;
    }

    private void removeQueen(int row, int col){
        cols[col] = 0;
        masters[row+col] = 0;
        slaves[row-col+2*n] = 0;
        queens[row] = 0;
    }

    private void addSolution(){
        List<String> solution = new ArrayList<String>();
        for (int i = 0; i < n; ++i) {
            int col = queens[i];
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < col; ++j) sb.append(".");
            sb.append("Q");
            for(int j = 0; j < n - col - 1; ++j) sb.append(".");
            solution.add(sb.toString());
        }
        res.add(solution);
    }
}