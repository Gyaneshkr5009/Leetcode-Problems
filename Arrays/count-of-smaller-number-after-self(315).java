//time complexity:O(nlogn)
//space complexity:O(n)
//*******************************************************************************************************************************************
class Solution {
    private List<Integer> ans;
    private int[] indexes;
    
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        ans = new ArrayList<>(Collections.nCopies(n, 0));
        indexes = new int[n];
        
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        
        mergeSort(nums, 0, n - 1);
        return ans;
    }
    
    private void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }
    
    private void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int[] tempIndexes = new int[high - low + 1];
        int left = low, right = mid + 1, k = 0;
        int rightCounter = 0;
        
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k] = arr[left];
                tempIndexes[k] = indexes[left];
                ans.set(indexes[left], ans.get(indexes[left]) + rightCounter);
                left++;
            } else {
                temp[k] = arr[right];
                tempIndexes[k] = indexes[right];
                rightCounter++;
                right++;
            }
            k++;
        }
        
        while (left <= mid) {
            temp[k] = arr[left];
            tempIndexes[k] = indexes[left];
            ans.set(indexes[left], ans.get(indexes[left]) + rightCounter);
            left++;
            k++;
        }
        
        while (right <= high) {
            temp[k] = arr[right];
            tempIndexes[k] = indexes[right];
            right++;
            k++;
        }
        
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
            indexes[i] = tempIndexes[i - low];
        }
    }
}
