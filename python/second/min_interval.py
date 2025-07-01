import heapq

class Solution(object):
    # O(nlog(n) + mlog(m)) time | O(n + m) space
    def minInterval(self, intervals, queries):
        """
        :type intervals: List[List[int]]
        :type queries: List[int]
        :rtype: List[int]
        """
        intervals.sort()
        sortedQueries = [0] * len(queries)
        for i in range(len(queries)):
            sortedQueries[i] = [queries[i], i]
        sortedQueries.sort()

        minHeap = []

        j = 0
        res = [0] * len(queries)

        for i in range(len(sortedQueries)):
            query = sortedQueries[i][0]
            while j < len(intervals) and query >= intervals[j][0]:
                dist = intervals[j][1] - intervals[j][0] + 1
                heapq.heappush(minHeap, (dist, intervals[j][1]))
                j += 1
            
            while len(minHeap) > 0 and minHeap[0][1] < query:
                heapq.heappop(minHeap)
            
            idx = sortedQueries[i][1]
            if len(minHeap) == 0:
                res[idx] = -1
            else:
                res[idx] = minHeap[0][0]

        return res

solution = Solution()
#intervals = [[1,4],[2,4],[3,6],[4,4]]
#queries = [2,3,4,5]

intervals = [[2,3],[2,5],[1,8],[20,25]]
queries = [2,19,5,22]

print(solution.minInterval(intervals, queries))