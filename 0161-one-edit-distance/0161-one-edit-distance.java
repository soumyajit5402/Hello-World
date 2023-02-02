class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() > t.length()) return isOneEditDistance(t, s);
        
        if (s.equals(t) || Math.abs(s.length() - t.length()) > 1) return false;
        
        int sIndex = s.length() - 1, tIndex = t.length() - 1;
        while (sIndex >= 0 && tIndex >= 0) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex--;
                tIndex--;
            } else {
                boolean replace = (s.substring(0, sIndex)).equals(t.substring(0, tIndex));
                boolean delete = (tIndex == 0) || (s.substring(0, sIndex + 1)).equals(t.substring(0, tIndex));
                return replace || delete;
            }
        }
        return true;
    }
}