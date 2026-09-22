class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int m = Math.abs(a - x);
            int n = Math.abs(b - x);
            if (m != n)
                return Integer.compare(n, m);

            return Integer.compare(b, a);
        });

        for (int ar : arr) {
            pq.add(ar);

            if (pq.size() > k)
                pq.poll();
        }

        List<Integer> ans = new ArrayList<>(k);

        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }

        Collections.sort(ans);

        return ans;
    }
}