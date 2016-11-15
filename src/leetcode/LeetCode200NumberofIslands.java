/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * 
 * Example 2:
 * 
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 */
package leetcode;

public class LeetCode200NumberofIslands {

    public int numIslands(char[][] grid) {

        if (null == grid || grid.length == 0) {
            return 0;
        }

        int totalIslands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    totalIslands++;
                    numIslands(grid, visited, i, j);
                }
            }
        }

        return totalIslands;
    }

    private void numIslands(char[][] grid, boolean[][] visited, int i, int j) {

        visited[i][j] = true;

        if (i + 1 < grid.length && grid[i + 1][j] == '1' && !visited[i + 1][j]) {
            numIslands(grid, visited, i + 1, j);
        }
        if (i - 1 >= 0 && grid[i - 1][j] == '1' && !visited[i - 1][j]) {
            numIslands(grid, visited, i - 1, j);
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == '1' && !visited[i][j + 1]) {
            numIslands(grid, visited, i, j + 1);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1' && !visited[i][j - 1]) {
            numIslands(grid, visited, i, j - 1);
        }

        return;
    }
}
