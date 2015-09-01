package learn.impl;

public class CenteredRectangle extends Rectangele implements Centered {

    private double cx, cy;

    public CenteredRectangle(double cx, double cy, double w, double h) {
        super(w, h);
        this.cx = cx;
        this.cy = cy;
    }

    public void setCenter(double x, double y) {
        this.cx = x;
        this.cy = y;
    }

    public double getCenterX() {
        return cx;
    }

    //public double getCenterY() {
     //   return cy;
   // }
}
