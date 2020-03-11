package io.fengchao.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsLint {

  public static void main(String[] args) {
    boolean[][] input = new boolean[][]{{true,true,false,false,false},
        {false,true,false,false,true},{false,false,false,true,true},
        {false,false,false,false,false},{false,false,false,false,true}};

    NumberOfIslandsLint numberOfIslandsLint = new NumberOfIslandsLint();
    int result = numberOfIslandsLint.numIslands(input);
    System.out.println(result);
  }
    public int numIslands(boolean[][] grid) {
      // write your code here
      if(grid.length== 0 || grid[0].length == 0) return 0;
      int m = grid.length;
      int n = grid[0].length;


      int res = 0;
      for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
          if(grid[i][j]){
            bfs(grid, i, j, m ,n);
            res++;
          }
        }
      }
      return res;

    }
    private void bfs(boolean[][] grid, int x, int y, int m, int n){
      int[] dx = {0, 0, 1, -1};
      int[] dy = {1, -1, 0, 0};

      Queue<Integer> qx = new LinkedList<>();
      Queue<Integer> qy = new LinkedList<>();
      qx.offer(x);
      qy.offer(y);
      grid[x][y] = false;

      while(!qx.isEmpty()){
        int cx = qx.poll();
        int cy = qy.poll();
        for(int i = 0; i < 4; i++){
          int nx = cx + dx[i];
          int ny = cy + dy[i];
          if(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny]){
            grid[nx][ny] = false;
            qx.offer(nx);
            qy.offer(ny);

          }
        }

      }

    }

  public static void bubbleSort(int[] arr) {
    int len = arr.length;
    for (int i = 0; i < len; i++) {
      for (int j = 1; j < len - i; j++) {
        if (arr[j - 1] > arr[j]) {
          int tmp = arr[j - 1];
          arr[j - 1] = arr[j];
          arr[j] = tmp;
        }
      }
    }
  }

}
