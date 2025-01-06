class Solution {
    public String capitalizeTitle(String title) {
        if(title==null || title.length()==0) return "";
        StringBuilder result = new StringBuilder();
        for (String word : title.toLowerCase().split(" ")) {
            if (word.length() > 2) {
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1));
            } else {
                result.append(word);
            }
            result.append(" "); 
        }
        return result.toString().trim();
    }
}
