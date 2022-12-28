
//--------finding the min index of the target in a mountain array---------
public class SearchMountainarray {

    public static void main(String[] args) {

        int[] arr = {1,2,5,5,5,5,6,7,8,2,1};
        System.out.println(searchtarget(arr,5));
    }

    // first find the peak element in the array
    //then search in the left part of the array
    //if the target is not found--->search in the right part of the array
    //if the target does'nt exist return -1

    static int getpeakelement(int[] array){
        int start = 0;
        int end = array.length-1;
        while (start<end){
            int mid = start+(end-start)/2;
            if (array[mid]<array[mid+1]){
                //in ascending part of array
                start = mid+1;
            }else {
                end = mid;
            }
        }
        return start;
    }

    static int searchtarget(int[] array,int target) {
        int start = 0;
        int end = getpeakelement(array);
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > array[mid]) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        if (ans == -1) {

            start = getpeakelement(array) + 1;
            end = array.length - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (target > array[mid]) {
                    start = mid + 1;
                } else {
                    ans = mid;
                    end = mid - 1;
                }
            }
            return ans;
        }
        return ans;
    }
}
