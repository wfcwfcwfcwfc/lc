package io.fengchao.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

class NumberOfIslands {
  public static void main(String[] args) {
    NumberOfIslands numberOfIslands = new NumberOfIslands();
    char[][] input1 = {
        {'1', '1', '0', '1'},
        {'1', '1', '0', '1'},
        {'1', '1', '0', '1'},
        {'1', '1', '0', '1'},
        {'1', '1', '0', '1'}
    };

    int result = numberOfIslands.numIslands(input1);
    System.out.println(result);
  }

  public int numIslands(char[][] grid) {
    if(grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int counter = 0;
    for(int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid[0].length; j++) {
        if(grid[i][j] == '1') {
          counter++;
          bfs(grid, i, j);
        }
      }
    }
    return counter;
  }

  private void dfs(char[][] grid, int x, int y) {
    if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length
        || grid[x][y] == '0') {
      return;
    }
    grid[x][y] = '0';
    dfs(grid, x - 1, y);
    dfs(grid, x + 1, y);
    dfs(grid, x , y + 1);
    dfs(grid, x, y - 1);
  }


  private void bfs(char[][] grid, int x, int y) {
    Queue<Integer[]> queue = new LinkedList<>();
    queue.offer(new Integer[]{x, y});
    while(!queue.isEmpty()) {
      Integer[] point = queue.poll();
      int xpos = point[0];
      int ypos = point[1];
      if(xpos < 0 || xpos >= grid.length || ypos < 0 || ypos >= grid[0].length
          || grid[xpos][ypos] == '0') {
        continue;
      }
      grid[point[0]][point[1]] = '0';
      queue.offer(new Integer[]{xpos - 1, ypos});
      queue.offer(new Integer[]{xpos + 1, ypos});
      queue.offer(new Integer[]{xpos, ypos - 1});
      queue.offer(new Integer[]{xpos, ypos + 1});

    }
  }
}
