class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //Sort by end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int[] lastInterval = intervals[0];
        int count = 0;
        for(int i = 1; i<intervals.length;i++){
            int[] currentInterval = intervals[i];
            if(currentInterval[0] < lastInterval[1]) {
                count++;
            } else {
                lastInterval = currentInterval;
            }
            
        }
        return count;
    }
}