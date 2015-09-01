package learn.util;

public abstract class ShapeUtil {

    public static void notNegativeCheck(double x) {
        if (x < 0.0) {
            throw new IllegalArgumentException(
                    "The input value may not be negative.");
        }
    }
}
