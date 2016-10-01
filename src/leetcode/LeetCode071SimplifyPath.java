/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 */
package leetcode;

import java.util.Stack;

public class LeetCode071SimplifyPath {

    public String simplifyPath(String path) {

        StringBuilder result = new StringBuilder();
        if (null == path) {
            return result.toString();
        }

        String[] pathSplit = path.split("/");
        Stack<String> s1 = new Stack<>();

        for (int i = 0; i < pathSplit.length; i++) {
            if (pathSplit[i].equals(".") || pathSplit[i].isEmpty()) {
                continue;
            } else if (pathSplit[i].equals("..")) {
                if (!s1.isEmpty()) {
                    s1.pop();
                }
            } else {
                s1.push(pathSplit[i]);
            }
        }

        Stack<String> s2 = new Stack<>();
        while (!s1.empty()) {
            s2.push(s1.pop());
        }

        result.append('/');
        while (!s2.isEmpty()) {
            result.append(s2.pop());
            result.append('/');
        }
        if (result.toString().length() > 1) {
            result.deleteCharAt(result.length() - 1);
        }

        return result.toString();
    }

}
