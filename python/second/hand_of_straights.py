import heapq
from collections import defaultdict
class Solution(object):
    # O(nlog(n)) time | O(n) space
    def isNStraightHand(self, hand, groupSize):
        """
        :type hand: List[int]
        :type groupSize: int
        :rtype: bool
        """
        freqMap = defaultdict(int)
        for h in hand:
            freqMap[h] += 1
        
        minHeap = []
        for f in freqMap.keys():
            heapq.heappush(minHeap, f)
        
        while minHeap:
            first = minHeap[0]
            for i in range(first, first + groupSize):
                if i not in freqMap:
                    return False
                freqMap[i] -= 1
                if freqMap[i] == 0:
                    del freqMap[i]
                    heapq.heappop(minHeap)
        return True
    
solution = Solution()
hand = [1,2,3,6,2,3,4,7,8]
groupSize = 3
print(solution.isNStraightHand(hand, groupSize))