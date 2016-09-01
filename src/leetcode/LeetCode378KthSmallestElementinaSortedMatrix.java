/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * 
 * Example:
 * 
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 * 
 * return 13.
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ n^2.
 */
package leetcode;

public class LeetCode378KthSmallestElementinaSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;
        int L = matrix[0][0];
        int R = matrix[n - 1][n - 1];

        while (L < R) {
            int mid = L + (R - L) / 2;
            int tmp = smallerThanMid(matrix, mid);
            if (tmp < k) {
                L = mid + 1;
            } else {
                R = mid;
            }
        }

        return L;
    }

    private int smallerThanMid(int[][] matrix, int mid) {

        int n = matrix.length;
        int i = n - 1, j = 0;

        int count = 0;

        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                j++;
                count = count + i + 1;
            } else {
                i--;
            }
        }

        return count;
    }
}
