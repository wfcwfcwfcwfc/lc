package io.fengchao.leetcode.problems;

import io.fengchao.utils.TreeNode;
import io.fengchao.utils.TreeUtil;

public class FlattenBinaryTreeToLinkedList {

    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList flattenBinaryTreeToLinkedList = new FlattenBinaryTreeToLinkedList();
        Integer[] array = {1,2,5,3,4,null,6};
        TreeNode result = TreeUtil.deserializeFromArray(array, 0);
        flattenBinaryTreeToLinkedList.flatten(result);
        System.out.println("done");
    }
}
