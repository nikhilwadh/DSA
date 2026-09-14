class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) {
            return false;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int h : hand) {
            pq.add(h);
            map.put(h, map.getOrDefault(h, 0) + 1);
        }

        while (!pq.isEmpty()) {

            int first = pq.poll();

            if (!map.containsKey(first)) {
                continue;
            }

            for (int i = 0; i < groupSize; i++) {

                int card = first + i;

                if (!map.containsKey(card)) {
                    return false;
                }

                map.put(card, map.get(card) - 1);

                if (map.get(card) == 0) {
                    map.remove(card);
                }
            }
        }

        return true;
    }
}