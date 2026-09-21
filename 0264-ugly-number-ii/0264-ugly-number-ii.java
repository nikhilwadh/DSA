class Solution {
    public int nthUglyNumber(int n) {

        /*PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();

        pq.add(1L);
        set.add(1L);

        for (int i = 1; i < n; i++) 
        {
            long curr = pq.poll();
            long a = curr * 2;
            long b = curr * 3;
            long c = curr * 5;

            if (set.add(a)) {
                pq.add(a);
            }
            if (set.add(b)) {
                pq.add(b);
            }
            if (set.add(c)) {
                pq.add(c);
            }
        }

        return pq.poll().intValue();*/

        int[] arr = new int[n];
        arr[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0;

        for (int i = 1; i < n; i++) {

            int n2 = arr[i2] * 2;
            int n3 = arr[i3] * 3;
            int n5 = arr[i5] * 5;

            int next = Math.min(n2, Math.min(n3, n5));

            arr[i] = next;

            if (n2 == next) i2++;
            if (n3 == next) i3++;
            if (n5 == next) i5++;
        }

        return arr[n - 1];
    }
}