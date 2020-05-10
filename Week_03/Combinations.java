class Solution {
    private int n;
    private int k;
    private List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) return res;
        this.n = n;
        this.k = k;
        backtrack(1, new ArrayList());
        return res;
    }
    private void backtrack(int first, List<Integer> list){
        if (list.size() == k){
            res.add(new ArrayList(list));
            return;
        }
        if ((n-first+list.size()) < k-1){
            return;
        }
        for (int i = first; i <= n; i++){
            list.add(i);

            backtrack(i+1, list);

            list.remove(list.size()-1);
        }
    }
}