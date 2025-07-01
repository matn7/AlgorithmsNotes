class Solution:
    # O(n log(n)) time | O(n) space
    def canAttendMeetings(self, intervals):
        if len(intervals) == 0:
            return True
        
        intervals.sort(key=lambda i: i.start)

        currMeetingEnd = intervals[0].end

        for i in range(1, len(intervals)):
            newMeeting = intervals[i]
            if currMeetingEnd > newMeeting.start:
                return False
            currMeetingEnd = newMeeting.end
        
        return True

class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end

intervals = []
intervals.append(Interval(0, 30))
intervals.append(Interval(5, 10))
intervals.append(Interval(15, 20))

solution = Solution()
print(solution.canAttendMeetings(intervals))

