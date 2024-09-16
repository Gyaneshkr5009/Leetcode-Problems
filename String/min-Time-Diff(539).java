class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutesList = new ArrayList<>();
        for (String time : timePoints) {
            String[] parts = time.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            int totalMinutes = hours * 60 + minutes;
            minutesList.add(totalMinutes);
        }
        Collections.sort(minutesList);

        int minDifference = Integer.MAX_VALUE;
        for (int i = 1; i < minutesList.size(); i++) {
            minDifference = Math.min(minDifference, minutesList.get(i) - minutesList.get(i - 1));
        }

        int firstLastDifference = 1440 - Math.abs(minutesList.get(minutesList.size() - 1) - minutesList.get(0));
        minDifference = Math.min(minDifference, firstLastDifference);
        return minDifference;
    }
}
