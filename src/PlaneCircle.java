package src;

public class PlaneCircle extends Circle {
    // We automatically inherit the fields and methods of Circle,
    // so we only have to put the new stuff here.
    // New instance fields that store the center point of the circle
    private final Point p;

    // A new constructor to initialize the new fields
    // It uses a special syntax to invoke the Circle() constructor
    public PlaneCircle(double r, Point p) {
        super(r); // Invoke the constructor of the superclass, Circle()
        this.p = p;
    }

    public Point getCenterPoint() {
        return p;
    }

    public double getCentreX() {
        return p.getX();
    }

    public double getCentreY() {
        return p.getY();
    }

    // The area() and circumference() methods are inherited from Circle
    // A new instance method that checks whether a point is inside the circle
    // Note that it uses the inherited instance field r
    public boolean isInside(double x, double y) {
        double dx = x - p.getX();
        double dy = y - p.getY(); // Distance from center
        double distance = Math.sqrt(dx * dx + dy * dy); // Pythagorean theorem
        return (distance < r); // Returns true or false
    }

}
