public class SearchMountainarray2 {
    public static void main(String[] args) {
        int[] arr = {1,4,6,7,10,13,17,12,9,3,2,1};
        System.out.println(searchtarget(arr,1));

    }

    static int searchtarget(int[] array,int target){
        int start = 0;
        int peak = getpeakelement(array);
        int firsttry = orderagnobinarysearch(array,target,start,peak);
        if (firsttry != -1){
            return firsttry;
        }else {
            return orderagnobinarysearch(array,target,peak+1, array.length-1);
        }
    }


    static int orderagnobinarysearch(int[] array,int target,int start,int end){
        while (start<=end){
            int mid = start+(end-start)/2;
            if (array[start] < array[end]){

                if (target<array[mid]){
                    end = mid-1;
                } else if (target>array[mid]) {
                    start = mid+1;
                }else{
                    return mid;
                }
            }else {
                if (target<array[mid]){
                    start = mid+1;
                } else if (target>array[mid]) {
                    end = mid-1;
                }else{
                    return mid;
                }
            }
        }
        return -1;
    }

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
}
