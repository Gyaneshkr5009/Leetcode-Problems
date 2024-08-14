class Solution {
  public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
    // code here
    int res[] = new int [queries];
    
    for(int i = 0; i < queries; i++){       //indies
        int num = arr[indices[i]];          //value of that index in array
        int count = 0;                      //to count no of greater
        for(int j = indices[i]+1; j < N; j++){  //from index+1 to n
            if(arr[j] > num){
                count++;
            }
        }
        res[i] = count;                     //count is given to res array 
    }
     return res;
  }
} 
