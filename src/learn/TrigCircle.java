package src.learn;

public class TrigCircle {
    // Here are our static lookup tables and their own initializers
    private static final int NUMPTS = 500;
    private static double sines[] = new double[NUMPTS];
    private static double cosines[] = new double[NUMPTS];

    // Here's a static initializer that fills in the arrays
    static {
        double x = 0.0;
        int i = 0;

        double delta_x = (Circle.getPI() / 2) / (NUMPTS - 1);

        for (i = 0, x = 0.0; i < NUMPTS; i++, x += delta_x) {
            sines[i] = Math.sin(x);
            cosines[i] = Math.cos(x);
        }
    }
}
