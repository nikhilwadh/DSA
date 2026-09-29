class Solution {
    public int maximalSquare(char[][] matrix) {
        int side = 0;
        int r = matrix.length;
        int c = matrix[0].length;
        char ans[][] = new char[r][c];
        for (int i = 0; i < matrix.length; i++) {
            ans[i][0] = matrix[i][0];

            if(matrix[i][0] == '1')
                side = 1;
        }
        for (int i = 1; i < matrix[0].length; i++) {
            ans[0][i] = matrix[0][i];

            if(matrix[0][i] == '1')
                side = 1;
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][j] == '1') {
                    int curr = Math.min(
                            ans[i][j - 1] - '0',
                            Math.min(
                                    ans[i - 1][j] - '0',
                                    ans[i - 1][j - 1] - '0'))
                            + 1;
                    side = Math.max(side, curr);
                    ans[i][j] = (char) ('0' + curr);
                } else {
                    ans[i][j] = '0';
                }
            }
        }
        return side * side;
    }
}