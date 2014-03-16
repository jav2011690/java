package jk.utils;

/**
 * Created with IntelliJ IDEA.
 * User: zhangjk
 * Date: 14-3-16
 * Time: 下午2:20
 */
public class SortUtil {

    /** 打印数组中的元素 */
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * 交换数组中的两个元素
     */
    public static void change(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
