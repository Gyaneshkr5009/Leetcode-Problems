//Time Complexity: O((m+n)log⁡(m+n))
//Space Complexity: O(m+n)
//*********************************************************************************(Brute Force)************************************************************************************
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0,j=0;
        int[] arr=new int[nums1.length+nums2.length];
        System.arraycopy(nums1,0,arr,0,nums1.length);
        System.arraycopy(nums2,0,arr,nums1.length,nums2.length);
        Arrays.sort(arr);
        int l=arr.length;
        double med=0;
        if(l%2==0){
            med=arr[l/2]+arr[l/2-1];
            return med/2;
        }
        else{
            med=arr[l/2];
            return med;
        }
    }
}


//time complexity:O(n+m);
//space complexity:O(n+m);
//******************************************************************************(optimal approach)*******************************************************************
import java.util.*;
class Solution {
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] mergedArray = merge(nums1, nums2);
        int length = mergedArray.length;
        double median;

        if (length % 2 == 0) {
            median = (mergedArray[length / 2 - 1] + mergedArray[length / 2]) / 2.0;
        } else {
            median = mergedArray[length / 2];
        }

        return median;

	}
    public static int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] mergedArray = new int[m + n];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                mergedArray[k++] = nums1[i++];
            } else {
                mergedArray[k++] = nums2[j++];
            }
        }

        while (i < m) {
            mergedArray[k++] = nums1[i++];
        }

        while (j < n) {
            mergedArray[k++] = nums2[j++];
        }

        return mergedArray;
    }
}

//time complexity:O(log(min(n ,m);
//space complexity:O(1);
//***********************************************************************************************(best optimal approach)*************************************************************************
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        //if n1 is bigger swap the arrays:
        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int n = n1 + n2; //total length
        int left = (n1 + n2 + 1) / 2; //length of left half
        //apply binary search:
        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            //calculate l1, l2, r1 and r2;
            int l1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? nums2[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2);
                else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0;
    }
}
