class Solution {
    public String convert(String s, int numRows) {
        int index = 0;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) sb[i] = new StringBuilder();
        
        while (index < s.length()) {
            for (int i = 0; i < numRows && index < s.length(); i++, index++) sb[i].append(s.charAt(index) + "");
            for (int i = numRows - 2; i > 0 && index < s.length(); i--, index++) sb[i].append(s.charAt(index) + "");
        }
        
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < numRows; i++) ans.append(sb[i].toString());
        return ans.toString();       
    }
}