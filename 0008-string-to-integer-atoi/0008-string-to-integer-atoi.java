class Solution {
    public int myAtoi(String s) {
        s = s.trim();

        if (s.length() == 0) return 0;

        int pos = 1;
        int i = 0;

        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            if (s.charAt(i) == '-') pos = -1;
            i++;
        }

        int ans = 0;

        while (i < s.length()) {
            char p = s.charAt(i);

            if (p < '0' || p > '9') break;

            int digit = p - '0';

            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return pos == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            ans = ans * 10 + digit;
            i++;
        }

        return ans * pos;
    }
}