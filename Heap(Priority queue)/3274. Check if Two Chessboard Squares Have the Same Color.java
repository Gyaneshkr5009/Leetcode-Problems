class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        return getColorValue(coordinate1)==getColorValue(coordinate2);
    }
    private static int getColorValue(String square){
        char column=square.charAt(0);
        int row=Character.getNumericValue(square.charAt(1));
        int columnValue=column-'a'+1;
        return (columnValue+row)%2;
    }
}
