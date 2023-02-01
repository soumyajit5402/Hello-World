class Solution {
    public String countAndSay(int n) {
        String val = "1";
        while (--n > 0) {
            StringBuilder sb = new StringBuilder();
            char[] arr = val.toCharArray();
            int prev = arr[0] - '0';
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] - '0' == prev) {
                    count++;
                } else {
                    sb.append(count + "" + prev);
                    count = 1;
                }
                prev = arr[i] - '0';
            }
            sb.append(count + "" + prev);
            val = sb.toString();
            // System.out.println(val);
        }
        return val;
    }
}