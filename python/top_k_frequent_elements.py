import heapq
from collections import defaultdict

# O(nlog(k)) | O(n + k) space
class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        counts = defaultdict(int)
        for num in nums:
            counts[num] = 1 + counts.get(num, 0)
        
        heap = []
        for num in counts.keys():
            heapq.heappush(heap, (counts[num], num))
            if len(heap) > k:
                heapq.heappop(heap)
        
        res = []
        for i in range(k):
            res.append(heapq.heappop(heap)[1])
        return res
    
topK = Solution()

print(topK.topKFrequent([1,1,1,2,2,3], 2))