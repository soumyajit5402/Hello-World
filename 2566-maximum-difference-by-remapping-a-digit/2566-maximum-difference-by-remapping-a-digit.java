class Solution {
    public int minMaxDifference(int num) {
        char key = ' ';
        
        char[] max = (new String(num + "")).toCharArray();
        for (int i = 0; i < max.length; i++) {
            if (max[i] == '9') continue;
            else if (key == ' ') {
                key = max[i];
                max[i] = '9';
            }
            else if (max[i] == key) max[i] = '9';
            else continue;
        }
        
        key = ' ';
        char[] min = (new String(num + "")).toCharArray();
        for (int i = 0; i < max.length; i++) {
            if (min[i] == '0') continue;
            else if (key == ' ') {
                key = min[i];
                min[i] = '0';
            }
            else if (min[i] == key) min[i] = '0';
            else continue;
        }
        
        int maxVal = Integer.parseInt(new String(max));
        int minVal = Integer.parseInt(new String(min));
        return maxVal - minVal;
    }
}