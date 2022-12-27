public class LeetcodeQ1 {

    public static void main(String[] args) {
        char[] arr = {'a','d','e','g','m','p'};
        System.out.println(ceilingofchar(arr,'q'));

    }

    static char ceilingofchar(char[] array,char target){
        int start = 0;
        int end = array.length-1;

        while (start<=end){
            int mid = start+(end-start)/2;
            if (array[mid] > target){
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return array[start%(array.length)];

    }

}
