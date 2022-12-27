public class Ceilingofnum {

    public static void main(String[] args) {

        int[] arr = {12,34,56,67,78,79,90,91,94,99,109};
        System.out.println(getceiling(arr,111));
        System.out.println(getfloor(arr,1));
    }

    static int  getceiling(int[] array,int target){         //return the smallest element greater than or equal to target!!!

        int start =0;
        int end = array.length-1;
        while (start<=end){
            int mid = start+(end-start)/2;
            if (target < array[mid]){
                end = mid-1;
            } else if (target > array[mid]) {
                start = mid+1;
            }else {
                return mid;                 //when start > end(i.e. target element not in array) the loop is terminated and the target lies bw end and start
                                            //end becomes the floor an start becomes ceiling
            }
        }
        return start;                //returns array.length (index out of bounds) if the target is greater than the largest element in the array
                                     //returns an error if array element ids to be returned instead of index
    }


    static int getfloor(int[] array,int target){
        int start = 0;
        int end = array.length-1;
        while (start<=end){
            int mid = start+(end-start)/2;
            if (target<array[mid]){
                end = mid-1;
            }else if(target > array[mid]){
                start = mid+1;
            }else {
                return mid;
            }

        }

        return end;                     //returns -1 if the target is smaller than the smallest element in the array
                                        //error is displayed if it returns array element instead of index
    }
}
