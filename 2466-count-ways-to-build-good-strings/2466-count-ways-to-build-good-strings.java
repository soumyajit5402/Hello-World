class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        long count = 0l, limit = 1_000_000_007l;
        long[][] counter = new long[high + 1][2];
        
        counter[zero][0] = 1l;
        counter[one][1] = 1l;
        for (int i = Math.min(zero, one); i <= high; i++) {
            if (i > zero) counter[i][0] = (counter[i - zero][0] + counter[i - zero][1]) % limit;
            if (i > one) counter[i][1] = (counter[i - one][0] + counter[i - one][1]) % limit;
            if (i >= low && i <= high) count = (count + counter[i][0] + counter[i][1]) % limit;
        }
        return (int)count;
    }
}