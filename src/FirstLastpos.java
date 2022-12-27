import java.util.Arrays;

public class FirstLastpos{
    public static void main(String[] args){
        int[] numbs = {1,2,3,4,5,5,5,5,5,5,6,7,8,9};
        System.out.println(Arrays.toString(bounds(numbs,5)));
    }

    static int[] bounds(int[] array,int target){
        int[] ans = {-1,-1};
        ans[0] = searchindex(array,target,true);
        if (ans[0] != -1){
            ans[1] = searchindex(array,target,false);
        }
        return ans;
    }

    static int searchindex(int[] array,int target,boolean searchfirstpos){
        int ans = -1;
        int start = 0;
        int end = array.length-1;
        while (start <= end){
            int mid = start+(end-start)/2;
            if (target<array[mid]){
                end = mid-1;
            }else if(target > array[mid]){
                start = mid+1;
            }else{
                ans = mid;
                if (searchfirstpos){
                    end = mid-1;
                }else {
                    start = mid+1;
                }
            }
        }
        return ans;
    }

}