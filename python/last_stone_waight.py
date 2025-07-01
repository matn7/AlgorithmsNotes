import heapq
class Solution(object):
    # O(n log(n)) time | O(n) space
    def lastStoneWeight(self, stones):
        """
        :type stones: List[int]
        :rtype: int
        """
        minHeap = [-1 * stone for stone in stones]
        heapq.heapify(minHeap)

        while len(minHeap) >= 2:
            a = heapq.heappop(minHeap)
            b = heapq.heappop(minHeap)
            size = abs(a) - abs(b)
            if size > 0:
                heapq.heappush(minHeap, -1 * size)

        return abs(minHeap[0]) if minHeap else 0

        
stones = [2, 7, 4, 1, 8, 1]

solution = Solution()
print(solution.lastStoneWeight(stones))