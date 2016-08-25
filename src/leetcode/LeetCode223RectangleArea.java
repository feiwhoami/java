/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * 
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * 
 * Rectangle Area
 * Assume that the total area is never beyond the maximum possible value of int.
 */
package leetcode;

public class LeetCode223RectangleArea {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int first = (C - A) * (D - B);
        int second = (G - E) * (H - F);

        long minCG = Math.min(C, G);
        long maxAE = Math.max(A, E);

        long minDH = Math.min(D, H);
        long maxBF = Math.max(B, F);

        long x = minCG - maxAE;
        long y = minDH - maxBF;

        long overlap = Math.max(x, 0) * Math.max(y, 0);

        return (int) (first + second - overlap);
    }
}
