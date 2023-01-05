import java.util.Arrays;
import java.util.Scanner;

public class SplitarrayLargestsum {

    public static void main(String[] args) {

        int[] array = new int[6];
        System.out.println("enter the elements of array:");
        Scanner in  = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            array[i] = in.nextInt();
        }
        System.out.print("enter the no of splits:");
        int m = in.nextInt();
        System.out.println(Arrays.toString(array));
        System.out.println(splitsum(array,m));

    }

    //we have to find the least greatest sum possibble for a subarray in the given array with 'm' no of splits
    //the given array might not be sorted--->doesnt make any difference
    //the required sum exists bw two bounds....1)lower bound = max element of array(in the case m == array.length)
                                                //2)upper bound = sum of all elements in the array
    //we use binary search to get the answer--->we split the array based on the value of mid
    //we do this until we reach a point where start == mid == end
    //at every step we check if the no of sub arrays are exceeding 'm' or not and update the 'mid' value
    //return mid...the req sum



    static int splitsum(int[] array,int m){            //m = no of divisions required
        int start = 0;
        int end = 0;
        for (int ele : array) {
            start = Math.max(start,ele);
            end += ele;
        }
        while(start<end){
            int sum = 0;
            int pieces = 1;                 //pieces == 1 ---> the whole array....you cannot assign 0 to pieces
            int mid = start+(end-start)/2;
            for (int ele:array) {
                if (sum+ele > mid){
                    sum = ele;
                    pieces++;               //no of subarrays
                }else {
                    sum += ele;
                }
            }
            if (pieces > m){
                start = mid+1;              //if the no of subarrays are greater than the given no--->increase the value of mid(which in turn decreaes the no of subarrays)
            }else{
                end = mid;                  //if the no of subarrays are less than or equal to m---->decrease the value of m
                                            //cuz even though no of subarrays == m;u don't if it is the smallest sum possible
            }
        }                                   //at last start,end,mid point to same value---->which is the least greatest sum possible in the array with m subarrays
        return start;
    }
}
