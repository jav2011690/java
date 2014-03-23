package jk.sorts;

/**
 * Created with IntelliJ IDEA.
 * User: zhangjk
 * Date: 14-3-23
 * Time: 下午5:31
 * 二路归并排序
 * <p/>
 * 将两个（或两个以上）的有序表合成一个新的有序表，
 * 即将要排序的序列分为若干个子序列，每个序列都是
 * 有序的，然后再把有序的子序列合并成整体有序序列
 * <p/>
 * 稳定的排序
 */
public class MergeSort {

    /**
     * 划分序列，并合并
     *
     * @param array
     * @param left
     * @param right
     */
    public static void sort(int[] array, int left, int right) {
        if (left >= right)
            return;
        int mid = (left + right) / 2;
        sort(array, left, mid);
        sort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    /**
     * 合并序列，要合并的序列还是在一个数组中，使用left，mid，right三个参数
     * 来划分序列，left-mid个元素为一个序列，mid+1-right元素为另一个序列
     *
     * @param array
     * @param left
     * @param mid
     * @param right
     */
    public static void merge(int[] array, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int[] tempArray = new int[right - left + 1];
        int index = 0;
        while (i <= mid && j <= right) {
            if (array[i] < array[j]) {
                tempArray[index++] = array[i];
                i++;
            } else {
                tempArray[index++] = array[j];
                j++;
            }
        }

        while (i <= mid) {
            tempArray[index++] = array[i++];
        }

        while (j <= right) {
            tempArray[index++] = array[j++];
        }

        index = left;
        for (; index <= right; index++) {
            array[index] = tempArray[index - left];
        }

    }
}
