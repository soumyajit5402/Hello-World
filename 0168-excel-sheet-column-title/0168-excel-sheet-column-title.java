class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        
        // compute and store cumulative sum of powers of 26
        long[] pow_of_26 = new long[9];
        for (int i = 0; i < 8; i++) {
            pow_of_26[i + 1] = (long)Math.pow(26, i) + (i > 0 ? pow_of_26[i] : 0l);
        }
        
        int count = 9;
        while (--count > 0) {
            if (columnNumber >= pow_of_26[count]) {
                long div = pow_of_26[count] - pow_of_26[count-1];
                long mult = (long)columnNumber / div;
                columnNumber = (int)((long)columnNumber % div);
                
                if (columnNumber == 0 && count > 1) sb.append((char)('A' + mult - 2)).append('Z'); 
                else sb.append((char)('A' + mult - 1));    
            }
        }
        
        return sb.toString();
    }
}