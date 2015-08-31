package learn;

public class Rectangle extends Shape {
    private double w; // Instance data
    private double h;

    public Rectangle(double w, double h) {
        // Constructor
        this.w = w;
        this.h = h;
    }

    public double getWidth() {
        return w;
    }

    public double getHeight() {
        return h;
    }

    public void setWidth(double w) {
        checkWidthOrHeight(w);
        this.w = w;
    }

    public void setHeight(double h) {
        checkWidthOrHeight(h);
        this.h = h;
    }

    public double area() {
        // Implementation of abstract methods
        return w * h;
    }

    public double circumference() {
        // Implementation of abstract methods
        return 2 * (w + h);
    }

    private void checkWidthOrHeight(double wh) {
        if (wh < 0.0) {
            throw new IllegalArgumentException(
                    "Width or Height may not be negative.");
        }
    }

}
