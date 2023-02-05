class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gIndex = 0, sIndex = 0;
        for ( ; gIndex < g.length && sIndex < s.length; sIndex++) {
            if (g[gIndex] <= s[sIndex]) gIndex++;
        }
        return gIndex;
    }
}