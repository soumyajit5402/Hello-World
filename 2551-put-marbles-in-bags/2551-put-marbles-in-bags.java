class Solution {
    public long putMarbles(int[] weights, int k) {
        /*
        To split into k bags,
        we actually choose k-1 cut points:
        A[0]...A[i1]
        A[i1+1]....A[i2]
        A[i2+1]....A[i3]
        ....
        A[ik+1]....A[n-1]

        The result score is:
        (A[0] + A[i1]) + (A[i2] + A[i3]) +..... + (A[ik+1] + A[n-1])
        equals to
        A[0] + (A[i1] + A[i1+1]) + (A[i2] + A[i2+1]) + ....

        So the problem turns out to be,
        calculate the max/min sum of k - 1 numbers in
        A[0] + A[1], A[1] + A[2],..., A[n-1] + A[n].
        */
        
        int[] input = new int[weights.length - 1];
        for (int i = 0; i < input.length; i++) input[i] = weights[i] + weights[i + 1];
        Arrays.sort(input);
        
        long diff = 0l;
        for (int i = 0, j = input.length - 1; i < k - 1; i++, j--) diff += (long)(input[j] - input[i]);
        return diff;
    }
}