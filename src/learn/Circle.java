package learn;

public class Circle {
    // A class field
    private static final double PI = 3.14159;

    // A class method: just compute a value based on the arguments
    public static double radiansToDegrees(double radians) {
        return radians * 180 / PI;
    }

    public static double getPI() {
        return PI;
    }

    // The constructor: initialize the radius field
    public Circle(double r) {
        checkRadius(r);
        this.r = r;
    }

    public Circle() {
        // this() can appear only as the first statement in a constructor
        this(1.0);
    }

    // An instance field
    private double r;

    public void setRadius(double r) {
        // Assign the argument (r) to the field (this.r)
        // Note that we cannot just say r = r
        checkRadius(r);
        this.r = r;

    }

    public double getRadius() {
        return r;
    }

    public double area() {
        // Compute the area of the circle
        return PI * r * r;
    }

    public double circumference() {
        // Compute the circumference of the circle
        return 2 * PI * r;
    }

    private void checkRadius(double radius) {
        if (radius < 0.0)
            throw new IllegalArgumentException("radius may not be negative.");
    }

}