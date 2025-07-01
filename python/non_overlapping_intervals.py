class Solution(object):
    # O(n log()) time | O(n) space
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
            if start >= prevEnd:
                prevEnd = end
            else:
                res += 1
                prevEnd = min(prevEnd, end)
        return res


intervals = [[1,2],[2,3],[3,4],[1,3]]

solution = Solution()
print(solution.eraseOverlapIntervals(intervals))