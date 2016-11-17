/**
 * here are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * 
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 * 
 * For example:
 * 
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]
 * 
 * 4, [[1,0],[2,0],[3,1],[3,2]]
 * There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LeetCode210CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] found = new int[numCourses];
        int[] notFound = new int[0];
        if (prerequisites == null || prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++) {
                found[i] = i;
            }
            return found;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int prereq = prerequisites[i][1];
            if (!map.containsKey(prereq)) {
                map.put(prereq, 1);
            } else {
                map.put(prereq, map.get(prereq) + 1);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!map.containsKey(i)) {
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[prerequisites.length];
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (result.contains(curr)) {
                return notFound;
            }
            result.add(curr);
            for (int i = 0; i < prerequisites.length; i++) {
                if (!visited[i] && prerequisites[i][0] == curr) {
                    visited[i] = true;
                    int currPrereq = prerequisites[i][1];
                    map.put(currPrereq, map.get(currPrereq) - 1);
                    if (map.get(currPrereq) == 0) {
                        queue.add(currPrereq);
                    }
                }
            }
        }

        if (result.size() == numCourses) {
            for (int i = 0; i < numCourses; i++) {
                found[i] = result.get(numCourses - i - 1);
            }
            return found;
        }
        return notFound;
    }
}
