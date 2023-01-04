public class Rotationcount {

    public static void main(String[] args) {
        int[] arr = {5,6,7,8,0,1,2,3,4};
        System.out.println(rotationcount(arr));
    }


    static int rotationcount(int[] array){
        int pivot = getpivot(array);
        return pivot+1;
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
}
