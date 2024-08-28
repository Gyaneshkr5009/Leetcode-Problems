//space complexity:O(k)
//time complexity:O(n)
//********************************************************************************************************************************************
public static int kDistinctChars(int k, String str) {
		int window=0;
		int l=0;
		int r=0;
		HashMap<Character,Integer> mpp=new HashMap<>();
		while(r<str.length()){
			mpp.put(str.charAt(r), mpp.getOrDefault(str.charAt(r), 0)+1);
			while(l<r && mpp.size()>k){
				mpp.put(str.charAt(l), mpp.get(str.charAt(l))-1);
				if(mpp.get(str.charAt(l))==0){
					mpp.remove(str.charAt(l));
				}
				l++;
			}
			window=Math.max(window, r-l+1);
			r++;
		}
		return window;
	}
