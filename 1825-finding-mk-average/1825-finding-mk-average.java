class MKAverage {

    int m, k;

    Queue<Integer> q = new ArrayDeque<>();

    TreeMap<Integer, Integer> low = new TreeMap<>();
    TreeMap<Integer, Integer> mid = new TreeMap<>();
    TreeMap<Integer, Integer> high = new TreeMap<>();

    int lowSize = 0;
    int midSize = 0;
    int highSize = 0;

    long midSum = 0;

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
    }

    public void addElement(int num) {

        q.offer(num);

        // Until we have m elements,
        // keep everything in middle
        if (q.size() <= m) {

            add(mid, num);
            midSize++;
            midSum += num;

            // When we reach exactly m,
            // create the 3 partitions
            if (q.size() == m) {
                balance();
            }

            return;
        }

        // Window already has m elements.
        // Insert new element into appropriate group.

        if (num <= low.lastKey()) {

            add(low, num);
            lowSize++;

        } else if (num >= high.firstKey()) {

            add(high, num);
            highSize++;

        } else {

            add(mid, num);
            midSize++;
            midSum += num;
        }

        // Remove oldest
        int removed = q.poll();

        if (low.containsKey(removed)) {

            remove(low, removed);
            lowSize--;

        } else if (high.containsKey(removed)) {

            remove(high, removed);
            highSize--;

        } else {

            remove(mid, removed);
            midSize--;
            midSum -= removed;
        }

        balance();
    }

    public int calculateMKAverage() {

        if (q.size() < m)
            return -1;

        return (int)(midSum / (m - 2L * k));
    }

    private void balance() {

        // low needs exactly k elements

        while (lowSize < k) {

            int x = mid.firstKey();

            remove(mid, x);
            midSize--;
            midSum -= x;

            add(low, x);
            lowSize++;
        }

        while (lowSize > k) {

            int x = low.lastKey();

            remove(low, x);
            lowSize--;

            add(mid, x);
            midSize++;
            midSum += x;
        }

        // high needs exactly k elements

        while (highSize < k) {

            int x = mid.lastKey();

            remove(mid, x);
            midSize--;
            midSum -= x;

            add(high, x);
            highSize++;
        }

        while (highSize > k) {

            int x = high.firstKey();

            remove(high, x);
            highSize--;

            add(mid, x);
            midSize++;
            midSum += x;
        }

        // Fix low <= mid

        while (!low.isEmpty() &&
               !mid.isEmpty() &&
               low.lastKey() > mid.firstKey()) {

            int a = low.lastKey();
            int b = mid.firstKey();

            remove(low, a);
            remove(mid, b);

            add(low, b);
            add(mid, a);

            midSum += a - b;
        }

        // Fix mid <= high

        while (!mid.isEmpty() &&
               !high.isEmpty() &&
               mid.lastKey() > high.firstKey()) {

            int a = mid.lastKey();
            int b = high.firstKey();

            remove(mid, a);
            remove(high, b);

            add(mid, b);
            add(high, a);

            midSum += b - a;
        }
    }

    private void add(TreeMap<Integer, Integer> map, int x) {

        map.put(x, map.getOrDefault(x, 0) + 1);
    }

    private void remove(TreeMap<Integer, Integer> map, int x) {

        int count = map.get(x);

        if (count == 1)
            map.remove(x);
        else
            map.put(x, count - 1);
    }
}