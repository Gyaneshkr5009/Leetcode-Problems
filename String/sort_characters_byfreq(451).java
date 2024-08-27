//Time Complexity: O(n+mlog⁡m)O(n+mlogm) or O(nlog⁡n)O(nlogn) in the worst case.
//Space Complexity: O(n)O(n).
//*********************************************************************************************************************************
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Convert the frequency map to a list of pairs (or entries)
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(frequencyMap.entrySet());

        // Sort the list by frequency in descending order
        Collections.sort(list, (a, b) -> b.getValue().compareTo(a.getValue()));

        // Build the result string
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                result.append(entry.getKey());
            }
        }

        return result.toString();
    }
}
