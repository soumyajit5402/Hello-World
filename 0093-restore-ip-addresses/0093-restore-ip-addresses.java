class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        split(s, 0, 0, new StringBuilder(), 0);
        return ans;
    }
    
    void split(String s, int i, int j, StringBuilder sb, int parts) {
        if (i == s.length() && j == s.length() && parts == 4) ans.add(sb.toString());
        else if (i == s.length() || j == s.length() || parts > 4) return;
        else if (j - i >= 1 && s.charAt(i) == '0') return;
        else if (j - i >= 3) return;
        else {
            int curr = Integer.parseInt(s.substring(i, j + 1));
            if (curr <= 255) {
                StringBuilder sbNew1 = new StringBuilder(sb);
                if (sbNew1.length() > 0) sbNew1.append(".");
                sbNew1.append(curr);
                split(s, j+1, j+1, sbNew1, parts+1);
                
                StringBuilder sbNew2 = new StringBuilder(sb);
                split(s, i, j+1, sbNew2, parts);
            }
        }
    }
}