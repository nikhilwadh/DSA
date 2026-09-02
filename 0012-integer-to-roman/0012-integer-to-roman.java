class Solution {
    public String intToRoman(int num) {
        int[] vals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder st = new StringBuilder();

        for (int i = 0; i < vals.length; i++) {
            while (num >= vals[i]) {
                st.append(roman[i]);
                num -= vals[i];
            }
        }

        return st.toString();
    }
}