package jk.sorts;

import jk.utils.SortUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: zhangjk
 * Date: 14-3-16
 * Time: 下午4:03
 * 排序后的顺序为从小到大
 */
public class Sorts {


    /**
     * 冒泡排序
     * <p/>
     * 假设有n个元素
     * 第一次遍历0-n-1(索引），相邻的两个元素进行比较，如果前一个大于后一个，
     * 将两个元素进行交换，遍历完成后最大元素移动最后面
     * 第二次遍历0-n-2
     * ....
     * 如果一次遍历数组元素没有发生交换，证明数组已经排好序
     * <p/>
     * 稳定的排序
     *
     * @param array
     */
    public static void bulletSort(int[] array) {
        //是否发生交换
        boolean flag;
        for (int i = array.length - 1; i > 0; i--) {
            flag = false;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    SortUtil.change(array, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 直接选择排序
     * <p/>
     * 首先在未排序的序列中选择最大值，放到序列中的最后，
     * 再从剩余的元素中选择最大值，放到剩余元素的最后
     * 以此类推，直到排序完成
     * <p/>
     * 是不稳定的排序 例如2,10,5,9,5 第一遍排序后，10和5会交换位置，
     * 从而使两个5的次序发生变化
     *
     * @param array
     */
    public static void selectSort(int[] array) {
        int index;
        //是否排好序
        boolean sorted;
        for (int i = array.length - 1; i > 0; i--) {
            sorted = true;
            index = 0;
            for (int j = 0; j <= i; j++) {
                if (array[index] <= array[j]) {
                    index = j;
                } else {
                    sorted = false;
                }
            }
            // System.out.println(flag);
            if (sorted)
                break;
            SortUtil.change(array, index, i);
        }
    }


    /**
     * 直接插入排序
     * <p/>
     * 从第i个(i=1)开始，将第i个插入到前i-1个已排好序的数列当中，
     * 插入后数列还是排好序的，知道整个数列都排好序
     * <p/>
     * 稳定的排序
     *
     * @param array
     */
    public static void insertSort(int[] array) {
        int value, j;
        for (int i = 1; i < array.length; i++) {
            value = array[i];
            for (j = i - 1; j >= 0 && value < array[j]; j--) {
                array[j + 1] = array[j];
            }
            /*for (j = i - 1; j >= 0; j--) {
                if (value < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }*/
            array[j + 1] = value;
        }
    }

    /**
     * 希尔排序，是插入排序的一种，分组插入排序
     * <p/>
     * 先取一个正整数d1<n作为第一个增量,把所有序号相隔为d1的元素作为一组，
     * 在组内进行直接插入排序，然后取d2<d1,重复上述过程
     * 直到di取到1,即所有元素放到同一个组中进行直接插入排序
     * <p/>
     * 不稳定排序
     *
     * @param array
     */
    public static void shellSort(int[] array) {
        int k, value;
        for (int i = array.length / 2; i > 0; i /= 2) {
            for (int j = i; j < array.length; j++) {
                value = array[j];
                for (k = j - i; k >= 0 && array[k] > value; k -= i) {
                    array[k + i] = array[k];
                }
                array[k + i] = value;
            }
        }
    }


    /**
     * 箱子排序（只能排0-10，因为只设置了11个箱子）
     * <p/>
     * 设置若干个箱子（每个箱子用一个队列表示），依次扫描待排序的记录，
     * 把关键字等于k的放到第k个箱子中，然后按序号依次将各非空箱子首尾连接收集起来
     * <p/>
     * 稳定的排序
     * <p/>
     * 桶排序：箱子排序的变种，每个桶存储一个范围内的数据，对桶内的数据进行稳定排序
     * 然后按桶的顺序收集起来
     *
     * @param array
     */
    public static void binSort(int[] array) {
        Queue<Integer>[] queues = new Queue[11];
        for (int i = 0; i < array.length; i++) {
            if (queues[array[i]] == null)
                queues[array[i]] = new LinkedList<Integer>();
            queues[array[i]].offer(array[i]);
            System.out.println(array[i]);
        }
        int index = 0;
        for (Queue<Integer> queue : queues) {
            while (queue != null && queue.size() != 0) {
                array[index++] = queue.poll();
            }
        }
    }


    /**
     * 基数排序（可排0-999）
     * <p/>
     * 从低位到高位，首先按个位的数字进行排序，排好后收集起来，
     * 再按照十位的数字进行排序，排好后收集起来，依次类推
     * <p/>
     * 稳定的排序
     *
     * @param array
     */
    public static void radixSort(int[] array) {
        Queue<Integer>[] queues = new Queue[10];
        for (int i = 0; i < queues.length; i++) {
            queues[i] = new LinkedList<Integer>();
        }
        int num;
        for (int n = 0; n < 3; n++) {
            for (int i = 0; i < array.length; i++) {
                num = (array[i] / (int) Math.pow(10, n)) % 10;
                queues[num].offer(array[i]);
            }

            int index = 0;
            for (Queue<Integer> queue : queues) {
                while (queue.size() != 0) {
                    array[index++] = queue.poll();
                }
            }
        }
    }


    /**
     * 快速排序
     * <p/>
     * 采用分而治之的思想，首先从要排序的数据中选取一个数据作为基准，
     * 所有比基准小的数据放在左侧，比基准大的数据放在右侧，从而将数据分为了3段
     * 左段left，中段middle和右段right，中段只包含一个数字，即刚才所选取的基准
     * 然后对左端和右段的数据分别进行快速排序，递归的进行直到排序完成
     * <p/>
     * 不稳定的排序
     *
     * @param array
     * @param left
     * @param right
     */
    public static void quickSort(int[] array, int left, int right) {

        if (left >= right)
            return;
        int i = left;
        int j = right;
        int middle = array[left];
        while (i < j) {
            while (i < j && array[j] > middle) {
                j--;
            }
            if (i < j)
                array[i++] = array[j];
            while (i < j && array[i] < middle) {
                i++;
            }
            if (i < j) {
                array[j--] = array[i];
            }
        }
        array[i] = middle;
        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);
    }
}
