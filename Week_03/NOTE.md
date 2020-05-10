#week03学习笔记
## 递归
#### 思维要点
1. 不要人肉递归
2. 找重复子问题
3. 数学归纳法思维

#### 代码模板
```
	public void recur(int level, int param){
		// 退出条件
		if (level > MAX_LEVEL){
			// 处理结果
			return;
		}
		
		// 执行本层逻辑
		process(level, param);
		
		// 进入下一层
		recur(level+1, newParam);
		
		//	清空本层状态
	}
```

## 分治
#### 什么是分治
1. 特殊的递归
2. 把当层问题划分为多个子问题，再将子问题结果集组合返回给上层

#### 代码模板

```
	def divide_conquer(problem, param1, param2, ...): 
		# recursion terminator 退出条件
		if problem is None: 
			print_result 
			return 
		
		# prepare data 拆分子问题
		data = prepare_data(problem) 
		subproblems = split_problem(problem, data) 
		
		# conquer subproblems 处理子问题
		subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
		subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
		subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
		…
		
		# process and generate the final result 合并结果
		result = process_result(subresult1, subresult2, subresult3, …)
		
		# revert the current level states

```
#### 例题
[236. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/)

```
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	1. 退出条件
    	// 当前节点为null退出递归  如果指定节点是根节点，那根节点就是公共祖先 
        if (root == null || root == p || root == q) return root;
        
        2.拆分并处理子问题
		// 遍历左子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 遍历右子树
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        3.整合子结果
		// 左右都存在指定节点，那当前节点是公共祖先
        if (left != null && right != null) return root;
		// 指定节点在同一侧
        return left != null ? left : right;
    }
}
```

## 回溯
#### 什么是回溯
1. 特殊的递归
2. 百度定义 

> 回溯算法实际上一个类似枚举的搜索尝试过程，主要是在搜索尝试过程中寻找问题的解，当发现已不满足求解条件时，就“回溯”返回，尝试别的路径。回溯法是一种选优搜索法，按选优条件向前搜索，以达到目标。但当探索到某一步时，发现原先选择并不优或达不到目标，就退回一步重新选择，这种走不通就退回再走的技术为回溯法，而满足回溯条件的某个状态的点称为“回溯点”。许多复杂的，规模较大的问题都可以使用回溯法，有“通用解题方法”的美称。

#### 例题
[51. N皇后](https://leetcode-cn.com/problems/n-queens/)

```
class Solution {
    private int n;
    private int[] cols;
    private int[] slaves;
    private int[] masters;
    private int[] queens;
    private List<List<String>> res = new ArrayList<List<String>>();
    private String base = null;
    
    private void recurse(int row){
        for (int col = 0; col < n; col++){
            if (isNotUnderAttact(row, col)){ // 满足条件不被攻击才向下走
                placeQueen(row, col);
                if ((row+1) == n) // 方案通过 添加最终结果
                    addSolution();
                else { // 本层方案可行 继续下一层
                    recurse(row+1);
                }
					                
                removeQueen(row, col);
            } else {
            	尝试不成功,继续尝试下一个col方案
            }
        }
    }
    
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
```


