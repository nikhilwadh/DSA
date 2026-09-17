class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a[0] != b[0])
                        return Integer.compare(a[0], b[0]);

                    return Integer.compare(a[1], b[1]);
                });
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            int arr[] = new int[2];
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0)
                    break;
                count++;
            }
            arr[0] = count;
            arr[1] = i;
            pq.add(arr);
        }
        int ans[] = new int[k];
        int n = 0;
        while (n < k && !pq.isEmpty()) {
            ans[n++] = pq.poll()[1];
        }
        return ans;
    }
}