class MovingAverage {
    int size;
    double sum = 0d;
    Queue<Integer> container;
    public MovingAverage(int size) {
        this.size = size;
        container = new LinkedList<>();
    }
    
    public double next(int val) {
        sum += val;
        container.add(val);
        if (container.size() > size) sum -= container.poll();
        return sum / container.size();
    }
}