class Solution {
    public int splitNum(int num) {
        int index = 0;
        int[] digits = new int[10];
        while (num > 0) {
            digits[index++] = num % 10;
            num /= 10;
        }
        
        Arrays.sort(digits);
        
        int sum = 0, mult = 1;
        for (int i = 9; i >= 0; i -= 2) {
            sum += mult * (digits[i] + digits[i - 1]);
            mult *= 10;
        }
        return sum;
    }
}