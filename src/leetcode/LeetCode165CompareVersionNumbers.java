/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * 
 * Here is an example of version numbers ordering:
 * 
 * 0.1 < 1.1 < 1.2 < 13.37
 */
package leetcode;

public class LeetCode165CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {

        if (null == version1 || null == version2 || version1.equalsIgnoreCase(version2)) {
            return 0;
        }

        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");

        int i = 0;
        while (i < nums1.length && i < nums2.length) {
            if (Integer.valueOf(nums1[i]) > Integer.valueOf(nums2[i])) {
                return 1;
            } else if (Integer.valueOf(nums1[i]) < Integer.valueOf(nums2[i])) {
                return -1;
            }
            i++;
        }

        if (nums1.length > nums2.length) {
            while (i < nums1.length) {
                if (0 != Integer.valueOf(nums1[i])) {
                    return 1;
                }
                i++;
            }
        } else if (nums1.length < nums2.length) {
            while (i < nums2.length) {
                if (0 != Integer.valueOf(nums2[i])) {
                    return -1;
                }
                i++;
            }
        }

        return 0;
    }
}
