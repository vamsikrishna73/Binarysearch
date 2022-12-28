//finding the peak element inn tha mountain array

public class Moutainarray {

    public static void main(String[] args) {

        int[] array = {1,3,5,7,9,12,13,11,7,4,2};
        System.out.println(bitonicarray(array));

    }


    static int bitonicarray(int[] array){

        int start = 0;
        int end = array.length-1;
        while (start<end){
            int mid = start+(end-start)/2;
            if (array[mid]<array[mid+1]){
                //you are in ascending part of array
                //check the right part of the array starting from mid+1
                start = mid+1;
            } else if (array[mid]>array[mid+1]) {
                //you are in descending part of array
                //this may be the answerc but look at the left part of array
                //that is why end != mid-1
                end = mid;
            }
        }
        //in the end start == end pointing too the max element in array
        //because of the two checks above
        //start and end are always trying to find the max element in above two checks
        //when both are pointing to same element that is the max one because that is the what the checks say
        //at every point of time for start and end have the best possible answer till that time
        //so when only one item is remaining,beacause of the above line that is the best possible answer
        return array[start]; //or you can return array[end] //u may return the index
    }
}
