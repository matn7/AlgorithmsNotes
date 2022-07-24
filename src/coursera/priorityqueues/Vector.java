package coursera.priorityqueues;

public final class Vector { // can't override instance methods
    // all instance variables private and final
    private final int n;
    private final double[] data;

    public Vector(double[] data) {
        this.n = data.length;
        // defensive copy of mutable instance variables
        this.data = new double[n];
        for (int i = 0; i < n; i++) {
            this.data[i] = data[i];
        }
    }

    // instance methods don't change instance variables
}
