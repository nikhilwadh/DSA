class Solution {

    PriorityQueue<Integer> left =
        new PriorityQueue<>(Collections.reverseOrder());

    PriorityQueue<Integer> right =
        new PriorityQueue<>();

    HashMap<Integer, Integer> delayed = new HashMap<>();

    int leftSize = 0;
    int rightSize = 0;

    public double[] medianSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        double[] ans = new double[n - k + 1];

        // First window
        for (int i = 0; i < k; i++) {
            add(nums[i]);
        }

        ans[0] = getMedian(k);

        // Sliding window
        for (int i = k; i < n; i++) {

            int outgoing = nums[i - k];
            int incoming = nums[i];

            remove(outgoing);
            add(incoming);

            ans[i - k + 1] = getMedian(k);
        }

        return ans;
    }

    private void add(int num) {

        if (left.isEmpty() || num <= left.peek()) {
            left.offer(num);
            leftSize++;
        } else {
            right.offer(num);
            rightSize++;
        }

        balance();
    }

    private void remove(int num) {

        delayed.put(num, delayed.getOrDefault(num, 0) + 1);

        if (num <= left.peek()) {
            leftSize--;
        } else {
            rightSize--;
        }

        prune(left);
        prune(right);

        balance();
    }

    private void balance() {

        if (leftSize > rightSize + 1) {

            right.offer(left.poll());

            leftSize--;
            rightSize++;

            prune(left);

        } else if (leftSize < rightSize) {

            left.offer(right.poll());

            rightSize--;
            leftSize++;

            prune(right);
        }
    }

    private void prune(PriorityQueue<Integer> heap) {

        while (!heap.isEmpty()) {

            int num = heap.peek();

            if (!delayed.containsKey(num)) {
                break;
            }

            int count = delayed.get(num);

            if (count == 1) {
                delayed.remove(num);
            } else {
                delayed.put(num, count - 1);
            }

            heap.poll();
        }
    }

    private double getMedian(int k) {

        if (k % 2 == 1) {
            return (double) left.peek();
        }

        return ((double) left.peek() +
                (double) right.peek()) / 2.0;
    }
}