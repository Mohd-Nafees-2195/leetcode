class Solution {
    public void rotate(int[][] matrix) {
        int i = 0, j = 0, n = matrix.length;
        while (i < n / 2) {
            j = i;
            while (j < n - i - 1) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
                j++;
            }
            i++;
        }
    }
}