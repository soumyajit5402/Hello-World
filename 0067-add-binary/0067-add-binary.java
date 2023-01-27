class Solution {
    public String addBinary(String a, String b) {
        String a_r = new StringBuilder(a).reverse().toString();
        String b_r = new StringBuilder(b).reverse().toString();
        int len = Math.max(a.length(), b.length());
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        
        for (int i = 0; i <= len; i++) {
            int c1 = ((i >= a_r.length()) || (a_r.charAt(i) == '0')) ? 0 : 1;
            int c2 = ((i >= b_r.length()) || (b_r.charAt(i) == '0')) ? 0 : 1;
            int newNum = c1 + c2 + carry;
            if (i < len || newNum > 0) sb.append(newNum % 2);    
            carry = newNum >> 1;
        }
        
        return sb.reverse().toString();
    }
}
