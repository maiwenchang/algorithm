package labuladong.mustread;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class FindNearestLeaf {


    public static void main(String[] args) {

    }

    class Solution {


        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            }
            int deep = Integer.MAX_VALUE;
            if (root.left != null) {
                deep = Math.min(minDepth(root.left), deep);
            }

            if (root.right != null) {
                deep = Math.min(minDepth(root.right), deep);
            }

            return deep + 1;
        }
    }

    public int minDeepBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        int deep = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null) {
                break;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            deep++;
        }
        return deep;

    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
