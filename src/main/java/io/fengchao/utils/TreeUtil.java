package io.fengchao.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeUtil {
    private static final int PADDING_SIZE = 2;
    private static final String SPACE = " ";

    public static TreeNode deserializeFromArray(Integer[] array, int pos) {
        if(pos >= array.length) {
            return null;
        }
        if(array[pos] == null) {
            return null;
        }
        TreeNode left = deserializeFromArray(array, (pos + 1) * 2 - 1);
        TreeNode right = deserializeFromArray(array, (pos + 1) * 2);

        TreeNode root = new TreeNode();
        root.value = array[pos];
        root.left = left;
        root.right = right;
        return root;
    }

    public static void printBinaryTreeInConsole(TreeNode root) {
        if(root == null) {
            return;
        }
        List<List<String>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean more = true;
        while(!q.isEmpty() && more) {
            more = false;
            int size = q.size();
            List<String> r = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(node == null) {
                    q.offer(null);
                    q.offer(null);
                    r.add("null");
                    continue;
                }
                r.add(String.valueOf(node.value));
                if(node.left != null) {
                    more = true;
                    q.add(root.left);
                } else {
                    q.add(null);
                }
                if(node.right != null) {
                    more = true;
                    q.add(root.right);
                } else {
                    q.add(null);
                }
            }
            result.add(r);
        }

        for(int i = 0; i < result.size(); i++) {
            String str = "";
            for(int j = result.size() - 1; j >= 0; j--) {
                str += SPACE + SPACE;
            }
            for(int k = 0; k < result.get(i).size(); k++) {
                str += result.get(i).get(k) + SPACE + SPACE;
            }
            System.out.println(str);
        }
    }
}
