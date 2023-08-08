class Solution {
    public void duplicateZeros(int[] arr) {
        int end = arr.length-1 ; 
        int zerocounter = 0 ; 
        int rightTrim = 0 ; 
        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i] == 0 ) zerocounter++;
            if(i == end) break;
            if(arr[i] == 0 ) {
                rightTrim++;
                end--;
            }
            if(i == end) break;
        }

        int y = arr.length - 1;
        for (int x = end; x >= 0; x--) {
            if (x == end && arr[x] == 0 && zerocounter > rightTrim) {
                arr[y--] = 0;
            } else if (arr[x] == 0) {
                arr[y--] = 0;
                arr[y--] = 0;
            } else {
                arr[y--] = arr[x];
            }
        }
    }
}