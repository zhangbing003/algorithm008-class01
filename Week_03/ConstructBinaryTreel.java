/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private Map<Integer, Integer> map = new HashMap();
    private int[] preorder;
    private int[] inorder;
    private int preIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(0, inorder.length);
    }

    private TreeNode helper(int inLeft, int inRight){
        if (inLeft == inRight)return null;
        TreeNode root = new TreeNode(preorder[preIndex++]);
        int index = map.get(root.val);
        root.left = helper(inLeft, index);
        root.right = helper(index+1, inRight);
        return root;
    }
}