class Solution {
    public int maximumLength(String s) {
        int n=s.length();
        List<String>[] substr=new ArrayList[n];

        //we try to add all possible special substring from a perticular index;

        for(int i=0;i<n ;i++){
            StringBuilder current=new StringBuilder();
            int j=i;
            List<String> list=new ArrayList<>();

            while(j<n && s.charAt(j)==s.charAt(i)){
                current.append(s.charAt(j));
                list.add(current.toString());
                j++;
            }
            substr[i]=list;
        }

        //now we calculate the occurence of all substring into HashMap;
        HashMap<String , Integer> substrFreq=new HashMap<>();

        for(List<String> ls : substr){
            for(String st:ls){
                substrFreq.put(st , substrFreq.getOrDefault(st, 0)+1);
            }
        }

        //check the string that have a frequency >=3;
        int length=-1;
        for(String key:substrFreq.keySet()){
            if(substrFreq.get(key)>=3){
                length=Math.max(length , key.length());
            }
        }
        return length;
    }
}
