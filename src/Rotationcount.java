public class Rotationcount {

    public static void main(String[] args) {
        int[] arr = {5,6,7,8,0,1,2,3,4};
        int[] arr4 = {2,2,2,2,3,5,1,2};
        System.out.println(rotationcount(arr));
        System.out.println(rotationcount(arr4));

    }


    static int rotationcount(int[] array){
        //int pivot = getpivot(array);
        int pivot1 = getpivotduplicate(array);
        return pivot1+1;
    }

    static int getpivot(int[] array){
        int start = 0;
        int end  = array.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if (mid<end && array[mid]>array[mid+1]){
                return mid;
            }else if (mid>start && array[mid]<array[mid-1]){
                return mid-1;
            } else if (array[start]>array[mid]) {
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }

    static int getpivotduplicate(int[] array){
        int start = 0;
        int end = array.length-1;
        while (start<=end){
            int mid = start+(end-start)/2;
            if (mid<end && array[mid]>array[mid+1]){
                return mid;
            }else if(mid>start && array[mid]<array[mid-1]){
                return mid-1;
            } else if (array[start] == array[mid] && array[end] == array[mid]) {
                //check whether start and elements are pivots
                if (array[start]>array[start+1]){
                    return start;
                }
                start++;
                if (array[end]<array[end-1]){
                    return end-1;
                }
                end--;
            } else if (array[start]<array[mid] || (array[mid] == array[start] && array[mid]>array[end])) {
                start = mid+1;
            }else {
                end = mid-1;
            }

        }
        return -1;
    }
}
