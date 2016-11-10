/**
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
 * 
 * The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
 * 
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 * 
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 * 
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 * 
 * For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 * 
 * -2 (K)  -3  3
 * -5  -10 1
 * 10  30  -5 (P)
 * 
 * Notes:
 * 
 * The knight's health has no upper bound.
 * Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 */
package leetcode;

public class LeetCode174DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {

        int row = dungeon.length;
        if (0 == row) {
            return 1;
        }
        int column = dungeon[0].length;

        int[][] min = new int[row][column];

        min[row - 1][column - 1] = dungeon[row - 1][column - 1] < 0 ? dungeon[row - 1][column - 1] : 0;

        for (int i = row - 2; i >= 0; i--) {
            min[i][column - 1] = Math.min(0, min[i + 1][column - 1] + dungeon[i][column - 1]);
        }
        for (int j = column - 2; j >= 0; j--) {
            min[row - 1][j] = Math.min(0, min[row - 1][j + 1] + dungeon[row - 1][j]);
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = column - 2; j >= 0; j--) {

                int down = Math.min(0, min[i + 1][j] + dungeon[i][j]);
                int right = Math.min(0, min[i][j + 1] + dungeon[i][j]);

                min[i][j] = Math.min(0, Math.max(down, right));
            }
        }

        return min[0][0] * -1 + 1;
    }

}
