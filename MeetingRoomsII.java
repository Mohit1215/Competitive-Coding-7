/*
time complexity: O(NlogN) where N is the number of intervals
space complexity : O(N)

approach:
we first sort the array as we have to go allotting the rooms as time progresses
so lower time will be allotted room first. Then for allotting we check which
is the meeting that finishes first if it's end time is still greater than
the incoming interval's start time then we allot a new room else we utilize the
room that has already been allotted and is now free to use.
*/

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int m = intervals.length;

        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);

        int rooms = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

       for(int i = 0; i < m;i++) {

          int[] curr = intervals[i];

            if(!pq.isEmpty() && curr[0] >= pq.peek()[1]){
                pq.poll();
            }
            else{
                rooms += 1;
            }

           pq.add(curr);
        }


        return rooms;
    }
}
