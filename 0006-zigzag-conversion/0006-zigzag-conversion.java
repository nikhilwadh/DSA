class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        int a = numRows - 1;
        int b = a - 1;
        StringBuilder st = new StringBuilder();
        int cycle = a + b + 1;

        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += cycle) {
                st.append(s.charAt(j));

                int diagonal = j + cycle - 2 * i;

                if (i != 0 && i != numRows - 1 &&
                        diagonal < s.length()) {
                    st.append(s.charAt(diagonal));
                }
            }
        }
        return st.toString();
    }
}