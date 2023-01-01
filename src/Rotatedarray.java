public class Rotatedarray {

    public static void main(String[] args) {
        int[] arr = {3,4,5,6,7,0,1,2};
        int[] arr2 = {1,2,3,4,5,6,7,8,9};
        int[] arr3 = {2,2,2,2,3,4,5,0,1,2,2,2};
        int[] arr4 = {2,2,2,2,3,5,1,0};
        System.out.println(getpivot(arr));
        System.out.println(search(arr,1));
        System.out.println(search(arr2,8));
        System.out.println(getpivot(arr2));
        System.out.println(getpivot(arr3));
        System.out.println(getpivot(arr4));
    }


    //first get the pivot of the array
    //it is the largest element
    //the array is sorted in ascending order except for the  subarray of size one containing pivot(descending order)
    //afer getting the pivot...divide the  array into two parts and apply binary search
    //assuming the array does'nt contain duplicate values!!!!!

    static int search(int[] array,int target){
        int pivot = getpivot(array);
        if (pivot == -1){
            //not a rotated array--->just do anormal binary saerch
            return binarysearch(array,target,0, array.length-1);

        }
        //the case when pivot is found,then u have 2 sorted arrays
        //case1
        if (array[pivot] == target){
            return pivot;
        }
        //case 2 ---->if target is smaller than start---->all the elemnts before the pivot are larger than the target
        else if (array[0]>target) {
            return binarysearch(array,target,pivot+1, array.length-1);
        }
        //case 3 --->if target is graeter than start ---->all the elements after pivot are less than start,so no need to consider elements after pivot
        else {
            return binarysearch(array,target,0,pivot-1);
        }
    }

    static int getpivot(int[] array){
        int start = 0;
        int end = array.length-1;

        while (start <= end){
            int mid = start+(end-start)/2;
            if (mid<end && array[mid]>array[mid+1]){
                return mid;
            } else if (mid>start && array[mid]<array[mid-1]) {
                return mid-1;
            } else if (array[start]>=array[mid]) {
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }

    static int binarysearch(int[] array,int target,int start,int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < array[mid]) {
                end = mid - 1;
            } else if (target > array[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
