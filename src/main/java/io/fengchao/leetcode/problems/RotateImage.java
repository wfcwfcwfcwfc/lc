package io.fengchao.leetcode.problems;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix1);
    }


    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int len = n - 1;
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        printMatrix(matrix);
        for(int i = 0; i < n / 2; i++) {
            for(int j = 0; j <= (n + 1) / 2; j++) {
                printMatrix(matrix);
                System.out.println(i + ", " + j);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - j][i];
                matrix[len -j][i] = matrix[len - i][len - j];
                matrix[len - i][len - j] = matrix[j][len - i];
                matrix[j][len - i] = temp;
            }

        }
        System.out.println("123");
    }

    private static void printMatrix(int[][] matrix) {
        for(int[] row : matrix) {
            for(int val : row) {
                System.out.print(val + ", ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
