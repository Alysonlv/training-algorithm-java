package alv.algorithmictoolbox.week4;
import java.util.*;

/*
 * NOT OK YET
 */

class Inversions {

    private static int getNumberOfInversions(int[] a, int[] b, int[] mergeArr, int left, int right) {
        int numberOfInversions = 0;
        if (right <= left + 1) {
            return numberOfInversions;
        }
        //divide and conquer  nlogn
        int mid = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, b, mergeArr, left, mid);
        numberOfInversions += getNumberOfInversions(a, b, mergeArr, mid, right);
        numberOfInversions += merge(b, mergeArr, left, mid, right);

        return numberOfInversions;
    }


    private static int getNumberOfInversions(int[] arr){
        int[] b = arr.clone();
        int[] mergeArr = new int[arr.length];
        return getNumberOfInversions(arr, b, mergeArr, 0, arr.length-1);
    }


    private static int merge(int[] b, int[] mergeArr, int left, int mid, int right){
        int numberOfInversions = 0;

        // copy to merge array so original array is not altered
        for (int x = left; x <= right; x++) {
            mergeArr[x] = b[x];
        }

        // merge sort back to b[]  nlogn
        int i = left, j = mid+1;
        for (int x = left; x <= right; x++) {
            if (i > mid) {
                b[x] = mergeArr[j++];
            } else if (j > right) {
                b[x] = mergeArr[i++];
            } else if (mergeArr[j] < mergeArr[i]) {
                b[x] = mergeArr[j++];
                numberOfInversions += (mid - i + 1);   // inverted.  add 'em up.
            } else {
                b[x] = mergeArr[i++];
            }
        }
        return numberOfInversions;
    }


    private static void permutations(int[] arr, int currIndex, int k){
        int size = arr.length;
        if (size == currIndex + 1){
            if( getNumberOfInversions(arr) == k){  // does this permutation have the requested count of inversions?
                for (int i = 0; i < arr.length; i++){
                    System.out.printf("%d ", arr[i]);
                }
                System.out.println();
            }
        } else {
            for (int i = currIndex; i< size; i++){
                int temp = arr[i];
                arr[i] = arr[currIndex];
                arr[currIndex] = temp;
                permutations(arr, currIndex+1, k);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++){
            a[i] = i+1;
        }
        permutations(a,0,k);
    }
}


