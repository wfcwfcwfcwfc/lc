package io.fengchao.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class GenAbbrevation {
    public static void main(String[] args) {
        gen("abc");
    }

    public static void gen(String str) {
        List<String> ans = new ArrayList<>();
        for(int i = 1; i < str.length(); i++) {
            dfs(str, new ArrayList<String>(), ans, i);
        }
    }

    public static void dfs(String str, List<String> path, List<String> ans, int len) {
        if(str.length() == 0) {
            ans.add(print(path));
            return;
        }

        for(int i = 0; i + len <= str.length(); i++) {
            String pre = str.substring(0, i);
            if(pre.length() != 0) {
                path.add(pre);
            }
            path.add("" + len);
            dfs(str.substring(i), path, ans, len);
            path.remove(path.size() - 1);
            if(pre.length() != 0) {
                path.remove(path.size() - 1);
            }
        }
    }

    private static String print(List<String> path) {
        String str = "";
        for(String s : path) {
            str += s;
        }
        return str;
    }
}
