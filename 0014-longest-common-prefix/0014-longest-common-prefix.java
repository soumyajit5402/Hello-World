class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = 0;
        for (int i = 0; i < 200; i++) {
            if (strs[0].length() <= i) break;
            char curr = strs[0].charAt(i);
            boolean equal = true;
            for (String str : strs) {
                if (str.length() <= i) equal = false;
                else if (str.charAt(i) != curr) equal = false;
            }
            if (!equal) break;
            len++;
        }
        return strs[0].substring(0, len);
    }
}