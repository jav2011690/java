package jk.sorts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhangjk
 * Date: 14-3-17
 * Time: 下午9:01
 */
public class MaxHeap<T extends Comparable> {

    private List<T> heap = new ArrayList<T>();


    public MaxHeap() {
        //使heap的索引从1开始
        T t = null;
        heap.add(t);
    }

    public void insert(T node) {
        int i = heap.size();
        while (i != 1 && node.compareTo(heap.get(i / 2)) > 0) {
            if (i < heap.size())
                heap.set(i, heap.get(i / 2));
            else
                heap.add(i, heap.get(i / 2));
            i /= 2;
        }
        //add与set的区别，add是在第i个位置上添加一个元素，原先i及i之后的元素后移
        //set是更改第i哥位置上元素的值，如果第i个元素不存在会报错
        if (i < heap.size())
            heap.set(i, node);
        else
            heap.add(i, node);
    }

    public T deleteMax() {
        if (heap.size() <= 1) {
            System.out.println("堆为空！！！");
            return null;
        }
        T max = heap.get(1);
        int length = heap.size() - 1;
        T last = heap.get(length);
        heap.remove(length--);

        int i = 1;//堆的当前节点
        int ci = 2;//i的孩子节点
        while (ci <= length) {
            //选择i较大的孩子节点
            if (ci + 1 <= length && heap.get(ci).compareTo(heap.get(ci + 1)) < 0)
                ci++;
            //可以将last放入heap[i]
            if (last.compareTo(heap.get(ci)) >= 0)
                break;
            //将孩子上移
            heap.set(i, heap.get(ci));
            //下移一层
            i = ci;
            ci *= 2;
        }

        if (i < heap.size())
            heap.set(i, last);
        else
            heap.add(i, last);
        return max;
    }
}
