package io.fengchao.leetcode.problems;

class Search2DMatrix {
    public static void main(String[] args) {
        Search2DMatrix search2DMatrix = new Search2DMatrix();
        int[][] case1 = {{1}};
        int target = 1;
        search2DMatrix.searchMatrix(case1, target);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        //两种做法
        //第一种
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = findRow(matrix, target);
        if(row == -1) {
            return false;
        }
        int column = findColumn(matrix[row], target);
        return row >= 0 && column >= 0;

    }

    private int findRow(int[][] matrix, int target) {
        int s = 0;
        int e = matrix.length - 1;
        while(s + 1 < e) {
            int mid = s + (e - s) / 2;
            if(matrix[mid][0] == target) {
                return mid;
            } else if (matrix[mid][0] < target) {
                s = mid;
            } else {
                e = mid;
            }

        }

        if(matrix[e][0] <= target) {
            return e;
        }
        if(matrix[s][0] <= target) {
            return s;
        }
        return -1;
    }

    private int findColumn(int[] row, int target) {
        int s = 0;
        int e = row.length - 1;
        while(s + 1 < e) {
            int mid = s + (e - s) / 2;
            if(row[mid] == target) {
                return mid;
            } else if (row[mid] < target) {
                s = mid;
            } else {
                e = mid;
            }
        }

        if(row[s] == target) {
            return s;
        }
        if(row[e] == target) {
            return e;
        }
        return -1;

    }
}
