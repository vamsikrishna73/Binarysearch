public class InfiniteArray {

    public static void main(String[] args){
        int[] array = {3,4,5,8,9,10,100,155,165,173,189,200,203,345};
        System.out.println(ans(array,173));
    }
    static int ans(int[] array,int target){
        //first find the range
        //first start with a box of size 2
        int start = 0;
        int end = 1;

        //condition for target to lie in the range
        while (target>array[end]){
            int temp = end+1;;
            //double the box
            //end = previous end + size of box *2
            end = end+(end-start+1)*2;      //end-(start-1)=end-start+1
            start = temp;
        }
        return binarysearch(array,target,start,end);
    }

    static int binarysearch(int[] array,int target,int start,int end){
       while (start<=end){
           int mid = start+(end-start)/2;
           if (target<array[mid]){
               end = mid-1;
           } else if (target>array[mid]) {
               start = mid+1;
           }else {
               return mid;
           }
       }
       return -1;
    }

}
