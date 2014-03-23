package jk.test;

import jk.sorts.HeapSort;
import jk.sorts.MergeSort;
import jk.sorts.Sorts;
import jk.utils.SortUtil;
import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: zhangjk
 * Date: 14-3-16
 * Time: 下午3:52
 */
public class SortTest extends TestCase {


    public void testBullet() {
        int[] array = {5, 1, 2, 3, 4};
        Sorts.bulletSort(array);
        SortUtil.printArray(array);
    }

    public void testSelect() {
        int[] array = {5, 2, 3, 4, 1, 6};
        Sorts.selectSort(array);
        SortUtil.printArray(array);
    }

    public void testInsert() {
        int[] array = {5, 2, 3, 4, 1, 6};
        Sorts.insertSort(array);
        SortUtil.printArray(array);
    }

    public void testShell() {
        int[] array = {5, 20, 3, 4, 1, 6,-1,19,17};
        Sorts.shellSort(array);
        SortUtil.printArray(array);
    }


    public void testBin() {
        int[] array = {5, 2, 3, 4, 1, 6, 1};
        Sorts.binSort(array);
        SortUtil.printArray(array);
    }

    public void testRadix() {
        //int[] array = {546, 112, 113, 224, 221, 557, 901,304, 305,22};
        int[] array = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        Sorts.radixSort(array);
        SortUtil.printArray(array);
    }

    public void testHeapSort() {
        //int[] array = {5, 20, 3, 4, 1, 6,-1,19,17};
        int[] array = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        HeapSort.sort(array);
    }

    public void testQuickSort() {
        //int[] array = {546, 112, 113, 224, 221, 557, 901,304, 305,22};
        int[] array = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        Sorts.quickSort(array, 0, array.length - 1);
        SortUtil.printArray(array);
    }

    public void testMergeSort() {
        //int[] array = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        int[] array = {546, 112, 113, 224, 221, 557, 901,304, 305,22};
        MergeSort.sort(array, 0, array.length-1);
        SortUtil.printArray(array);
    }
}
