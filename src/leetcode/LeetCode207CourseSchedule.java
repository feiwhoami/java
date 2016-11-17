/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * 
 * For example:
 * 
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
 * 
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 * 
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 */
package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LeetCode207CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (null == prerequisites || prerequisites.length == 0) {
            return true;
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

        boolean[] visited = new boolean[prerequisites.length];
        Set<Integer> hash = new HashSet<>();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (hash.contains(curr)) {
                return false;
            }
            hash.add(curr);
            for (int i = 0; i < prerequisites.length; i++) {
                if (!visited[i] && prerequisites[i][0] == curr) {
                    visited[i] = true;
                    int currPrereq = prerequisites[i][1];
                    map.put(currPrereq, map.get(currPrereq) - 1);
                    if (map.get(currPrereq) == 0) {
                        queue.offer(currPrereq);
                    }
                }
            }
        }

        if (hash.size() == numCourses) {
            return true;
        }
        return false;
    }
}
