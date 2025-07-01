import heapq
class Solution(object):
    # O(n log(k)) time | O(n) space
    def kClosest(self, points, k):
        """
        :type points: List[List[int]]
        :type k: int
        :rtype: List[List[int]]
        """
        minHeap = []
        for x, y in points:
            dist = (x ** 2) + (y ** 2)
            minHeap.append([dist, x, y])
        
        heapq.heapify(minHeap)
        res = []
        for i in range(k):
            dist, x, y = heapq.heappop(minHeap)
            res.append([x, y])
        return res


points = [[3,3],[5,-1],[-2,4]]
k = 2
solution = Solution()
print(solution.kClosest(points, k))