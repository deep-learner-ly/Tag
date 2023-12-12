package algorithm.array;

import junit.framework.TestCase;

public class 两数之和Test extends TestCase {

    public void testTwoSum_hh() {
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] expected1 = {0, 1};
        两数之和 two = new 两数之和();
        int[] res =two.twoSum_hh(nums1, target1);
        for (int i = 0; i < res.length; i++) {
            assert res[i]==expected1[i];
        }


    }
}