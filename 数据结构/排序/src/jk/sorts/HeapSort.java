package jk.sorts;

/**
 * Created with IntelliJ IDEA.
 * User: zhangjk
 * Date: 14-3-17
 * Time: 下午8:55
 * <p/>
 * 堆排序
 */
public class HeapSort {

    public static void sort(int[] array) {
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
        for(int i = 0; i < array.length; i++) {
            maxHeap.insert(array[i]);
        }

        for(int i = 0; i < array.length; i++) {
            System.out.print(maxHeap.deleteMax() + " ");
        }
    }
}
