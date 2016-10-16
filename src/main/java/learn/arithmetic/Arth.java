package learn.arithmetic;

/**
 * 二分查找算法
 * Created by @Just on 2016/10/13.
 */
public class Arth {

    /**
     * 查找 key 所在数组的下标
     * @param array
     * @param start
     * @param end
     * @param key
     * @return
     */
    int binSearch(int[] array, int start, int end, int key) {
        int i =-1;
        if (start <= end) {
            int mid = (start+end)/2;
            if (key == array[mid]) {
                i= mid;
            }else if(key<mid){
                i=binSearch(array, start, mid-1, key);
            } else if (key > mid) {
                i= binSearch(array, mid + 1, end, key);
            }
        }
        return i;
    }


    int binSearch2(int array[], int dec) {
        int i = -1;
        int start =0;
        int len = array.length-1;
        while (start < len) {
            int mid = (len+start)/2;
            if(dec == array[mid]){
                i= mid;
            } else if (dec < array[mid]) {
                len = mid-1;
            }else if(dec>array[mid]){
                start = mid+1;
            }
        }
        return i;
    }

}
