/**
 *
 * Greedy Intuition:
 * -----------------
 * Goal: Remove the minimum number of intervals so that the remaining
 * intervals do not overlap.
 *
 * Key Observation:
 * Instead of thinking "which interval should I remove?",
 * think "which interval should I keep?"
 *
 * We always keep the interval that finishes EARLIEST because:
 * - It leaves maximum space for future intervals.
 * - This maximizes the number of non-overlapping intervals.
 *
 * Algorithm:
 * ----------
 * 1. Sort intervals by END time.
 * 2. Keep the first interval.
 * 3. For every next interval:
 *      - If current.start < last.end
 *          -> Overlap found.
 *          -> Remove current interval (count++).
 *          -> Do NOT update last interval because the previous one
 *             ends earlier and is always a better choice.
 *
 *      - Else
 *          -> No overlap.
 *          -> Keep current interval.
 *          -> Update lastInterval = currentInterval.
 *
 * Example:
 * --------
 * [1,2], [2,3], [1,3], [3,4]
 *
 * Keep [1,2]
 * Keep [2,3]
 * Remove [1,3]   (overlap)
 * Keep [3,4]
 *
 * Answer = 1
 *
 * Time Complexity : O(n log n)
 * Space Complexity: O(1) (Ignoring sorting space)
 */

 class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int[] lastInterval = intervals[0];
        int count = 0;

        for (int i = 1; i < intervals.length; i++) {

            int[] currentInterval = intervals[i];

            // Overlap -> remove current interval
            if (currentInterval[0] < lastInterval[1]) {
                count++;
            } else {
                // No overlap -> keep current interval
                lastInterval = currentInterval;
            }
        }

        return count;
    }
 }