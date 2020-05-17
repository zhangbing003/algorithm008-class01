#week04学习笔记
## 深度优先搜索（DFS）和 广度优先搜索(BFS)
#### 对比
* DFS: 正常的递归，一直遍历一条子树到叶子节点后，再遍历另一条
* BFS: 按层次遍历，

#### 代码模板
```
	DFS:
	public void dfs(TreeNode node, Set visited){
		// 退出条件
		if (node == null){
			// 处理结果
			return;
		}
		visited.add(node);
		// 执行本层逻辑
		process(node);
		
		// 进入下一层
		for (TreeNode subNode : node.children()){
			dfs(node);
		}
		
		//	清空本层状态
	}
```

```
	BFS:
	public void bfs(String start, String start, List<String> wordList) {
       
    Set<String> visited = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    visited.add(start);
    queue.add(start);
    
    while (!queue.isEmpty()){
        String node = queue.poll();
        visited.add(node);

        // 处理当前节点逻辑
        process(node);

        // 获取下层子节点
        List subNodes = genSubNodes();

        // 放入队列
        queue.addAll(subNodes);
    }
}
```

#### 例题
[DFS: 104. 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)

```
class Solution {
    public int maxDepth(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode node, int dep){
        if (node == null){
            return dep;
        }
        int leftDep = helper(node.left, dep + 1);
        int rightDep = helper(node.right, dep + 1);
        return Math.max(leftDep, rightDep);
    }
}
```

[BFS: 127. 单词接龙](https://leetcode-cn.com/problems/word-ladder/description/)

```
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) return 0;

        int length = beginWord.length();
        Map<String, List<String>> modMap = new HashMap<String, List<String>>();
        for (String word : wordList){
            for (int i = 0; i < length; i++){
                String mod = new StringBuilder(word).replace(i, i+1, "*").toString();
                List<String> list = modMap.getOrDefault(mod, new ArrayList<String>());
                list.add(word);
                modMap.put(mod, list);
            }
        }
        
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        
        int step = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                String word = queue.poll();
                for (int i = 0; i < length; i++){
                    String mod = new StringBuilder(word).replace(i, i+1, "*").toString();
                    List<String> list = modMap.getOrDefault(mod, new ArrayList<String>());
                    for (String modWord : list){
                        if (modWord.equals(endWord)){
                            return step+1;
                        }
                        if (!visited.contains(modWord)){
                            visited.add(modWord);
                            queue.offer(modWord);
                        }
                    }
                }

            }
            step++;
        }

        return 0;
    }
}

```

## 贪心算法
#### 定义
贪心算法（又称贪婪算法）是指，在对问题求解时，总是做出在当前看来是最好的选择。也就是说，不从整体最优上加以考虑，他所做出的是在某种意义上的局部最优解。
贪心算法不是对所有问题都能得到整体最优解，关键是贪心策略的选择，选择的贪心策略必须具备无后效性，即某个状态以前的过程不会影响以后的状态，只与当前状态有关

#### 例题
[122. 买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/)

```
	class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] > prices[i-1]){
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }
}

```

## 二分查找
#### 场景
在**有序**数组中快速查找

#### 代码模板

```
left, right = 0, len(array) - 1 
while left <= right: 
	  mid = (left + right) / 2 
	  if array[mid] == target: 
		    # find the target!! 
		    break or return result 
	  elif array[mid] < target: 
		    left = mid + 1 
	  else: 
		    right = mid - 1
```

#### 例题
[74. 搜索二维矩阵](https://leetcode-cn.com/problems/search-a-2d-matrix/)


```
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int colSize = matrix[0].length;

        int left = 0;
        int right = matrix.length * colSize -1;
        int mid = -1;
        while(left <= right){
            mid = (left + right) / 2;
            int midRow = mid / colSize;
            int midCol = mid % colSize;
            if (matrix[midRow][midCol] == target) return true;
            if (matrix[midRow][midCol] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}

```





