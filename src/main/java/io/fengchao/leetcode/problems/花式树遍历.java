package io.fengchao.leetcode.problems;

import io.fengchao.utils.TreeNode;

public class 花式树遍历 {
    public static void main(String[] args) {
        花式树遍历 遍历 = new 花式树遍历();
        遍历.show();

        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        root.left = two;
        root.right = three;
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        two.left = four;
        two.right = five;

        遍历.递归前序遍历(root);

    }

    private void show() {
        System.out.println("真可以");
    }

    private void 递归前序遍历(TreeNode node) {
        if(node == null) {
            return;
        }
        System.out.print(node.value);
        递归前序遍历(node.left);
        递归前序遍历(node.right);
    }
}
