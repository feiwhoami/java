package main;

import leetcode.LeetCode443StringCompression;

public class Main {

    public static void main(String[] args) {
        HelloWorld.sayHelloWorld();
//        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        char[] chars = {'a'};
        LeetCode443StringCompression solution = new LeetCode443StringCompression();

        int compress = solution.compress(chars);

    }
}
