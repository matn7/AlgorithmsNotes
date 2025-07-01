class Solution(object):
    # O(n) time | O(1) space
    def insert(self, intervals, newInterval):
        """
        :type intervals: List[List[int]]
        :type newInterval: List[int]
        :rtype: List[List[int]]
        """
        res = []
        if not intervals:
            res.append(newInterval)
            return res
        
        inserted = False
        for curr in intervals:
            if curr[1] < newInterval[0] or inserted:
                res.append(curr)
            elif curr[0] > newInterval[1]:
                res.append(newInterval)
                res.append(curr)
                inserted = True
            else:
                newInterval[0] = min(curr[0], newInterval[0])
                newInterval[1] = max(curr[1], newInterval[1])

        if not inserted:
            res.append(newInterval)

        return res

intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]]
newInterval = [4,8]
solution = Solution()
print(solution.insert(intervals, newInterval))