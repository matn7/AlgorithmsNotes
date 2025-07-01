class Solution(object):
    # O(n log(n)) time | O(n) space
    def insert(self, intervals, newInterval):
        """
        :type intervals: List[List[int]]
        :type newInterval: List[int]
        :rtype: List[List[int]]
        """
        intervals.sort()

        res = []
        added = False
        for curr in intervals:
            if added or curr[1] < newInterval[0]:
                res.append(curr)
            elif curr[0] > newInterval[1]:
                res.append(newInterval)
                res.append(curr)
                added = True
            else:
                newInterval[0] = min(newInterval[0], curr[0])
                newInterval[1] = max(newInterval[1], curr[1])
        if not added:
            res.append(newInterval)
        return res

solution = Solution()
intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]]
newInterval = [4,8]
print(solution.insert(intervals, newInterval))
