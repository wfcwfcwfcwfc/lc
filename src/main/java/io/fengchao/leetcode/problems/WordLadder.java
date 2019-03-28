package io.fengchao.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *  图的遍历。给了起点终点，问有没有一条path通向终点。图由给出的规则简历，为隐式图。
 *  可以用BFS也可以用DFS搜索 感觉是BFS更快一些
 */
public class WordLadder {
  public static void main(String[] args) {
    String start = "hit";
    String end = "dff";
    String[] dict = new String[]{"hot","dot","dog","lot","log"};
    boolean result = wordLadder(start, end, dict);
    System.out.println(result);
  }
  private static boolean wordLadder(String start, String end, String[] dict) {
    Set<String> visited = new HashSet<>();
    Set<String> ladder = new HashSet<>(Arrays.asList(dict));
    Queue<String> queue = new LinkedList<>();
    queue.offer(start);
    while(!queue.isEmpty()) {
      String str = queue.poll();
      for(String node : getNeighbours(str)) {
        if(node.equals(end)) {
          return true;
        }
        if(visited.contains(node)) {
          continue;
        }
        if(!ladder.contains(node)) {
          continue;
        }
        queue.offer(node);
        visited.add(node);
      }
    }
    return false;
  }

  //生成每个node的neighbour - 对每个单词生成变一个字母的所有string
  private static List<String> getNeighbours(String value) {
    List<String> list = new ArrayList<>();
    for(int i = 0; i < value.length(); i++) {
      char[] chars = value.toCharArray();
      for(char c = 'a'; c <= 'z'; c++) {
        chars[i] = c;
        list.add(String.valueOf(chars));
      }
    }
    return list;
  }
}
