class Solution {
    public List<String> removeSubfolders(String[] folder) {
        if(folder==null ||folder.length==0) return new ArrayList<>();

        //creating a set to store all folders , that can be used to check for the subfolder;
        //result to store all unique folders;
        Set<String> folderSet=new HashSet<>(Arrays.asList(folder));
        List<String> ans=new ArrayList<>();

        //iterate over each array in the array;
        for(String currFolder:folder){
            boolean isSubFolder=false;
            String tempFolder=currFolder;

            //checking the subFolder in our currFolder;
            // eq: /a/b/c -->  /a/b --> /a --> exit loop
            while(!currFolder.isEmpty()){
                int position = currFolder.lastIndexOf('/');
                if(position == -1) break;
                //trimming the currFolder;
                currFolder = currFolder.substring(0 , position);

                //if the subFolder already exist in the set then marking that as subFolder;
                if(folderSet.contains(currFolder)){
                    isSubFolder=true;
                    break;
                }
            }
            //if the subFolder is false add it to ans list;
            if(isSubFolder==false){
                ans.add(tempFolder);
            }
        }
        return ans;
    }
}
