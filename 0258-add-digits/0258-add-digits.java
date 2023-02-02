class Solution {
    public int addDigits(int num) {
        int temp = 0;
        while (num > 9) {
            while(num != 0) {
                int curr = num % 10;
                num = num / 10;
                temp += curr;
            }
            num = temp;
            temp = 0;
        }
        return num;
    }
}