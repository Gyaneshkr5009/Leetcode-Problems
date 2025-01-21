class Solution {
    public long gridGame(int[][] grid) {
        long firstRowRemainSum = 0;
        for (int num : grid[0]) {
            firstRowRemainSum += num;
        }

        long secondRowRemainSum = 0;
        long minimizedRobot2Sum = Long.MAX_VALUE;
        for (int Robot1Col = 0; Robot1Col < grid[0].length; Robot1Col++) {
            // Robot1 took this strategy
            firstRowRemainSum -= grid[0][Robot1Col];

            long bestOfRobot2 = Math.max(firstRowRemainSum, secondRowRemainSum);

            minimizedRobot2Sum = Math.min(minimizedRobot2Sum, bestOfRobot2);

            secondRowRemainSum += grid[1][Robot1Col];
        }

        return minimizedRobot2Sum;
    }
}
