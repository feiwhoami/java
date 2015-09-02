package learn.util;

public abstract class ShapeUtil {

    private static final String NOT_NEGATIVE_CHECK = "%s may not be negative";

    public static void notNegativeCheck(double x, String s) {
        if (x < 0.0) {
            String message = String.format(NOT_NEGATIVE_CHECK, s);
            throw new IllegalArgumentException(message);
        }
    }
}
