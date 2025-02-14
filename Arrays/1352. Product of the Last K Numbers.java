class ProductOfNumbers {
    private List<Integer> prefixProd;

    public ProductOfNumbers() {
        prefixProd=new ArrayList<>();
        prefixProd.add(1);
    }
    
    public void add(int num) {
        if(num==0){
            prefixProd.clear();
            prefixProd.add(1);
        }
        else{
            prefixProd.add(prefixProd.get(prefixProd.size()-1) * num);
        }
    }
    
    public int getProduct(int k) {
        int size=prefixProd.size();
        if(k>=size) return 0; //means we have encounter zero before;
        else{
            //just return the last prefix product we got divide with the kth-1 idx to get the desired product;
            return prefixProd.get(prefixProd.size()-1)/ prefixProd.get(size-k-1); 
        }
    }
}
