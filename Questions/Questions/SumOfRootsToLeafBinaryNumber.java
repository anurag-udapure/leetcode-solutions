/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static int sumRootToLeaf_(TreeNode root, int val){
            if(root == null){
                return 0;
            }
            val = (2 * val) + (1 * root.val);
            if(root.left == null && root.right == null){
                return val;
            }
            return (sumRootToLeaf_(root.left,val) + sumRootToLeaf_(root.right,val));
    }
    public int sumRootToLeaf(TreeNode root) {
        int val = sumRootToLeaf_(root,0);
        return val;
    }
}