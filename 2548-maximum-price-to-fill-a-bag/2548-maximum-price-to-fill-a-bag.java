class Solution {
    public double maxPrice(int[][] items, int capacity) {
        Arrays.sort(items, (int[] a, int[] b) -> {
            double val = ((double)a[1]/(double)b[1]) - ((double)a[0]/(double)b[0]);
            if (val < 0) return -1;
            else return 1;
        });
        double price = 0.0d;
        int index = 0;
        while (capacity > 0 && index < items.length) {
            if (capacity > items[index][1]) {
                capacity -= items[index][1];
                price += items[index][0];
            } else {
                price += ((double)(items[index][0]) * capacity) / (double)items[index][1];
                capacity = 0;
            }
            index++;
        }
        if (capacity > 0) return -1.0d;
        return price;
    }
}