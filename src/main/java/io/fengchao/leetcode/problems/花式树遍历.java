package io.fengchao.leetcode.problems;

import apple.laf.JRSUIUtils;
import io.fengchao.utils.TreeNode;

import java.util.LinkedList;

public class 花式树遍历 {
    public static void main(String[] args) {
        花式树遍历 遍历 = new 花式树遍历();
        遍历.show();
        System.out.println();

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
        System.out.println();
        遍历.preOrderIterative(root);


        System.out.println();
        System.out.println();
        遍历.recursiveInOrder(root);
        System.out.println();
        遍历.iterativeInOrder(root);

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

    private void preOrderIterative(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        if(root == null) {
            return;
        }
        stack.addFirst(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.removeFirst();
            System.out.print(node.value);
            if(node.right != null) {
                stack.addFirst(node.right);
            }
            if(node.left != null) {
                stack.addFirst(node.left);
            }
        }
    }

    private void recursiveInOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        recursiveInOrder(root.left);
        System.out.print(root.value);
        recursiveInOrder(root.right);
    }

    //背诵
    private void iterativeInOrder(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList();
        TreeNode cur = root;
        //初始条件？
        while(cur != null || !stack.isEmpty()) {
            //cur or cur.left
            while(cur != null) {
                stack.addFirst(cur);
                cur = cur.left;
            }

            cur = stack.removeFirst();
            System.out.print(cur.value);

            //if null?
            cur = cur.right;
        }
    }
}
