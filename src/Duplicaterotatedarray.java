

public class Duplicaterotatedarray {

    public static void main(String[] args) {
        int[] arr = {5,6,7,8,0,1,2,3};
        int[] arr2 = {5,6,7,8,32,37,45};
        int[] arr3 = {2,2,2,9,2,2,2};
        int[] arr4 = {2,2,2,2,3,5,1,2};
        System.out.println(getpivot(arr3));
        System.out.println(search(arr,8));
        System.out.println(search(arr2,32));
        System.out.println(findPivotWithDuplicates(arr4));
    }

    static int search(int[] array,int target){

        int pivot = getpivot(array);
        if (pivot == -1){
            //normal array just do a binaryserach
            return binarysearch(array,target,0, array.length-1);
        } else if (target < array[0]) {
            return binarysearch(array,target,pivot+1,array.length-1);
        }else {
            return binarysearch(array,target,0,pivot);
        }
    }


//does'nt work for duplicate values
    static int getpivot(int[] array){
        int start = 0;
        int end = array.length-1;
        while (start<=end){
            int mid = start+(end-start)/2;
            if (mid<end && array[mid]>array[mid+1]){
                return mid;
            } else if (mid>start && array[mid]<array[mid-1]) {
                return mid-1;
            } else if (array[start]>array[mid]) {
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }

    //for duplicate values
    //just skip the duplicate values--->in the case where start,mid,end have same value
    //check whether the start or end element is the pivot,if not--->then skip the duplicates
    static int findPivotWithDuplicates(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid-1;
            }

            // if elements at middle, start, end are equal then just skip the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // skip the duplicates
                // NOTE: what if these elements at start and end were the pivot??
                // check if start is pivot
                if (start < end && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // check whether end is pivot
                if (end > start && arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }

            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;        // left side is sorted, so pivot should be in right
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


    static int binarysearch(int[] array,int target,int start ,int end){

        while (start<=end){
            int mid = start+(end-start)/2;
            if (target == array[mid]){
                return mid;
            }else if (target>array[mid]){
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return -1;
    }



}
