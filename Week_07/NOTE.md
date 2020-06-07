#week07学习笔记
## Trie树（字典树）
#### 定义
	字典树，即 Trie 树，又称单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。 它的优点是：最大限度地减少无谓的字符串比较，查询效率比哈希表高。



```
class TreeNode {
    private TreeNode[] nodes = new TreeNode[26];
    private boolean end;

    public boolean containsKey(char key) {
        return nodes[key - 'a'] != null;
    }

    public TreeNode get(char key) {
        return nodes[key - 'a'];
    }

    public void put(char key, TreeNode node) {
        nodes[key - 'a'] = node;
    }

    public void setEnd() {
        this.end = true;
    }

    public boolean isEnd() {
        return this.end;
    }
}
class Trie {

    private TreeNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode node = root;
        for (char c : word.toCharArray()) {
            TreeNode subNode = node.get(c);
            if (subNode == null) {
                subNode = new TreeNode();
                node.put(c, subNode);
            }
            node = subNode;
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode node = root;
        for (char c : word.toCharArray()) {
            node = node.get(c);
            if (node == null) {
                return false;
            }
        }
        return node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.get(c);
            if (node == null) {
                return false;
            }
        }
        return true;
    }
}

```


#### 例题
[212. 单词搜索 II](https://leetcode-cn.com/problems/word-search-ii/)

```
class TreeNode {
    public TreeNode[] nodes = new TreeNode[26];
    public String word;

    public boolean containsKey(char key) {
        return nodes[key - 'a'] != null;
    }

    public TreeNode get(char key) {
        return nodes[key - 'a'];
    }

    public void put(char key, TreeNode node) {
        nodes[key - 'a'] = node;
    }
}
class Trie {

    public TreeNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode node = root;
        for (char c : word.toCharArray()) {
            TreeNode subNode = node.get(c);
            if (subNode == null) {
                subNode = new TreeNode();
                node.put(c, subNode);
            }
            node = subNode;
        }
        node.word = word;
    }
}

class Solution {
    private List<String> res = new ArrayList();
    public List<String> findWords(char[][] board, String[] words) {
        if (words == null || words.length == 0 || board == null || board.length == 0) return res;
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (trie.root.containsKey(board[i][j])) {
                    backtrace(board, i, j, trie.root.get(board[i][j]));
                }
            }
        }
        return res;
    }

    private void backtrace(char[][] board, int i, int j, TreeNode node) {
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        char curr = board[i][j];
        board[i][j] = '#';
        int[] rows = {-1, 0, 1, 0};
        int[] cols = {0, -1, 0, 1};
        for (int k = 0; k < 4; k++) {
            int newRow = i + rows[k];
            int newCol = j + cols[k];
            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length) {
                continue;
            }
            if (board[newRow][newCol] != '#' && node.containsKey(board[newRow][newCol])) {
                backtrace(board, newRow, newCol, node.get(board[newRow][newCol]));
            }
        }
        board[i][j] = curr;
    }
}

```

## 并查集
#### 定义
用于组团、配对问题 Group or not ?


```
private int[] parent;
private int count;

private int find(int n) {
    while(parent[n] != n) {
        parent[n] = parent[parent[n]];
        n = parent[n];
    }
    return n;
}

private void union(int p, int q) {
    int rootP = find(p);
    int rootQ = find(q);
    if (rootP == rootQ) return;
    parent[rootQ] = rootP;
    count--;
}

```

#### 例题
[547. 朋友圈](https://leetcode-cn.com/problems/friend-circles/)

```
	class Solution {
    private int[] parent;
    private int count;
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) return 0;
        int n = M.length;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        count = n;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (i != j && M[i][j] == 1) {
                    uniq(i, j);
                }
            }
        }
        return count;
    }

    private int find(int n) {
        while (parent[n] != n) {
            parent[n] = parent[parent[n]];
            n = parent[n];
        }
        return n;
    }

    private void uniq(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootQ] = rootP;
        count--;
    }
}

```



