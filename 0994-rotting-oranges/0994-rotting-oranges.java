class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        while (!q.isEmpty() && fresh > 0) {
            int s = q.size();

            for (int l = 0; l < s; l++) {
                int[] arr = q.poll();
                int r = arr[0];
                int c = arr[1];

                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    fresh--;
                    q.add(new int[]{r - 1, c});
                }
                if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    fresh--;
                    q.add(new int[]{r, c - 1});
                }
                if (r + 1 < rows && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    fresh--;
                    q.add(new int[]{r + 1, c});
                }
                if (c + 1 < cols && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    fresh--;
                    q.add(new int[]{r, c + 1});
                }
            }
            count++;
        }

        return fresh == 0 ? count : -1;
    }
}