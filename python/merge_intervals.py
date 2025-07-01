class Solution(object):
    # O(n log(n)) time | O(n) space
    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        res = []
        intervals.sort()
        for newInterval in intervals:
            if len(res) == 0:
                res.append(newInterval)
            else:
                curr = res[-1]
                if newInterval[0] <= curr[1]:
                    curr[0] = min(curr[0], newInterval[0])
                    curr[1] = max(curr[1], newInterval[1])
                else:
                    res.append(newInterval)

        return res
    
solution = Solution()
intervals = [[1,3],[2,6],[8,10],[15,18]]
print(solution.merge(intervals))    