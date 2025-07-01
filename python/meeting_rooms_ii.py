import heapq
class Solution:
    # O(n log(n)) time | O(n) space
    def minMeetingRooms(self, intervals):
        rooms = []

        intervals.sort(key=lambda x : x.start)

        for interval in intervals:
            if len(rooms) == 0:
                heapq.heappush(rooms, interval.end)
            else:
                peek = rooms[0]
                if interval.start >= peek:
                    heapq.heappop(rooms)
                
                heapq.heappush(rooms, interval.end)

        return len(rooms)

class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end


intervals = []
intervals.append(Interval(0, 40))
intervals.append(Interval(5, 10))
intervals.append(Interval(15, 20))

solution = Solution()
print(solution.minMeetingRooms(intervals))
