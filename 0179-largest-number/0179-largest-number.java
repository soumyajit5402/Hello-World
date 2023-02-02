class Solution {
    public String largestNumber(int[] nums) {
        String[] numI = new String[nums.length];
        for (int i = 0; i < nums.length; i++) numI[i] = "" + nums[i];
        
        Arrays.sort(numI, (String a, String b) -> {
            String order1 = a + b;
            String order2 = b + a;
            return -order1.compareTo(order2);
        });
        
        StringBuilder sb = new StringBuilder();
        for (String num : numI) sb.append("" + num);
        
        // trim any forward trailing 0s
        String result = sb.toString();
        if (result.charAt(0) == '0' && result.length() > 1) return "0";
        return result;
    }
}