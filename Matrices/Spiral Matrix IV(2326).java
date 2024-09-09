//time complexity:O(n*m)
//space complexity:O(n*m)
//*******************************************************************************************************************************
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans=new int[m][n];
        ListNode temp= head;
        int row=0 , col=0;
        int lastrow=m-1 , lastcol=n-1;
        int dir=0;
        while(row <= lastrow && col <= lastcol){
            if(dir==0){
                for(int i=col;i<=lastcol;i++){
                    ans[row][i] = (temp != null ? temp.val : -1);
                    if(temp!=null) temp=temp.next;
                }
                row+=1;
            }
            else if(dir==1){
                for(int i=row;i<=lastrow;i++){
                    ans[i][lastcol] = (temp != null ? temp.val : -1);
                    if(temp!=null) temp=temp.next;
                }
                lastcol-=1;
            }
            else if(dir==2){
                for(int i=lastcol;i>=col;i--){
                    ans[lastrow][i] =(temp != null ? temp.val : -1);
                    if(temp!=null) temp=temp.next;
                }
                lastrow-=1;
            }
            else if(dir==3){
                for(int i=lastrow;i>=row;i--){
                    ans[i][col] =(temp != null ? temp.val : -1);
                    if(temp!=null) temp=temp.next;
                }
                col+=1;
            }
            dir=(dir+1)%4;
        }
        return ans;
    }
}
