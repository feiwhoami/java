/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * 
 * For example,
 * 
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode166FractiontoRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {

        long numeratorLong = numerator;
        long denominatorLong = denominator;

        StringBuilder result = new StringBuilder();
        if (denominatorLong == 0) {
            return result.toString();
        }
        if (numeratorLong == 0) {
            return result.append(0).toString();
        }

        boolean positive = false;
        positive = (numeratorLong > 0 && denominatorLong > 0) || (numeratorLong < 0 && denominatorLong < 0);
        if (!positive) {
            result = result.append('-');
            if (numeratorLong < 0) {
                numeratorLong = numeratorLong * -1;
            }
            if (denominatorLong < 0) {
                denominatorLong = denominatorLong * -1;
            }
        }

        result = result.append(numeratorLong / denominatorLong);

        if (numeratorLong % denominatorLong == 0) {
            return result.toString();
        }

        Map<Long, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        numeratorLong = numeratorLong % denominatorLong;
        result.append('.');
        int index = 0;

        map.put(numeratorLong, index);
        index++;

        while (numeratorLong % denominatorLong != 0) {
            numeratorLong = numeratorLong * 10;

            sb.append(numeratorLong / denominatorLong);
            numeratorLong = numeratorLong % denominatorLong;

            if (map.containsKey(numeratorLong)) {
                int start = map.get(numeratorLong);
                result.append(sb.substring(0, start));
                result.append('(');
                result.append(sb.substring(start));
                result.append(')');
                return result.toString();
            }

            map.put(numeratorLong, index);
            index++;
        }

        result.append(sb);
        return result.toString();
    }
}
