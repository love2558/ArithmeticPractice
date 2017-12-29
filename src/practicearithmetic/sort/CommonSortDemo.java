package practicearithmetic.sort;


import java.util.Arrays;

public class CommonSortDemo {

    public static void main(String[] args) {
        int[] a = {12,4,13,16,6,21,1};
        InsertSort.insertSort(a);
    }
}
/**
 * <p>插入排序</p>
 * <ul>
 *     <li>稳定，时间复杂度 O(n^2)</li>
 * </ul>
 * Created by lihao on 2017/12/29.
 */
class InsertSort{

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            for (; j >= 0 && array[j] > temp; j--) {
                //将大于temp的值整体后移一个单位
                array[j + 1] = array[j];
            }
            System.out.println(j);
            array[j + 1] = temp;
        }
        System.out.println(Arrays.toString(array) + " insertSort");
    }

    public static void main(String[] args) {
//        int[] a = {12,4,11,16,6,21,1};
        int[] a = {5,4,3,2,1};
        insertSort(a);
    }
}

/**
 * <p>选择排序</p>
 * <ul>
 *     <li>不稳定，时间复杂度 O(n^2)</li>
 * </ul>
 * Created by lihao on 2017/12/29.
 */
class SelectSort{

    public static void selectSort(int[] array) {
        int position = 0;
        for (int i = 0; i < array.length; i++) {
            int j = i + 1;
            position = i;
            int temp = array[i];
            for (; j < array.length; j++) {
                if (array[j] < temp) {
                    temp = array[j];
                    position = j;
                }
            }
            array[position] = array[i];
            array[i] = temp;
        }
        System.out.println(Arrays.toString(array) + " selectSort");
    }

    public static void main(String[] args) {
        int[] a = {12,4,11,16,6,21,1};
        selectSort(a);
    }
}

/**
 * <p>冒泡排序</p>
 * <ul>
 *     <li>稳定，时间复杂度 O(n^2)</li>
 * </ul>
 * Created by lihao on 2017/12/29.
 */
class BubbleSort{
    public static void bubbleSort(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array) + " bubbleSort");
    }

    public static void main(String[] args) {
        int[] a = {12,4,11,16,6,21,1};
        bubbleSort(a);
    }
}

/**
 * <p>快速排序</p>
 * <ul>
 *     <li>不稳定，时间复杂度 最理想 O(nlogn) 最差时间O(n^2)</li>
 * </ul>
 * Created by lihao on 2017/12/29.
 */
class QuickSort{
    public static void main(String[] args) {
        int[] a = {12,4,11,16,6,21,1};
        quickSort(a);
    }
    public static void quickSort(int[] array) {
        _quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array) + " quickSort");
    }

    private static int getMiddle(int[] list, int low, int high) {
        int tmp = list[low];    //数组的第一个作为中轴
        while (low < high) {
            while (low < high && list[high] >= tmp) {
                high--;
            }

            list[low] = list[high];   //比中轴小的记录移到低端
            while (low < high && list[low] <= tmp) {
                low++;
            }

            list[high] = list[low];   //比中轴大的记录移到高端
        }
        list[low] = tmp;              //中轴记录到尾
        return low;                  //返回中轴的位置
    }

    private static void _quickSort(int[] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high);  //将list数组进行一分为二
            _quickSort(list, low, middle - 1);      //对低字表进行递归排序
            _quickSort(list, middle + 1, high);      //对高字表进行递归排序
        }
    }
}

