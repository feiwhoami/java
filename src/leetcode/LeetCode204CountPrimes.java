package leetcode;

public class LeetCode204CountPrimes {

    public int countPrimes(int n) {

        if (n < 2) {
            return 0;
        }

        int[] primes = new int[n];

        primes[0] = 1;
        primes[1] = 1;

        int half = n / 2 + 1;

        for (int i = 2; i <= half; i++) {
            for (int j = 2; i * j < n; j++) {
                primes[i * j] = 1;
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (primes[i] != 1) {
                result++;
            }
        }

        return result;
    }
}
