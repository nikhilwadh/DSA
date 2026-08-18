class Solution {
    public String frequencySort(String s) {
        int freq[] = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char p = s.charAt(i);
            freq[p]++;
        }

        StringBuilder ans = new StringBuilder();
        while (ans.length() != s.length()) {
            int m = 0;
            int max = freq[0];
            for (int i = 1; i < 256; i++) {
                if (max < freq[i]) {
                    m = i;
                    max = freq[i];
                }
            }
            for (int i = 0; i < max; i++)
                ans.append((char) m);

            freq[m] = 0;
        }
        return ans.toString();
    }
}