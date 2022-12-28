public class SearchinMountainarray {

    public static void main(String[] args) {

        int[] arr = {1,2,5,5,5,5,6,7,8,2,1};
        System.out.println(Mountainsearch(arr,5));
    }


    static int Mountainsearch(int[] array,int target){
        int start = 0;
        int end = array.length-1;
        int ans = -1;
        while (start <= end){
            int mid = start+(end-start)/2;
            if (target > array[mid]){
                start = mid+1;
            } else {
                ans = mid;
                end = mid-1;
            }
        }
        return ans;
    }
}
