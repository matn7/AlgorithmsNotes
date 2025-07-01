class Solution(object):
    # O(nlog(n)) time | O(n) space
    def eraseOverlapIntervals(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: int
        """
        intervals.sort()

        prevEnd = intervals[0][1]
        res = 0
        for i in range(1, len(intervals)):
            start = intervals[i][0]
            end = intervals[i][1]
            if start < prevEnd:
                prevEnd = min(prevEnd, end)
                res += 1
            else:
                prevEnd = end
        return res


solution = Solution()
intervals = [[1,2],[2,3],[3,4],[1,3]]
print(solution.eraseOverlapIntervals(intervals))