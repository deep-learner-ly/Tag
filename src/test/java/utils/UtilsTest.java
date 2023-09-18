package utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {

    @org.junit.Test
    public void swap() {
        int[] nums = {5, 10};
        Utils.swap(nums, 0, 1);
        assertEquals(10, nums[0]);
        assertEquals(5, nums[1]);
    }

    @org.junit.Test
    public void testSwap() {
        Object[] objects = {"Hello", "World"};
        Utils.swap(objects, 0, 1);
        assertEquals("World", objects[0]);
        assertEquals("Hello", objects[1]);
    }

    @org.junit.Test
    public void swapPlusSub() {
        int[] nums = {5, 10};
        Utils.swapPlusSub(nums, 0, 1);
        assertEquals(10, nums[0]);
        assertEquals(5, nums[1]);
    }

    @Test
    public void transposeInPlace() {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Utils.transposeInPlace(matrix1);
        assertArrayEquals(new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}}, matrix1);

        int[][] matrix2 = {{1, 2}, {3, 4}};
        Utils.transposeInPlace(matrix2);
        assertArrayEquals(new int[][]{{1, 3}, {2, 4}}, matrix2);

    }
}