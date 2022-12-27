public class BinarysearchSortedarray {

    public static void main(String[] args) {
            int[] array = {1,23,45,67,56,78,89,98,99,100,123,134,156,178};
            System.out.println(binarysearch(array,156));
    }

    static int binarysearch(int[] arr,int target){          //note!!!!! here we are assuming the array is sorted

        int start = 0;
        int end = arr.length-1;

        while (start <= end){

            int mid = start+(end-start)/2;
            if (target < arr[mid]){
                end = mid-1;
            } else if (target > arr[mid]){
                start = mid+1;
            }else{
                return mid;     //answer found
            }

        }
        return -1;

    }

}
