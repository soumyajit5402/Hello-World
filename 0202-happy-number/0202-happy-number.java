class Solution {
    public boolean isHappy(int n) {
        Set<Integer> container = new HashSet<>();
        while (!container.contains(n) && n != 1) {
            container.add(n);
            int newn = 0;
            while (n != 0) {
                int x = n % 10;
                n = n / 10;
                newn += x * x;
            }
            n = newn;
        }
        return n == 1;
    }
}