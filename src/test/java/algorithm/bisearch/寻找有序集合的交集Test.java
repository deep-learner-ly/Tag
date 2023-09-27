package algorithm.bisearch;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class 寻找有序集合的交集Test {
    private 寻找有序集合的交集  tes =  new 寻找有序集合的交集();

    @Test
    public void findCommon() {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {0, 2, 4, 5, 6, 7, 8};
        List<Integer> expected = Arrays.asList(2,4, 5);
        assertEquals(expected, tes.findCommon(array1, array2));
    }

    @Test
    public void findCommonPlus() {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {0, 2, 4, 5, 6, 7, 8};
        List<Integer> expected = Arrays.asList(2, 4, 5);
        assertEquals(expected, tes.findCommonPlus(array1, array2));
    }

    @Test
    public void testFindCommonPlus_normal() {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {4, 5, 6, 7, 8};
        List<Integer> expectedResult = Arrays.asList(4, 5);
        assertEquals(expectedResult, tes.findCommonPlus(array1, array2));
    }

    @Test
    public void testFindCommonPlus_combination() {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {6, 7, 8, 9, 10};
        List<Integer> expectedResult = Arrays.asList();
        assertEquals(expectedResult, tes.findCommonPlus(array1, array2));
    }














}