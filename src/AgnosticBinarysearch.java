public class AgnosticBinarysearch {

    public static void main(String[] args) {

        int[] arr = {190,167,134,123,100,98,87,65,54,32,21};
        System.out.println(agnosbinarysearch(arr,65));

    }

    static int agnosbinarysearch(int[] array,int target){

        int start = 0;
        int end = array.length-1;

        boolean isasc = array[0] < array[end];

        while (start <= end){

            int mid = start+(end-start)/2;

            if (mid == target){
                return mid;
            }

            if (isasc){
                if (target < array[mid]){
                end = mid-1;}
                else {
                start = mid+1;}
            }
            else {
                if (target < array[mid]){
                    start = mid+1;
                }
                else {
                    end = mid-1;
                }
            }

        }
        return -1;



    }
}
